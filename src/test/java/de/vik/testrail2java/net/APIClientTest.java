package de.vik.testrail2java.net;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

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
        final APIClient target = new APIClient(restClient, new GsonBuilder());

        target.post(someUri());

        verify(restClient, Mockito.times(1)).sendPost(someUri(), null);
    }

    @Test
    public void postWithoutData() throws Exception {
        RestClient restClient = mock(RestClient.class);
        JsonElement response = response("{\"field\":\"value\"}");
        when(restClient.sendPost(someUri(), null)).thenReturn(response);

        APIClient target = new APIClient(restClient, new GsonBuilder());
        final TestClass actual = target.post(someUri(), TestClass.class);

        verify(restClient, times(1)).sendPost(someUri(), null);
        assertThat(actual.getField(), equalTo("value"));
    }

    @Test
    public void postWithData() throws Exception {
        RestClient restClient = mock(RestClient.class);
        final JsonElement response = response("{\"field\":\"result\"}");
        when(restClient.sendPost(someUri(), "{\n  \"field\": \"value\"\n}")).thenReturn(response);
        final APIClient target = new APIClient(restClient, new GsonBuilder());
        final TestClass data = new TestClass("value");
        final String[] allowedFields = {"field"};

        TestClass actual = target.post(someUri(), data, allowedFields, TestClass.class);

        assertThat(actual.getField(), equalTo("result"));
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
        when(restClient.sendGet(uri)).thenReturn(response(json));
        return new APIClient(restClient, new GsonBuilder());
    }

    private JsonElement response(String json) {
        return new JsonParser().parse(json);
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