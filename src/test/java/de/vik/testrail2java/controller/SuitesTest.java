package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Suite;

import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static de.vik.testrail2java.types.primitive.Primitives.suiteId;
import static org.mockito.Mockito.when;

public class SuitesTest {

    @Test
    public void testAddSuite() throws Exception {
        final AllowedFields allowedFields = new AllowedFields(Suite.class, "description", "name");
        testSubmissionWithData("add_suite/3", Suite.class, allowedFields,
                suite -> when(suite.getProjectId()).thenReturn(projectId(3)),
                (apiClient, suite) -> new Suites(apiClient).addSuite(suite));
    }

    @Test
    public void testGetSuite() throws Exception {
        testGetItem(Suite.class, "get_suite/2",
                apiClient -> new Suites(apiClient).getSuite(suiteId(2)));
    }

    @Test
    public void testGetSuites() throws Exception {
        testGetList(Suite.class, "get_suites/3",
                apiClient -> new Suites(apiClient).getSuites(projectId(3)));
    }

    @Test
    public void testUpdateSuite() throws Exception {
        final AllowedFields allowedFields = new AllowedFields(Suite.class, "description", "name");
        testSubmissionWithData("update_suite/4", Suite.class, allowedFields,
                suite -> when(suite.getId()).thenReturn(suiteId(4)),
                (apiClient, suite) -> new Suites(apiClient).updateSuite(suite));
    }

    @Test
    public void testDeleteSuite() throws Exception {
        testSubmissionWithoutResultAndData("delete_suite/5",
                apiClient -> new Suites(apiClient).deleteSuite(suiteId(5)));
    }
}