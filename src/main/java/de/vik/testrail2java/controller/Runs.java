package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.Filter;
import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Plan;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Run;
import de.vik.testrail2java.types.Run.RunId;
import de.vik.testrail2java.types.Suite.SuiteId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.Timestamp;


/**
 * http://docs.gurock.com/testrail-api2/reference-runs
 */
public class Runs {
    private APIClient client;

    public Runs(APIClient client) {
        this.client = client;
    }

    /**
     * Returns an existing test run. Please see {@link Tests#getTests} for the list of included tests in this run.
     * @param id The ID of the test run
     */
    public Run getRun(RunId id) {
        return client.get(Run.class, new MethodUri("get_run/:run_id").withParameters(id));
    }

    /**
     * Returns a list of test runs for a project. Only returns those test runs that are not part of a test plan
     * (please see {@link Plans#getPlans(ProjectId, Filters)} or {@link Plans#getPlan(Plan.PlanId)} for this).
     */
    public List<Run> getRuns(ProjectId id, Filters<Run> filters) {
        return client.getList(Run.class, new MethodUri("get_runs/:project_id", filters).withParameters(id));
    }

    /**
     * Creates a new test run.
     * @param run Test run to be added
     * @return created test run
     */
    public Run addRun(Run run) {
        @SuppressWarnings("SpellCheckingInspection")
        AllowedFields allowedFields = new AllowedFields(Run.class, "suiteId", "name", "description",
                "milestoneId", "assignedtoId", "includeAll", "caseIds");
        final MethodUri uri = new MethodUri("add_run/:project_id").withParameters(run.getProjectId());
        return client.post(uri, run, allowedFields, Run.class);
    }

    /**
     * Updates an existing test run
     * @param run Test run to be updated
     * @return updated test run
     */
    public Run updateRun(Run run) {
        MethodUri uri = new MethodUri("update_run/:run_id").withParameters(run.getId());
        AllowedFields allowedFields = new AllowedFields(Run.class, "name", "description",
                "milestoneId", "includeAll", "caseIds");
        return client.post(uri, run, allowedFields, Run.class);
    }

    /**
     * Closes an existing test run and archives its tests & results.
     * Please note: Closing a test run cannot be undone.
     * @param id The ID of the test run
     * @return closed test run
     */
    public Run closeRun(RunId id) {
        return client.post(new MethodUri("close_run/:run_id").withParameters(id), Run.class);
    }

    /**
     * Deletes an existing test run. Please note: Deleting a test run cannot be undone and also
     * permanently deletes all tests & results of the test run.
     * @param id The ID of the test run
     */
    public void deleteRun(RunId id) {
        client.post(new MethodUri("delete_run/:run_id").withParameters(id));
    }

    public static class RunFilter extends Filter<Run> {

        protected RunFilter(String key, Timestamp value) {
            this(key, asString(value));
        }

        protected RunFilter(String key, Id value, Id... furtherValues) {
            this(key, asString(value, furtherValues));
        }

        protected RunFilter(String key, String value) {
            super(key, value);
        }

        protected RunFilter(String key, int value) {
            super(key, String.valueOf(value));
        }

        /**
         * The ID of the test suite
         */
        public static RunFilter suiteId(SuiteId id) {
            return new RunFilter("suite_id", id);
        }

        /**
         * Only return test runs created after this date (as UNIX timestamp).
         */
        public static RunFilter createdAfter(Timestamp timestamp) {
            return new RunFilter("created_after", timestamp);
        }

        /**
         * Only return test runs created before this date (as UNIX timestamp).
         */
        public static RunFilter createdBefore(Timestamp timestamp) {
            return new RunFilter("created_before", timestamp);
        }

        /**
         * A comma-separated list of creators (user IDs) to filter by.
         */
        public static RunFilter createdBy(UserId id, UserId... furtherIds) {
            return new RunFilter("created_by", id, furtherIds);
        }

        /**
         * A comma-separated list of milestone IDs to filter by.
         */
        public static RunFilter milestoneId(MilestoneId id, MilestoneId... furtherIds) {
            return new RunFilter("milestone_id", id, furtherIds);
        }

        /**
         * completed test runs only
         */
        public static RunFilter isCompleted() {
            return new RunFilter("is_completed", "1");
        }

        /**
         * active test runs only
         */
        public static RunFilter isActive() {
            return new RunFilter("is_completed", "0");
        }

        /**
         *Limit the result to :limit test plans.
         */
        public static RunFilter limit(int limit) {
            return new RunFilter("limit", limit);
        }

        /**
         *Use :offset to skip records.
         */
        public static RunFilter offset(int offset) {
            return new RunFilter("offset", offset);
        }

    }
}
