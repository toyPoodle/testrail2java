package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Run;

import static de.vik.testrail2java.controller.Runs.RunFilter.byCreatedBy;
import static de.vik.testrail2java.net.Filters.filter;
import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static de.vik.testrail2java.types.primitive.Primitives.runId;
import static de.vik.testrail2java.types.primitive.Primitives.userId;
import static org.mockito.Mockito.when;

public class RunsTest {

    @Test
    public void testGetRun() throws Exception {
        testGetItem(Run.class, "get_run/1", apiClient -> new Runs(apiClient).getRun(runId(1)));
    }

    @Test
    public void testGetRuns() throws Exception {
        testGetList(Run.class, "get_runs/2&created_by=3",
                apiClient -> new Runs(apiClient).getRuns(projectId(2), filter(byCreatedBy(userId(3)))));
    }

    @Test
    public void testAddRun() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        AllowedFields allowedFields = new AllowedFields(Run.class, "suiteId", "name", "description", "milestoneId",
                "assignedtoId", "includeAll", "caseIds");
        testSubmissionWithData("add_run/4", Run.class, allowedFields,
                run -> when(run.getProjectId()).thenReturn(projectId(4)),
                (apiClient, run) -> new Runs(apiClient).addRun(run));
    }

    @Test
    public void testUpdateRun() throws Exception {
        AllowedFields allowedFields = new AllowedFields(Run.class, "name", "description", "milestoneId",
                "includeAll", "caseIds");
        testSubmissionWithData("update_run/4", Run.class, allowedFields,
                run -> when(run.getId()).thenReturn(runId(4)),
                (apiClient, run) -> new Runs(apiClient).updateRun(run));
    }

    @Test
    public void testCloseRun() throws Exception {
        testSubmissionWithoutData("close_run/5", Run.class, apiClient -> new Runs(apiClient).closeRun(runId(5)));
    }

    @Test
    public void testDeleteRun() throws Exception {
        testSubmissionWithoutResultAndData("delete_run/6", apiClient -> new Runs(apiClient).deleteRun(runId(6)));
    }
}