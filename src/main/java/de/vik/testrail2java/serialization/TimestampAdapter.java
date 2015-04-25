package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import de.vik.testrail2java.types.primitive.Timestamp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TimestampAdapter implements JsonDeserializer<Timestamp>, JsonSerializer<Timestamp> {
    @Override
    public Timestamp deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new Timestamp(jsonElement.getAsJsonPrimitive().getAsLong());
    }

    @Override
    public JsonElement serialize(Timestamp src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.getValue(), Long.TYPE);
    }
}
