package de.vik.testrail2java.serialization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class FieldExclusionStrategy implements ExclusionStrategy {
    private final Set<String> fieldNames;

    public FieldExclusionStrategy(String... fieldNames) {
        this.fieldNames = new HashSet<String>(Arrays.asList(fieldNames));
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return !containsField(f.getName());
    }

    private boolean containsField(String name) {
        return fieldNames.contains(name);
    }
}
