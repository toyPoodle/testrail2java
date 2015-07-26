package de.vik.testrail2java.types;

import org.junit.Test;

import com.google.gson.Gson;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class CaseFieldTest {

    @Test
    public void deserialization() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        String json = "{" +
                "        \"configs\": [" +
                "        {" +
                "            \"context\": {" +
                "                \"is_global\": true," +
                "                \"project_ids\": [7,8]" +
                "            }," +
                "            \"id\": 2," +
                "            \"options\": {" +
                "                \"default_value\": \"none\"," +
                "                \"format\": \"markdown\"," +
                "                \"is_required\": true," +
                "                \"rows\": \"5\"" +
                "            }" +
                "        }" +
                "        ]," +
                "        \"description\": \"The preconditions of this test case. ..\"," +
                "        \"display_order\": 1," +
                "        \"id\": 1," +
                "        \"label\": \"Preconditions\"," +
                "        \"name\": \"preconds\"," +
                "        \"system_name\": \"custom_preconds\"," +
                "        \"type_id\": 3" +
                "    }";
        Gson gson = new GsonBuilder().create();

        CaseField caseField = gson.fromJson(json, CaseField.class);

        assertThat(caseField.getConfigs(), hasSize(1));

        final CaseField.Config config = caseField.getConfigs().get(0);
        assertThat(config.getContext().isGlobal(), equalTo(true));
        assertThat(config.getContext().getProjectIds(), hasSize(2));
        assertThat(config.getContext().getProjectIds(), hasItems(7, 8));
        assertThat(config.getId().asInt(), equalTo(2));
        assertThat(config.getOptions().getDefaultValue(), equalTo("none"));
        assertThat(config.getOptions().getFormat(), equalTo("markdown"));
        assertThat(config.getOptions().isRequired(), equalTo(true));
        assertThat(config.getOptions().getRows(), equalTo("5"));

        assertThat(caseField.getDescription(), equalTo("The preconditions of this test case. .."));
        assertThat(caseField.getDisplayOrder(), equalTo(1));
        assertThat(caseField.getId().asInt(), equalTo(1));
        assertThat(caseField.getLabel(), equalTo("Preconditions"));
        //noinspection SpellCheckingInspection
        assertThat(caseField.getName(), equalTo("preconds"));
        //noinspection SpellCheckingInspection
        assertThat(caseField.getSystemName(), equalTo("custom_preconds"));
        assertThat(caseField.getTypeId().asInt(), equalTo(3));
    }
}