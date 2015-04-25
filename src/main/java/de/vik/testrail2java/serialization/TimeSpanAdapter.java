package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import de.vik.testrail2java.types.primitive.TimeSpan;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TimeSpanAdapter implements JsonDeserializer<TimeSpan>, JsonSerializer<TimeSpan> {
    @Override
    public TimeSpan deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new TimeSpan(jsonElement.getAsJsonPrimitive().getAsString());
    }

    @Override
    public JsonElement serialize(TimeSpan src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.getValue(), String.class);
    }
}
