package de.vik.testrail2java.serialization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllowedFields {
	private Map<Class<?>, List<String>> fieldMapping = new HashMap<>();

	public AllowedFields(Class<?> clazz, String... fields) {
		fieldMapping.put(clazz, Arrays.asList(fields));
	}

	protected AllowedFields(AllowedFields otherFields, Class<?> clazz, String[] fields) {
		fieldMapping.putAll(otherFields.fieldMapping);
		fieldMapping.put(clazz, Arrays.asList(fields));
	}

	public AllowedFields and(Class<?> clazz, String... fields) {
		return new AllowedFields(this, clazz, fields);
	}

	public boolean isFieldMapped(Class<?> clazz, String fieldName) {
		return fieldMapping.containsKey(clazz)
				&& fieldMapping.get(clazz).contains(fieldName);
	}

    @Override
	@SuppressWarnings("ControlFlowStatementWithoutBraces")
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AllowedFields that = (AllowedFields) o;

		return fieldMapping.equals(that.fieldMapping);
	}

	@Override
	public int hashCode() {
		return fieldMapping.hashCode();
	}

	@Override
	public String toString() {
		return "AllowedFields{" +
				"fieldMapping=" + fieldMapping +
				'}';
	}
}


