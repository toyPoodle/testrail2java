package de.vik.testrail2java.types;

import org.junit.*;
import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.types.CustomFieldDefinition.CustomFieldConfig;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class CustomFieldConfigTest {

    @Test
    public void deserialization() throws Exception {
        String json =
                "{\n" +
                "    \"context\": {\n" +
                "      \"is_global\": true,\n" +
                "      \"project_ids\": null\n" +
                "    },\n" +
                "    \"id\": \"1e484fac-97c2-4315-ac39-cca1e72aad36\",\n" +
                "    \"options\": {\n" +
                "      \"format\": \"markdown\",\n" +
                "      \"has_actual\": false,\n" +
                "      \"has_expected\": true,\n" +
                "      \"is_required\": false\n" +
                "    }\n" +
                "}\n";
        final CustomFieldConfig config = new GsonBuilder().create().fromJson(json, CustomFieldConfig.class);
        assertThat(config.getContext(), notNullValue());
        assertThat(config.getOptions(), notNullValue());
        assertThat(config.getId().asString(), equalTo("1e484fac-97c2-4315-ac39-cca1e72aad36"));
    }
}