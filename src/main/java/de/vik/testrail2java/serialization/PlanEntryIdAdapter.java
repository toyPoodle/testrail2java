package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import de.vik.testrail2java.types.Plan;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


public class PlanEntryIdAdapter implements JsonDeserializer<Plan.PlanEntryId>, JsonSerializer<Plan.PlanEntryId> {
    public Plan.PlanEntryId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return new Plan.PlanEntryId(json.getAsJsonPrimitive().getAsString());
    }

    @Override
    public JsonElement serialize(Plan.PlanEntryId src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.getValue(), String.class);
    }
}
