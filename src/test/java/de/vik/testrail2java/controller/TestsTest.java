package de.vik.testrail2java.controller;

import org.junit.Test;

import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.types.primitive.Primitives.runId;
import static de.vik.testrail2java.types.primitive.Primitives.testId;

public class TestsTest {

    @Test
    public void testGetTest() throws Exception {
        testGetItem(de.vik.testrail2java.types.Test.class, "get_test/1",
                apiClient -> new Tests(apiClient).getTest(testId(1)));
    }

    @Test
    public void testGetTests() throws Exception {
        testGetList(de.vik.testrail2java.types.Test.class, "get_tests/2",
                apiClient -> new Tests(apiClient).getTests(runId(2)));
    }
}