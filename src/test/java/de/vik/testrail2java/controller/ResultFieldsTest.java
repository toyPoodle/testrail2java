package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.CustomFieldDefinition;

import static de.vik.testrail2java.testhelpers.Mockups.testGetList;

public class ResultFieldsTest {

    @Test
    public void getResultFields() throws Exception {
        testGetList(CustomFieldDefinition.class, "get_result_fields",
                apiClient -> new ResultFields(apiClient).getResultFields());
    }
}