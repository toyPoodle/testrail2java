package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.types.custom.StepResult;
import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.Filter;
import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Case.CaseId;
import de.vik.testrail2java.types.Plan.TestRunId;
import de.vik.testrail2java.types.Result;
import de.vik.testrail2java.types.Status.StatusId;
import de.vik.testrail2java.types.Test.TestId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.Timestamp;

/**
 * http://docs.gurock.com/testrail-api2/reference-results
 */
public class Results {

	private APIClient client;

	public Results(APIClient client) {
		this.client = client;
	}

	/**
	 * Returns a list of test results for a test.
	 * @param id The ID of the test
	 */
	public List<Result> getResults(TestId id, Filters<Result> filters) {
		final MethodUri uri = new MethodUri("get_results/:test_id", filters).withParameters(id);
		return client.getList(Result.class, uri);
	}

	/**
	 * Returns a list of test results for a test run and case combination.
	 * The difference to {@link #getResults(TestId, Filters)} is that this method expects a test run + test case
	 * instead of a test. In TestRail, tests are part of a test run and the test cases are part of the related
	 * test suite. So, when you create a new test run, TestRail creates a test for each test case found in
	 * the test suite of the run. You can therefore think of a test as an “instance” of a test case which can
	 * have test results, comments and a test status.
	 * @param runId The ID of the test run
	 * @param caseId The ID of the test case
	 */
	public List<Result> getResultsForCase(TestRunId runId, CaseId caseId, Filters<Result> filters) {
		final MethodUri uri = new MethodUri("get_results_for_case/:run_id/:case_id", filters).withParameters(runId, caseId);
		return client.getList(Result.class, uri);
	}

	/**
	 * Returns a list of test results for a test run.
	 * @param runId The ID of the test run
	 */
	public List<Result> getResultsForRun(TestRunId runId, Filters<Result> filters) {
		final MethodUri uri = new MethodUri("get_results_for_run/:run_id", filters).withParameters(runId);
		return client.getList(Result.class, uri);
	}

	/**
	 * Adds a new test result, comment or assigns a test.
	 * It's recommended to use {@link #addResults(TestRunId, List)} instead if you plan to add results for multiple tests.
	 * @param id The ID of the test the result should be added to
	 * @param result Result to add
	 */
	public Result addResult(TestId id, Result result) {
		final MethodUri uri = new MethodUri("add_result/:test_id").withParameters(id);
		final AllowedFields allowedFields = new AllowedFields(Result.class,
				"statusId", "comment", "version", "elapsed", "defects", "assignedtoId", "customStepResults");
		return client.post(uri, result, allowedFields, Result.class);
	}

	/**
	 * Adds a new test result, comment or assigns a test (for a test run and case combination).
	 * It's recommended to use {@link #addResultsForCases(TestRunId, List)} instead if you plan to add results
	 * for multiple test cases.
	 * The difference to {@link #addResult(TestId, Result)} is that this method expects
	 * a test run + test case instead of a test. In TestRail, tests are part of a test run and
	 * the test cases are part of the related test suite. So, when you create a new test run,
	 * TestRail creates a test for each test case found in the test suite of the run. You can
	 * therefore think of a test as an “instance” of a test case which can have test results,
	 * comments and a test status.
	 * @param runId The ID of the test run
	 * @param caseId The ID of the test case
	 * @param result result to add
	 * @return If successful, this method returns the new test result
	 */
	public Result addResultForCase(TestRunId runId, CaseId caseId, Result result) {
		final MethodUri uri = new MethodUri("add_result_for_case/:run_id/:case_id").withParameters(runId, caseId);
		final AllowedFields allowedFields = new AllowedFields(Result.class,
				"statusId", "comment", "version", "elapsed", "defects", "assignedtoId", "customStepResults");
		return client.post(uri, result, allowedFields, Result.class);
	}

	/**
	 * Adds one or more new test results, comments or assigns one or more tests.
	 * Ideal for test automation to bulk-add multiple test results in one step.
	 * This method expects an array of test results. Each test result must specify
	 * the test ID.
	 * Please note that all referenced tests must belong to the same test run.
	 * @param id The ID of the test run the results should be added to
	 * @param results Results to add
	 * @return If successful, this method returns the new test results
	 */
	public List<Result> addResults(TestRunId id, List<Result> results) {
		final MethodUri uri = new MethodUri("add_results/:run_id").withParameters(id);
		@SuppressWarnings("SpellCheckingInspection")
		final AllowedFields allowedFields = new AllowedFields(Result.class,
				"statusId", "comment", "version", "elapsed", "defects", "assignedtoId", "customStepResults")
                .and(ResultsContainer.class, "results")
                .and(StepResult.class, "content", "expected", "actual", "statusId");
		return client.postList(uri, new ResultsContainer(results), allowedFields, Result.class);
	}

	/**
	 * Adds one or more new test results, comments or assigns one or more tests (using the case IDs).
	 * Ideal for test automation to bulk-add multiple test results in one step.
	 * This method expects an array of test results. Each test result must specify the test case ID.
	 * Please note that all referenced tests must belong to the same test run.
	 * @param id The ID of the test run the results should be added to
	 * @return If successful, this method returns the new test results
	 */
	public List<Result> addResultsForCases(TestRunId id, List<Result> results) {
		final MethodUri uri = new MethodUri("add_results_for_cases/:run_id").withParameters(id);
		@SuppressWarnings("SpellCheckingInspection")
		final AllowedFields allowedFields = new AllowedFields(Result.class,
				"statusId", "comment", "version", "elapsed", "defects", "assignedtoId", "customStepResults")
				.and(ResultsContainer.class, "results")
                .and(StepResult.class, "content", "expected", "actual", "statusId");
		return client.postList(uri, new ResultsContainer(results), allowedFields, Result.class);
	}


	protected static class ResultsContainer {
		private List<Result> results;

		public ResultsContainer(List<Result> results) {
			this.results = results;
		}

		@Override
		@SuppressWarnings("ControlFlowStatementWithoutBraces")
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof ResultsContainer)) return false;

			ResultsContainer that = (ResultsContainer) o;

			return results.equals(that.results);
		}

		@Override
		public int hashCode() {
			return results.hashCode();
		}
	}

	public static class ResultFilter extends Filter<Result> {
		private ResultFilter(String key, String value) {
			super(key, value);
		}

		private ResultFilter(String key, int value) {
			this(key, String.valueOf(value));
		}

		/**
		 * Limit the result to :limit test plans.
		 */
		public static Filter<Result> limit(int limit) {
			return new ResultFilter("limit", limit);
		}

		/**
		 * Use :offset to skip records.
		 */
		public static Filter<Result> offset(int offset) {
			return new ResultFilter("offset", offset);
		}

		/**
		 * A comma-separated list of status IDs to filter by.
		 */
		public static Filter<Result> statusId(StatusId id, StatusId... furtherIds) {
			return new ResultFilter("status_id", asString(id, furtherIds));
		}

		/**
		 * Only return test results created after this date (as UNIX timestamp).
		 */
		public static Filter<Result> createdAfter(Timestamp timestamp) {
			return new ResultFilter("created_after", asString(timestamp));
		}

		/**
		 * Only return test results created before this date (as UNIX timestamp).
		 */
		public static Filter<Result> createdBefore(Timestamp timestamp) {
			return new ResultFilter("created_before", asString(timestamp));
		}

		/**
		 * A comma-separated list of creators (user IDs) to filter by.
		 */
		public static Filter<Result> createdBy(UserId id, UserId... furtherIds) {
			return new ResultFilter("created_by", asString(id, furtherIds));
		}


	}

}
