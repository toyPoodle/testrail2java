/**
 * TestRail API binding for Java (API v2, available since TestRail 3.0)
 *
 * Learn more:
 *
 * http://docs.gurock.com/testrail-api2/start
 * http://docs.gurock.com/testrail-api2/accessing
 *
 * Copyright Gurock Software GmbH. See license.md for details.
 *
 * license.md content:
 *
 * License
 * -------
 *
 *  Copyright (c) 2010-2014 Gurock Software GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */
 
package de.vik.testrail2java.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import de.vik.testrail2java.TestRailException;

import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RestClient
{
	private String user;
	private String password;
	private String baseUrl;

	public RestClient(String baseUrl)
	{
		if (!baseUrl.endsWith("/"))
		{
			baseUrl += "/";
		}
		
		this.baseUrl = baseUrl + "index.php?/api/v2/";
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Send Get
	 *
	 * Issues a GET request (read) against the API and returns the result
	 * (as Object, see below).
	 *
	 * Arguments:
	 *
	 * uri The API method to call including parameters (e.g. get_case/1)
	 *
	 * Returns the parsed JSON response as standard object which can
	 * either be an instance of {@link JsonObject} or {@link com.google.gson.JsonArray} (depending on the
	 * API method). In most cases, this returns a {@link JsonObject} instance which
	 * is basically the same as {@link Map}.
	 */
	public JsonElement sendGet(MethodUri uri) {
		return this.sendRequest("GET", uri, null);
	}

	/**
	 * Send POST
	 *
	 * Issues a POST request (write) against the API and returns the result
	 * (as Object, see below).
	 *
	 * Arguments:
	 *
	 * uri 	The API method to call including parameters (e.g. add_case/1)
	 * data	The data to submit as part of the request as JSON
	 *
	 * Returns the parsed JSON response as standard object which can
	 * either be an instance of {@link JsonObject} or {@link com.google.gson.JsonArray} (depending on the
	 * API method). In most cases, this returns a {@link JsonObject} instance which
	 * is basically the same as {@link Map}.
	 */
	public JsonElement sendPost(MethodUri uri, String data) {
		return this.sendRequest("POST", uri, data);
	}

	/**
	 * Send POST
	 *
	 * Issues a POST request (write) against the API and returns the result
	 * (as Object, see below).
	 *
	 * Arguments:
	 *
	 * uri 	The API method to call including parameters (e.g. add_case/1)
	 * data	The data to submit as part of the request as map convertible to JSON
	 *
	 * Returns the parsed JSON response as standard object which can
	 * either be an instance of {@link JsonObject} or {@link com.google.gson.JsonArray} (depending on the
	 * API method). In most cases, this returns a {@link JsonObject} instance which
	 * is basically the same as {@link Map}.
	 */
	public Object sendPost(String uri, Map data) {
		return this.sendRequest("POST", new MethodUri(uri), new Gson().toJson(data));
	}

	private JsonElement sendRequest(String method, MethodUri uri, String data) {
		URL url;
		try {
			url = new URL(this.baseUrl + uri.insertParameters());
		} catch (MalformedURLException e) {
			throw new TestRailException("supplied url '" + this.baseUrl + uri.insertParameters() + "' seems to be incorrect", e);
		}

		try {
			HttpURLConnection conn = setupConnection(url);
			if ("POST".equals(method)) {
                writeData(data, conn);
            }
			String responseBody = readResponseBody(conn);
			JsonElement result = parseResult(responseBody);
			handleError(conn, result);
			return result;
		} catch (IOException e) {
			throw new TestRailException(e);
		}
	}

	private JsonElement parseResult(String responseBody) {
		if (responseBody.isEmpty()) {
			return new JsonObject();
		}
		return new JsonParser().parse(responseBody);
	}

	/*
		Create the connection object and set the required HTTP method
		(GET/POST) and headers (content type and basic auth).
	*/
	private HttpURLConnection setupConnection(URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.addRequestProperty("Content-Type", "application/json");
		String auth = getAuthorization(this.user, this.password);
		connection.addRequestProperty("Authorization", "Basic " + auth);
		return connection;
	}

	private void handleError(HttpURLConnection conn, JsonElement result) throws IOException {
		// Check for any occurred errors and add additional details to
		// the exception message, if any (e.g. the error message returned
		// by TestRail).
		final int responseCode = conn.getResponseCode();
		if (responseCode == 200) {
			return;
		}

		throw new TestRailException("TestRail API returned HTTP " + responseCode +
            "(" + errorMessageFrom(result) + ")"
        );
	}

	private String errorMessageFrom(JsonElement result) {
		if (result instanceof JsonObject)
        {
            JsonObject obj = (JsonObject) result;
            if (obj.has("error"))
            {
                return '"' + obj.get("error").toString() + '"';
            }
        }
		return "No additional error message received";
	}

	private String readResponseBody(HttpURLConnection connection) throws IOException {
		// Execute the actual web request (if it wasn't already initiated
		// by getOutputStream above) and record any occurred errors (we use
		// the error stream in this case).
		InputStream inputStream = getInputStream(connection);
		try {
			if (inputStream == null) {
				return "";
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ByteStreams.copy(inputStream, baos);
			return baos.toString("UTF-8");
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	private InputStream getInputStream(HttpURLConnection conn) throws IOException {
		final int status = conn.getResponseCode();
		if (status == 200) {
			return conn.getInputStream();
		}

		InputStream inputStream = conn.getErrorStream();
		if (inputStream != null) {
            return inputStream;
        }

		throw new TestRailException("TestRail API return HTTP " + status + " (No additional error message received)");
	}

	/*
	Add the POST arguments, if any. We just add serialized data object
	to the request body.
	*/
	private void writeData(String data, HttpURLConnection conn) throws IOException {
		if (data == null) {
			return;
		}

		byte[] block = getBytes(data);
		conn.setDoOutput(true);
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(block);
		outputStream.flush();
	}

	private static byte[] getBytes(String data) {
		try
		{
			return data.getBytes("UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			// shouldn't be the case for a JVM
			throw new TestRailException("UTF-8 encoding not supported");
		}
	}

	private static String getAuthorization(String user, String password) {
			return getBase64(getBytes(user + ":" + password));
	}
	
	private static String getBase64(byte[] buffer)
	{
		final char[] map = {
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '+', '/'
		};
	
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buffer.length; i++)
		{
			byte b0 = buffer[i++], b1 = 0, b2 = 0;

			int bytes = 3;
			if (i < buffer.length)
			{
				b1 = buffer[i++];
				if (i < buffer.length)
				{
					b2 = buffer[i];
				}
				else 
				{
					bytes = 2;
				}
			}
			else
			{
				bytes = 1;
			}
			
			int total = (b0 << 16) | (b1 << 8) | b2;
			
			switch (bytes)
			{
				case 3:
					sb.append(map[(total >> 18) & 0x3f]);
					sb.append(map[(total >> 12) & 0x3f]);
					sb.append(map[(total >> 6) & 0x3f]);
					sb.append(map[total & 0x3f]);
					break;
					
				case 2:
					sb.append(map[(total >> 18) & 0x3f]);
					sb.append(map[(total >> 12) & 0x3f]);
					sb.append(map[(total >> 6) & 0x3f]);
					sb.append('=');
					break;
					
				case 1:
					sb.append(map[(total >> 18) & 0x3f]);
					sb.append(map[(total >> 12) & 0x3f]);
					sb.append('=');
					sb.append('=');
					break;
			}
		}
	
		return sb.toString();
	}
}
