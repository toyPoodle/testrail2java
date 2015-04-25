package de.vik.testrail2java.serialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import de.vik.testrail2java.net.ClassUtils;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.TestRailException;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


public class NumericIdAdapter implements JsonDeserializer<NumericId>, JsonSerializer<NumericId> {
    public NumericId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        if (!(typeOfT instanceof Class)) {
            throw new TestRailException("cannot deserialize " + typeOfT);
        }
        final Class<?> type = (Class) typeOfT;
        try {
            final Constructor<?> constructor = type.getConstructor(int.class);
            return (NumericId) constructor.newInstance(json.getAsJsonPrimitive().getAsInt());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new TestRailException(e);
        }
    }

    @Override
    public JsonElement serialize(NumericId src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.asInt(), int.class);
    }
}
