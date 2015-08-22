package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.Filter;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.Run.RunId;
import de.vik.testrail2java.types.Status.StatusId;
import de.vik.testrail2java.types.Test;
import de.vik.testrail2java.types.Test.TestId;

/**
 * http://docs.gurock.com/testrail-api2/reference-tests
 */
public class Tests {

    private final APIClient client;

    public Tests(APIClient client) {
        this.client = client;
    }

    /**
     * Returns an existing test.
     * @param id The ID of the test
     */
    public Test getTest(TestId id) {
        return client.get(Test.class, new MethodUri("get_test/:test_id").withParameters(id));
    }

    /**
     * Returns a list of tests for a test run.
     * @param id The ID of the test run
     */
    public List<Test> getTests(RunId id) {
        return client.getList(Test.class, new MethodUri("get_tests/:run_id").withParameters(id));
    }

    public static class TestFilter extends Filter<Test> {

        protected TestFilter(String key, String value) {
            super(key, value);
        }

        /**
         * A comma-separated list of status IDs to filter by. (available since TestRail 4.0)
         */
        public static Filter<Test> byStatusId(StatusId id, StatusId... furtherIds) {
            return new TestFilter("status_id", asString(id, furtherIds));
        }
    }
}
