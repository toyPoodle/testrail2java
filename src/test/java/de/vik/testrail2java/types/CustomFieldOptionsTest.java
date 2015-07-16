package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.types.CustomFieldDefinition.CustomFieldOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CustomFieldOptionsTest {
    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "        \"format\": \"markdown\",\n" +
                "        \"has_actual\": true,\n" +
                "        \"has_expected\": true,\n" +
                "        \"is_required\": true\n" +
                "      }";
        final CustomFieldOptions options = new GsonBuilder().create().fromJson(json, CustomFieldOptions.class);

        assertThat(options.hasActual(), equalTo(true));
        assertThat(options.getFormat(), equalTo("markdown"));
        assertThat(options.hasExpected(), equalTo(true));
        assertThat(options.isRequired(), equalTo(true));

    }
}