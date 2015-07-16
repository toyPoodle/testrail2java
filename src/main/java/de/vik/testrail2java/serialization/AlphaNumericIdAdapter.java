package de.vik.testrail2java.serialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import de.vik.testrail2java.TestRailException;
import de.vik.testrail2java.types.Plan;
import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.NumericId;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


public class AlphaNumericIdAdapter implements JsonDeserializer<Id>, JsonSerializer<Id> {
    public Id deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        if (!(typeOfT instanceof Class)) {
            throw new TestRailException("cannot deserialize " + typeOfT);
        }
        final Class<?> type = (Class) typeOfT;
        final String id = json.getAsJsonPrimitive().getAsString();
        try {
            final Constructor<?> constructor = type.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            return (Id) constructor.newInstance(id);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new TestRailException(e);
        }
        //return new Plan.PlanEntryId(json.getAsJsonPrimitive().getAsString());
    }

    @Override
    public JsonElement serialize(Id src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.getValue(), String.class);
    }
}
