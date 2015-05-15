package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Milestone;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Project.ProjectId;

import static de.vik.testrail2java.controller.Milestones.MilestoneFilter.isCompleted;
import static de.vik.testrail2java.net.Filters.filterBy;
import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static org.mockito.Mockito.when;

public class MilestonesTest {

    @Test
    public void testGetMilestone() throws Exception {
        testGetItem(Milestone.class, "get_milestone/1",
                (client) -> new Milestones(client).getMilestone(new MilestoneId(1)));
    }

    @Test
    public void testGetMilestones() throws Exception {
        testGetList(Milestone.class, "get_milestones/1&is_completed=1", (client) -> {
            final Milestones target = new Milestones(client);
            return target.getMilestones(new ProjectId(1), filterBy(isCompleted()));
        });
    }

    @Test
    public void testAddMilestone() throws Exception {
        final AllowedFields allowedFields = new AllowedFields(Milestone.class, "name", "description", "dueOn");
        testSubmissionWithData("add_milestone/1", Milestone.class, allowedFields,
                (data) -> {},
                (apiClient, data) -> new Milestones(apiClient).addMilestone(new ProjectId(1), data));
    }

    @Test
    public void testUpdateMilestone() throws Exception {
        final AllowedFields allowedFields = new AllowedFields(Milestone.class, "name", "description", "dueOn", "isCompleted");
        testSubmissionWithData("update_milestone/2", Milestone.class, allowedFields,
                (data) -> when(data.getId()).thenReturn(new MilestoneId(2)),
                (apiClient, data) -> new Milestones(apiClient).updateMilestone(data));
    }

    @Test
    public void testDeleteMilestone() throws Exception {
        testSubmissionWithoutResultAndData("delete_milestone/3",
                (apiClient) -> new Milestones(apiClient).deleteMilestone(new MilestoneId(3)));
    }
}