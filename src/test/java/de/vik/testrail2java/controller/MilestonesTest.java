package de.vik.testrail2java.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.testhelpers.Mockups;
import de.vik.testrail2java.types.Milestone;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Project.ProjectId;

import static de.vik.testrail2java.controller.Milestones.MilestoneFilter.isCompleted;
import static de.vik.testrail2java.net.Filters.filterBy;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MilestonesTest {

    @Test
    public void testGetMilestone() throws Exception {
        Milestone expected = mock(Milestone.class);
        Milestones target = new Milestones(Mockups.apiClientGET(Milestone.class, "get_milestone/1", expected));
        assertThat(target.getMilestone(new MilestoneId(1)), sameInstance(expected));
    }

    @Test
    public void testGetMilestones() throws Exception {
        List<Milestone> expected = new ArrayList<>();
        APIClient apiClient = Mockups.apiClientGET(Milestone.class, "get_milestones/1&is_completed=1", expected);
        final Milestones target = new Milestones(apiClient);
        final List<Milestone> actual = target.getMilestones(new ProjectId(1), filterBy(isCompleted()));
        assertThat(actual, sameInstance(expected));
    }

    @Test
    public void testAddMilestone() throws Exception {
        String[] allowedFields = {"name", "description", "dueOn"};
        testSubmissionWithData("add_milestone/1", Milestone.class, allowedFields,
                (data) -> {},
                (apiClient, data) -> new Milestones(apiClient).addMilestone(new ProjectId(1), data));
    }

    @Test
    public void testUpdateMilestone() throws Exception {
        String[] allowedFields = {"name", "description", "dueOn", "isCompleted"};
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