package de.vik.testrail2java.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.serialization.GsonBuilder;

import static de.vik.testrail2java.net.ClassUtils.arrayTypeFor;

public class APIClient implements APIClientInterface {

    private static final String NO_DATA = null;

    private final GsonBuilder gsonBuilder;
    private final RestClient client;

    public APIClient(RestClient client, GsonBuilder gsonBuilder) {
        this.client = client;
        this.gsonBuilder = gsonBuilder;
    }

    @Override
    public <T> T get(Class<T> resultType, MethodUri uri) {
        final JsonElement json = client.sendGet(uri);
        return deserializer().fromJson(json, resultType);
    }

    @Override
    public <T> List<T> getList(Class<T> resultType, MethodUri uri) {
        return asList(get(arrayTypeFor(resultType), uri));
    }

    @Override
    public <T, R> R post(MethodUri uri, T data, AllowedFields allowedFields, Class<R> resultType) {
        final String postData = serializer(allowedFields).toJson(data);
        final JsonElement response = post(uri, postData);
        return deserializer().fromJson(response, resultType);
    }

    @Override
    public <T, R> List<R> postList(MethodUri uri, T data, AllowedFields allowedFields, Class<R> resultType) {
        final String postData = serializer(allowedFields).toJson(data);
        final JsonElement response = post(uri, postData);
        return asList(deserializer().fromJson(response, arrayTypeFor(resultType)));
    }

    @Override
    public <T> T post(MethodUri uri, Class<T> resultType) {
        final JsonElement response = post(uri, NO_DATA);
        return deserializer().fromJson(response, resultType);
    }

    @Override
    public void post(MethodUri uri) {
        post(uri, NO_DATA);
    }

    private JsonElement post(MethodUri uri, String postData) {
        return client.sendPost(uri, postData);
    }

    private Gson deserializer() {
        return gsonBuilder.create();
    }

    private Gson serializer(AllowedFields allowedFields) {
        return gsonBuilder.createFor(allowedFields);
    }

    protected <T> List<T> asList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
