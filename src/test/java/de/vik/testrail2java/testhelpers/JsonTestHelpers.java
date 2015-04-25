package de.vik.testrail2java.testhelpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class JsonTestHelpers {

    public static JsonElement jsonPrimitive(final int value) {
        return new JsonPrimitive(value);
    }

    public static JsonElement jsonPrimitive(final String value) {
        return new JsonPrimitive(value);
    }

    public static JsonElement jsonPrimitive(final Long value) {
        return new JsonPrimitive(value);
    }
}
