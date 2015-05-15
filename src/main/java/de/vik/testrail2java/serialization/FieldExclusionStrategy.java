package de.vik.testrail2java.serialization;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class FieldExclusionStrategy implements ExclusionStrategy {
    private final AllowedFields allowedFields;

    public FieldExclusionStrategy(AllowedFields allowedFields) {
        this.allowedFields = allowedFields;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return !isMapped(f.getDeclaringClass(), f.getName());
    }

    private boolean isMapped(Class<?> clazz, String name) {
        return allowedFields.isFieldMapped(clazz, name);
    }
}
