package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.controller.Results.ResultsContainer;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Plan.TestRunId;
import de.vik.testrail2java.types.Result;
import de.vik.testrail2java.types.Test.TestId;
import de.vik.testrail2java.types.custom.StepResult;

import static de.vik.testrail2java.controller.Results.ResultFilter.createdAfter;
import static de.vik.testrail2java.net.Filters.filterBy;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithDataList;
import static de.vik.testrail2java.types.primitive.Primitives.caseId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;

public class ResultsTest {

    @Test
    public void testGetResults() throws Exception {
        testGetList(Result.class, "get_results/1&created_after=1234",
                client -> new Results(client).getResults(new TestId(1), filterBy(createdAfter(timestamp(1234)))));
    }

    @Test
    public void testGetResultsForCase() throws Exception {
        testGetList(Result.class, "get_results_for_case/1/2&created_after=1234",
                client -> new Results(client).getResultsForCase(new TestRunId(1), caseId(2), filterBy(createdAfter(timestamp(1234)))));
    }

    @Test
    public void testGetResultsForRun() throws Exception {
        testGetList(Result.class, "get_results_for_run/1&created_after=1234",
                client -> new Results(client).getResultsForRun(new TestRunId(1), filterBy(createdAfter(timestamp(1234)))));
    }

    @Test
    public void testAddResult() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version");
        testSubmissionWithData("add_result/1", Result.class, allowedFields,
                result -> {},
                (client, result) -> new Results(client).addResult(new TestId(1), result));
    }

    @Test
    public void testAddResultForCase() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version");
        testSubmissionWithData("add_result_for_case/1/2", Result.class, allowedFields,
                result -> {},
                (client, result) -> new Results(client).addResultForCase(new TestRunId(1), caseId(2), result));
    }

    @Test
    public void testAddResults() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version")
                .and(ResultsContainer.class, "results")
                .and(StepResult.class, "expected", "content", "actual", "statusId");
        testSubmissionWithDataList("add_results/1", Result.class, allowedFields,
                ResultsContainer::new,
                (client, results) -> new Results(client).addResults(new TestRunId(1), results));
    }

    @Test
    public void testAddResultsForCases() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Result.class,
                "assignedtoId", "comment", "customStepResults", "defects", "elapsed", "statusId", "version")
                .and(ResultsContainer.class, "results")
                .and(StepResult.class, "expected", "content", "actual", "statusId");
        testSubmissionWithDataList("add_results_for_cases/1", Result.class, allowedFields,
                ResultsContainer::new,
                (client, results) -> new Results(client).addResultsForCases(new TestRunId(1), results));
    }
}