package de.vik.testrail2java.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.vik.testrail2java.testhelpers.Mockups;
import de.vik.testrail2java.types.CaseField;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class CaseFieldsTest {

    @Test
    public void getCaseFields() throws Exception {
        List<CaseField> expected = new ArrayList<CaseField>();
        CaseFields target = new CaseFields(Mockups.apiClientGET(CaseField.class, "get_case_fields", expected));

        final List<CaseField> actual = target.getCaseFields();

        assertThat(actual, sameInstance(expected));
    }
}