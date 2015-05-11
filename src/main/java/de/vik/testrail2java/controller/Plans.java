package de.vik.testrail2java.controller;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.Filter;
import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Plan;
import de.vik.testrail2java.types.Plan.PlanEntry;
import de.vik.testrail2java.types.Plan.PlanEntryId;
import de.vik.testrail2java.types.Plan.PlanId;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.Timestamp;

import java.util.List;

/**
 * http://docs.gurock.com/testrail-api2/reference-plans
 */
public class Plans {

    private final APIClient client;

    public Plans(APIClient client) {
        this.client = client;
    }

    /**
     * @return Returns an existing test plan.
     */
    public Plan getPlan(PlanId id) {
        return client.get(Plan.class, new MethodUri("get_plan/:plan_id").withParameters(id));
    }

    /**
     *
     * @return Returns a list of test plans for a project.
     */
    public List<Plan> getPlans(ProjectId id, Filters<Plan> filters) {
        return client.getList(Plan.class, new MethodUri("get_plans/:project_id", filters).withParameters(id));
    }

    /**
     * Creates a new test plan.
     * @param plan Plan to add
     * @return If successful, this method returns the new test plan
     */
    public Plan addPlan(Plan plan, ProjectId projectId) {
        final MethodUri uri = new MethodUri("add_plan/:project_id").withParameters(projectId);
        final String[] allowedFields = {"name", "description", "milestoneId", "entries"};
        return client.post(uri, plan, allowedFields, Plan.class);
    }

    /**
     * Adds one or more new test runs to a test plan.
     * @param planId The ID of the plan the test runs should be added to
     * @return If successful, this method returns the new test plan entry
     */
    public PlanEntry addPlanEntry(PlanId planId, PlanEntry planEntry) {
        MethodUri uri = new MethodUri("add_plan_entry/:plan_id").withParameters(planId);
        final String[] allowedFields = {"suiteId", "name", "assignedtoId", "includeAll", "caseIds", "configIds", "runs"};
        return client.post(uri, planEntry, allowedFields, PlanEntry.class);
    }

    /**
     * Updates an existing test plan
     * @return If successful, this method returns the updated test plan
     */
    public Plan updatePlan(Plan plan) {
        final MethodUri uri = new MethodUri("update_plan/:plan_id").withParameters(plan.getId());
        final String[] allowedFields = {"name", "description", "milestoneId", "entries"};
        return client.post(uri, plan, allowedFields, Plan.class);
    }

    /**
     * Updates one or more existing test runs in a plan
     * @return If successful, this method returns the updated test plan entry including test runs
     */
    public PlanEntry updatePlanEntry(PlanEntry planEntry, PlanId planId) {
        MethodUri uri = new MethodUri("update_plan_entry/:plan_id/:entry_id").withParameters(planId, planEntry.getId());
        final String[] allowedFields = {"name", "assignedtoId", "includeAll", "caseIds"};
        return client.post(uri, planEntry, allowedFields, PlanEntry.class);
    }

    /**
     * Closes an existing test plan and archives its test runs & results.
     * @param id The ID of the test plan
     * @return If successful, this method returns the closed test plan
     */
    public Plan closePlan(PlanId id) {
        return client.post(new MethodUri("close_plan/:plan_id").withParameters(id), Plan.class);
    }

    /**
     * Deletes an existing test plan.
     * @param id The ID of the test plan
     */
    public void deletePlan(PlanId id) {
        client.post(new MethodUri("delete_plan/:plan_id").withParameters(id));
    }

    /**
     * Deletes one or more existing test runs from a plan.
     * @param planId The ID of the test plan.
     * @param entryId The ID of the test plan entry
     */
    public void deletePlanEntry(PlanId planId, PlanEntryId entryId) {
        client.post(new MethodUri("delete_plan_entry/:plan_id/:entry_id").withParameters(planId, entryId));
    }

    public static class PlanFilter extends Filter<Plan> {
        protected PlanFilter(String key, String value) {
            super(key, value);
        }

        protected PlanFilter(String key, Timestamp value) {
            this(key, asString(value));
        }

        protected PlanFilter(String key, int value) {
            super(key, String.valueOf(value));
        }

        /**
         * Only return test plans created after this date (as UNIX timestamp).
         */
        public static Filter<Plan> createdAfter(Timestamp timestamp) {
            return new PlanFilter("created_after", timestamp);
        }

        /**
         * Only return test plans created before this date (as UNIX timestamp).
         */
        public static Filter<Plan> createdBefore(Timestamp timestamp) {
            return new PlanFilter("created_before", timestamp);
        }

        /**
         * A comma-separated list of creators (user IDs) to filter by.
         */
        public static Filter<Plan> createdBy(UserId id, UserId... furtherIds) {
            return new PlanFilter("created_by", asString(id, furtherIds));
        }

        /**
         * completed test plans only
         */
        public static Filter<Plan> isCompleted() {
            return new PlanFilter("is_completed", "1");
        }

        /**
         * active test plans only
         */
        public static Filter<Plan> isActive() {
            return new PlanFilter("is_completed", "0");
        }

        /**
         *Limit the result to :limit test plans.
         */
        public static Filter<Plan> limit(int limit) {
            return new PlanFilter("limit", limit);
        }

        /**
         *Use :offset to skip records.
         */
        public static Filter<Plan> offset(int offset) {
            return new PlanFilter("offset", offset);
        }

        /**
         *A comma-separated list of milestone IDs to filter by.
         */
        public static Filter<Plan> milestoneId(MilestoneId id, MilestoneId... furtherIds) {
            return new PlanFilter("milestone_id", asString(id, furtherIds));
        }
    }
}
