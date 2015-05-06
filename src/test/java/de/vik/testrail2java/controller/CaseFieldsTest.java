package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.CaseField;

import static de.vik.testrail2java.testhelpers.Mockups.testGetList;

public class CaseFieldsTest {

    @Test
    public void getCaseFields() throws Exception {
        testGetList(CaseField.class, "get_case_fields", (client) -> new CaseFields(client).getCaseFields());
    }
}