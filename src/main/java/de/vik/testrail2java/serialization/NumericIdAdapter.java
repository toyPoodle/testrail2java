package de.vik.testrail2java.serialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import de.vik.testrail2java.TestRailException;
import de.vik.testrail2java.types.primitive.NumericId;


public class NumericIdAdapter implements JsonDeserializer<NumericId>, JsonSerializer<NumericId> {

    public NumericId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        if (!(typeOfT instanceof Class)) {
            throw new TestRailException("cannot deserialize " + typeOfT);
        }
        final Class<?> type = (Class) typeOfT;
        final int id = json.getAsJsonPrimitive().getAsInt();
        try {
            final Constructor<?> constructor = type.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            return (NumericId) constructor.newInstance(id);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new TestRailException(e);
        }
    }

    @Override
    public JsonElement serialize(NumericId src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.asInt(), int.class);
    }
}
