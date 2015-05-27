package de.vik.testrail2java.serialization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AllowedFields {
	private Map<Class<?>, Set<String>> fieldMapping = new HashMap<>();

	public AllowedFields(Class<?> clazz, String... fields) {
		fieldMapping.put(clazz, asSet(fields));
	}

	protected AllowedFields(Class<?> clazz, String[] fields, AllowedFields otherFields) {
		this(clazz, fields);
		fieldMapping.putAll(otherFields.fieldMapping);
	}

	public AllowedFields and(Class<?> clazz, String... fields) {
		return new AllowedFields(clazz, fields, this);
	}

	public boolean isFieldMapped(Class<?> clazz, String fieldName) {
		return fieldMapping.containsKey(clazz)
				&& fieldMapping.get(clazz).contains(fieldName);
	}

	private Set<String> asSet(String[] fields) {
		//sorted for better comparison of items in failing tests
		return new TreeSet<>(Arrays.asList(fields));
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


