package de.vik.testrail2java.net;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class APIClientTest {

    @Test
    public void getObject() throws Exception {
        APIClient target = targetForGet(someUri(), "{\"field\":\"value\"}");

        final TestClass actual = target.get(TestClass.class, someUri());

        assertThat(actual.getField(), equalTo("value"));
    }

    @Test
    public void getArrayOfObjects() throws Exception {
        APIClient target = targetForGet(someUri(), "[{\"field\":\"value 1\"},{\"field\":\"value 2\"}]");

        final List<TestClass> actual = target.getList(TestClass.class, someUri());

        assertThat(actual, hasSize(2));
        assertThat(actual.get(0).getField(), equalTo("value 1"));
        assertThat(actual.get(1).getField(), equalTo("value 2"));
    }

    @Test
    public void post() throws Exception {
        RestClient restClient = mock(RestClient.class);
        GsonBuilder gsonBuilder = new GsonBuilder();
        final APIClient target = new APIClient(restClient, gsonBuilder);

        target.post(someUri());

        verify(restClient, Mockito.times(1)).sendPost(someUri(), null);
    }

    @Test
    public void postWithData() throws Exception {
        RestClient restClient = mock(RestClient.class);
        JsonObject jsonElement = new JsonObject();
        jsonElement.addProperty("field", "result");
        when(restClient.sendPost(someUri(), "{\n  \"field\": \"value\"\n}")).thenReturn(jsonElement);
        GsonBuilder gsonBuilder = new GsonBuilder();
        final APIClient target = new APIClient(restClient, gsonBuilder);

        final TestClass data = new TestClass("value");
        final String[] allowedFields = {"field"};

        TestClass actual = target.post(someUri(), data, allowedFields, TestClass.class);

        assertThat(actual.getField(), equalTo("result"));

        //only submit once
        verify(restClient, Mockito.times(1)).sendPost(someUri(), "{\n  \"field\": \"value\"\n}");
    }

    @Test
    public void objectArrayAsList() throws Exception {
        TestClass[] array = {new TestSubclass(""), new TestSubclass("")};
        APIClient target = new APIClient(ignoredClient(), ignoredGson());

        List<TestClass> actual = target.asList(array);

        assertThat(actual, hasSize(2));
        assertThat(actual.get(0), equalTo(array[0]));
        assertThat(actual.get(1), equalTo(array[1]));
    }

    private APIClient targetForGet(MethodUri uri, String json) throws IOException {
        RestClient restClient = mock(RestClient.class);
        JsonElement jsonElement = new JsonParser().parse(json);
        when(restClient.sendGet(uri)).thenReturn(jsonElement);

        GsonBuilder gsonBuilder = new GsonBuilder();
        return new APIClient(restClient, gsonBuilder);
    }

    private GsonBuilder ignoredGson() {
        return null;
    }

    private RestClient ignoredClient() {
        return null;
    }

    private MethodUri someUri() {
        return new MethodUri("");
    }

    private static class TestClass {
        private String field;

        private TestClass(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }

        @Override
        public String toString() {
            return "TestClass{" +
                    "field='" + field + '\'' +
                    '}';
        }
    }

    private static class TestSubclass extends TestClass {
        private TestSubclass(String field) {
            super(field);
        }
    }
}