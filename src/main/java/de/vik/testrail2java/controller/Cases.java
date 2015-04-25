package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClientInterface;
import de.vik.testrail2java.net.Filter;
import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.Case;
import de.vik.testrail2java.types.Case.CaseId;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.Suite;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.Timestamp;

/**
 *
 * http://docs.gurock.com/testrail-api2/reference-cases
 *
 */

public class Cases {

    private final APIClientInterface apiClient;

    public Cases(APIClientInterface apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * @param id The ID of the test case
     * @return Returns an existing test case.
     */
    public Case getCase(CaseId id) {
        return apiClient.get(Case.class, new MethodUri("get_case/:case_id").withParameters(id));
    }

    /**
     *
     * @param id The ID of the project
     * @param filters filters to apply
     * @return Returns a list of test cases for a test suite or specific section in a test suite.
     */
    public List<Case> getCases(ProjectId id, Filters<Case> filters) {
        return apiClient.getList(Case.class, new MethodUri("get_cases/:project_id", filters).withParameters(id));
    }

    /**
     * Creates a new test case.
     * @return If successful, this method returns the created test case
     */
    public Case addCase(SectionId sectionId, Case c) {
        String[] allowedFields = {"title", "typeId", "priorityId", "estimate", "milestoneId", "refs",
                "customStepsSeparated", "customPreconds", "customTestdata"};
        final MethodUri uri = new MethodUri("add_case/:section_id").withParameters(sectionId);
        return apiClient.post(uri, c, allowedFields, Case.class);
    }

    /**
     * Updates an existing test case (partial updates are supported, i.e. you can submit and update specific fields only).
     * @return If successful, this method returns the updated test case
     */
    public Case updateCase(Case c) {
        String[] allowedFields = {"title", "typeId", "priorityId", "estimate", "milestoneId",
                "refs", "customStepsSeparated", "customPreconds", "customTestdata"};
        final MethodUri uri = new MethodUri("update_case/:case_id").withParameters(c.getId());
        return apiClient.post(uri, c, allowedFields, Case.class);
    }

    /**
     * Deletes an existing test case.
     * @param id The ID of the test case
     */
    public void deleteCase(CaseId id) {
        apiClient.post(new MethodUri("delete_case/:case_id").withParameters(id));
    }

    public static class CaseFilter extends Filter<Case> {

        protected CaseFilter(String key, Timestamp value) {
            this(key, asString(value));
        }

        protected CaseFilter(String key, Id value, Id... furtherValues) {
            this(key, asString(value, furtherValues));
        }

        protected CaseFilter(String key, String value) {
            super(key, value);
        }

        /**
         * The ID of the test suite
         */
        public static CaseFilter suiteId(Suite.SuiteId id) {
            return new CaseFilter("suite_id", id);
        }

        /**
         * The ID of the section
         */
        public static CaseFilter sectionId(SectionId id) {
            return new CaseFilter("section_id", id);
        }

        /**
         * Only return test cases created after this date (as UNIX timestamp).
         */
        public static CaseFilter createdAfter(Timestamp timestamp) {
            return new CaseFilter("created_after", timestamp);
        }

        /**
         * Only return test cases created before this date (as UNIX timestamp).
         */
        public static CaseFilter createdBefore(Timestamp timestamp) {
            return new CaseFilter("created_before", timestamp);
        }

        /**
         * A comma-separated list of creators (user IDs) to filter by.
         */
        public static CaseFilter createdBy(UserId id, UserId... furtherIds) {
            return new CaseFilter("created_by", id, furtherIds);
        }

        /**
         * A comma-separated list of milestone IDs to filter by.
         */
        public static CaseFilter milestoneId(MilestoneId id, MilestoneId... furtherIds) {
            return new CaseFilter("milestone_id", id, furtherIds);
        }

        /**
         * A comma-separated list of priority IDs to filter by.
         */
        public static CaseFilter priorityId(PriorityId id, PriorityId... furtherIds) {
            return new CaseFilter("priority_id", id, furtherIds);
        }

        /**
         * A comma-separated list of case type IDs to filter by.
         */
        public static CaseFilter typeId(TypeId id, TypeId... furtherIds) {
            return new CaseFilter("type_id", id, furtherIds);
        }

        /**
         * Only return test cases updated after this date (as UNIX timestamp).
         */
        public static CaseFilter updatedAfter(Timestamp timestamp) {
            return new CaseFilter("updated_after", timestamp);
        }

        /**
         * Only return test cases updated before this date (as UNIX timestamp).
         */
        public static CaseFilter updatedBefore(Timestamp timestamp) {
            return new CaseFilter("updated_before", timestamp);
        }

        /**
         * A comma-separated list of users who updated test cases to filter by.
         */
        public static CaseFilter updatedBy(UserId id, UserId... furtherIds) {
            return new CaseFilter("updated_by", id, furtherIds);
        }
    }
}
