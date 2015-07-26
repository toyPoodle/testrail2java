package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.Filter;
import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Milestone;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Project.ProjectId;

/**
 * http://docs.gurock.com/testrail-api2/reference-milestones
 */
public class Milestones {
    private final APIClient apiClient;

    public Milestones(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * @param id The ID of the milestone
     * @return Returns an existing milestone.
     */
    public Milestone getMilestone(MilestoneId id) {
        final MethodUri uri = new MethodUri("get_milestone/:milestone_id").withParameters(id);
        return apiClient.get(Milestone.class, uri);
    }

    /**
     *
     * @param id The ID of the project
     * @param filters filters to be applied
     * @return Returns the list of milestones for a project.
     */
    public List<Milestone> getMilestones(ProjectId id, Filters<Milestone> filters) {
        final MethodUri uri = new MethodUri("get_milestones/:project_id", filters).withParameters(id);
        return apiClient.getList(Milestone.class, uri);
    }

    /**
     * Creates a new milestone.
     * @param milestone Milestone to be added
     * @return Created milestone, if successful
     */
    public Milestone addMilestone(Milestone milestone) {
        final MethodUri uri = new MethodUri("add_milestone/:project_id").withParameters(milestone.getProjectId());
        final AllowedFields allowedFields = new AllowedFields(Milestone.class, "name", "description", "dueOn");
        return apiClient.post(uri, milestone, allowedFields, Milestone.class);
    }

    /**
     * Updates an existing milestone.
     * @param milestone milestone to update
     * @return If successful, this method returns the updated milestone
     */
    public Milestone updateMilestone(Milestone milestone) {
        final MethodUri uri = new MethodUri("update_milestone/:milestone_id").withParameters(milestone.getId());
        final AllowedFields allowedFields = new AllowedFields(Milestone.class, "name", "description", "dueOn", "isCompleted");
        return apiClient.post(uri, milestone, allowedFields, Milestone.class);
    }

    /**
     * Deletes an existing milestone.
     * @param id The ID of the milestone
     */
    public void deleteMilestone(MilestoneId id) {
        apiClient.post(new MethodUri("delete_milestone/:milestone_id").withParameters(id));
    }

    public static class MilestoneFilter extends Filter<Milestone> {

        protected MilestoneFilter(String key, String value) {
            super(key, value);
        }

        /**
         * To return completed milestones only.
         */
        public static MilestoneFilter isCompleted() {
            return new MilestoneFilter("is_completed", "1");
        }

        /**
         * To return active milestones only.
         */
        public static MilestoneFilter isNotCompleted() {
            return new MilestoneFilter("is_completed", "0");
        }
    }
}
