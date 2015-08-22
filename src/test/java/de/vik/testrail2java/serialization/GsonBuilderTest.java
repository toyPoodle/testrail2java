package de.vik.testrail2java.serialization;

import org.junit.Test;

import com.google.gson.Gson;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class GsonBuilderTest {

    @Test
    public void htmlCharactersAreNotEncoded() throws Exception {
        final Gson gson = new GsonBuilder().createFor(new AllowedFields(TestClass.class, "field"));
        final String json = gson.toJson(new TestClass("<>&"));
        String expected = "{\n" +
                "  \"field\": \"<>&\"\n" +
                "}";
        assertThat(json, equalTo(expected));
    }

    private static final class TestClass {
        @SuppressWarnings("unused")
        private final String field;

        public TestClass(String field) {
            this.field = field;
        }
    }
}