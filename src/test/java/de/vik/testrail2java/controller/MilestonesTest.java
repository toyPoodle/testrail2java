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
import static de.vik.testrail2java.testhelpers.MoreMatchers.uri;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
        Milestone expected = mock(Milestone.class);
        APIClient apiClient = mock(APIClient.class);
        Milestones target = new Milestones(apiClient);
        Milestone data = mock(Milestone.class);
        String[] allowedFields = {"name", "description", "dueOn"};
        when(apiClient.post(uri("add_milestone/1"), eq(data), eq(allowedFields), eq(Milestone.class))).thenReturn(expected);
        assertThat(target.addMilestone(new ProjectId(1), data), sameInstance(expected));
        verify(apiClient, times(1)).post(uri("add_milestone/1"), eq(data), eq(allowedFields), eq(Milestone.class));
    }

    @Test
    public void testUpdateMilestone() throws Exception {
        Milestone expected = mock(Milestone.class);
        APIClient apiClient = mock(APIClient.class);
        Milestones target = new Milestones(apiClient);
        Milestone data = mock(Milestone.class);
        when(data.getId()).thenReturn(new MilestoneId(2));
        String[] allowedFields = {"name", "description", "dueOn", "isCompleted"};
        when(apiClient.post(uri("update_milestone/2"), eq(data), eq(allowedFields), eq(Milestone.class))).thenReturn(expected);
        assertThat(target.updateMilestone(data), sameInstance(expected));
        verify(apiClient, times(1)).post(uri("update_milestone/2"), eq(data), eq(allowedFields), eq(Milestone.class));
    }

    @Test
    public void testDeleteMilestone() throws Exception {
        APIClient apiClient = mock(APIClient.class);
        Milestones target = new Milestones(apiClient);
        target.deleteMilestone(new MilestoneId(3));
        verify(apiClient, times(1)).post(uri("delete_milestone/3"));
    }
}