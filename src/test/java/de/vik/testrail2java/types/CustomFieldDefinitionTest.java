package de.vik.testrail2java.types;

import org.junit.*;
import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class CustomFieldDefinitionTest {

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "    \"configs\": [\n" +
                "    {\n" +
                "      \"context\": {\n" +
                "        \"is_global\": true,\n" +
                "        \"project_ids\": null\n" +
                "      },\n" +
                "      \"id\": \"1e484fac-97c2-4315-ac39-cca1e72aad36\",\n" +
                "      \"options\": {\n" +
                "        \"format\": \"markdown\",\n" +
                "        \"has_actual\": false,\n" +
                "        \"has_expected\": true,\n" +
                "        \"is_required\": false\n" +
                "      }\n" +
                "    }\n" +
                "    ],\n" +
                "    \"description\": \"a description\",\n" +
                "    \"display_order\": 1,\n" +
                "    \"id\": 5,\n" +
                "    \"label\": \"Steps\",\n" +
                "    \"name\": \"step_results\",\n" +
                "    \"system_name\": \"custom_step_results\",\n" +
                "    \"type_id\": 11\n" +
                "  }";
        final CustomFieldDefinition fieldDefinition = new GsonBuilder().create().fromJson(json, CustomFieldDefinition.class);

        assertThat(fieldDefinition.getConfigs(), hasSize(1));
        assertThat(fieldDefinition.getId().asInt(), equalTo(5));
        assertThat(fieldDefinition.getDescription(), equalTo("a description"));
        assertThat(fieldDefinition.getDisplayOrder(), equalTo(1));
        assertThat(fieldDefinition.getLabel(), equalTo("Steps"));
        assertThat(fieldDefinition.getName(), equalTo("step_results"));
        assertThat(fieldDefinition.getSystemName(), equalTo("custom_step_results"));
        assertThat(fieldDefinition.getTypeId().asInt(), equalTo(11));
    }
}