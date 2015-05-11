package de.vik.testrail2java.controller;

import de.vik.testrail2java.types.Type;
import org.junit.Test;

import static de.vik.testrail2java.testhelpers.Mockups.testGetList;

public class TypesTest {

    @Test
    public void testGetCaseTypes() throws Exception {
        testGetList(Type.class, "get_case_types", client -> new Types(client).getCaseTypes());
    }
}