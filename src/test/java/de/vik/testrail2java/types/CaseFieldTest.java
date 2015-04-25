package de.vik.testrail2java.types;

import org.junit.Test;

import com.google.gson.Gson;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.junit.Assert.*;

public class CaseFieldTest {

    @Test
    public void deserialization() throws Exception {
        String json = "{" +
                "        \"configs\": [" +
                "        {" +
                "            \"context\": {" +
                "                \"is_global\": true," +
                "                \"project_ids\": 7" +
                "            }," +
                "            \"id\": 2," +
                "            \"options\": {" +
                "                \"default_value\": \"none\"," +
                "                \"format\": \"markdown\"," +
                "                \"is_required\": false," +
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

        System.out.println(caseField);

    }
}