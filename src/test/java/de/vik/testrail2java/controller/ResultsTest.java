package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.controller.Results.ResultsContainer;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Result;
import de.vik.testrail2java.types.custom.StepResult;

import static de.vik.testrail2java.controller.Results.ResultFilter.byCreatedAfter;
import static de.vik.testrail2java.net.Filters.filter;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithDataList;
import static de.vik.testrail2java.types.primitive.Primitives.caseId;
import static de.vik.testrail2java.types.primitive.Primitives.runId;
import static de.vik.testrail2java.types.primitive.Primitives.testId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static org.mockito.Mockito.when;

public class ResultsTest {

    @Test
    public void testGetResults() throws Exception {
        testGetList(Result.class, "get_results/1&created_after=1234",
                client -> new Results(client).getResults(testId(1), filter(byCreatedAfter(timestamp(1234)))));
    }

    @Test
    public void testGetResultsForCase() throws Exception {
        testGetList(Result.class, "get_results_for_case/1/2&created_after=1234",
                client -> new Results(client).getResultsForCase(runId(1), caseId(2), filter(byCreatedAfter(timestamp(1234)))));
    }

    @Test
    public void testGetResultsForRun() throws Exception {
        testGetList(Result.class, "get_results_for_run/1&created_after=1234",
                client -> new Results(client).getResultsForRun(runId(1), filter(byCreatedAfter(timestamp(1234)))));
    }

    @Test
    public void testAddResult() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version");
        testSubmissionWithData("add_result/1", Result.class, allowedFields,
                result -> when(result.getTestId()).thenReturn(testId(1)),
                (client, result) -> new Results(client).addResult(result));
    }

    @Test
    public void testAddResultForCase() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version");
        testSubmissionWithData("add_result_for_case/1/2", Result.class, allowedFields,
                result -> {},
                (client, result) -> new Results(client).addResultForCase(runId(1), caseId(2), result));
    }

    @Test
    public void testAddResults() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version", "testId")
                .and(ResultsContainer.class, "results")
                .and(StepResult.class, "expected", "content", "actual", "statusId");
        testSubmissionWithDataList("add_results/1", Result.class, allowedFields,
                ResultsContainer::new,
                (client, results) -> new Results(client).addResults(runId(1), results));
    }

    @Test
    public void testAddResultsForCases() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version", "testId")
                .and(ResultsContainer.class, "results")
                .and(StepResult.class, "expected", "content", "actual", "statusId");
        testSubmissionWithDataList("add_results_for_cases/1", Result.class, allowedFields,
                ResultsContainer::new,
                (client, results) -> new Results(client).addResultsForCases(runId(1), results));
    }
}