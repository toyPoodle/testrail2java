package de.vik.testrail2java.controller;

import de.vik.testrail2java.types.Plan;
import de.vik.testrail2java.types.Plan.PlanEntry;
import de.vik.testrail2java.types.Plan.PlanEntryId;
import de.vik.testrail2java.types.Plan.PlanId;
import de.vik.testrail2java.types.Project.ProjectId;
import org.junit.Test;

import static de.vik.testrail2java.controller.Plans.PlanFilter.isCompleted;
import static de.vik.testrail2java.net.Filters.filterBy;
import static de.vik.testrail2java.testhelpers.Mockups.*;
import static org.mockito.Mockito.when;

public class PlansTest {

	@Test
	public void testGetPlan() throws Exception {
		testGetItem(Plan.class, "get_plan/1",
				client -> new Plans(client).getPlan(new PlanId(1)));
	}

	@Test
	public void testGetPlans() throws Exception {
		testGetList(Plan.class, "get_plans/2&is_completed=1",
				client -> new Plans(client).getPlans(new ProjectId(2), filterBy(isCompleted())));
	}

	@Test
	public void testAddPlan() throws Exception {
		final String[] allowedFields = {"name", "description", "milestoneId", "entries"};
		testSubmissionWithData("add_plan/3", Plan.class, allowedFields,
				plan -> {},
				(client, plan) -> new Plans(client).addPlan(plan, new ProjectId(3)));
	}

	@Test
	public void testAddPlanEntry() throws Exception {
		final String[] allowedFields = {"suiteId", "name", "assignedtoId", "includeAll", "caseIds", "configIds", "runs"};
		testSubmissionWithData("add_plan_entry/4", PlanEntry.class, allowedFields,
				planEntry -> {},
				(client, planEntry) -> new Plans(client).addPlanEntry(new PlanId(4), planEntry));
	}

	@Test
	public void testUpdatePlan() throws Exception {
		final String[] allowedFields = {"name", "description", "milestoneId", "entries"};
		testSubmissionWithData("update_plan/3", Plan.class, allowedFields,
				plan -> when(plan.getId()).thenReturn(new PlanId(3)),
				(client, plan) -> new Plans(client).updatePlan(plan));
	}

	@Test
	public void testUpdatePlanEntry() throws Exception {
		final String[] allowedFields = {"name", "assignedtoId", "includeAll", "caseIds"};
		testSubmissionWithData("update_plan_entry/4/914bcbdf-17e7-47b9-bc34-f507bcfed8b2", PlanEntry.class, allowedFields,
				planEntry -> when(planEntry.getId()).thenReturn(new PlanEntryId("914bcbdf-17e7-47b9-bc34-f507bcfed8b2")),
				(client, planEntry) -> new Plans(client).updatePlanEntry(planEntry, new PlanId(4)));
	}

	@Test
	public void testClosePlan() throws Exception {
		testSubmissionWithoutData("close_plan/6", Plan.class,
				client -> new Plans(client).closePlan(new PlanId(6)));
	}

	@Test
	public void testDeletePlan() throws Exception {
		testSubmissionWithoutResultAndData("delete_plan/7",
				client -> new Plans(client).deletePlan(new PlanId(7)));
	}

	@Test
	public void testDeletePlanEntry() throws Exception {
		testSubmissionWithoutResultAndData("delete_plan_entry/8/914bcbdf-17e7-47b9-bc34-f507bcfed8b2",
				client -> new Plans(client).deletePlanEntry(new PlanId(8), new PlanEntryId("914bcbdf-17e7-47b9-bc34-f507bcfed8b2")));
	}
}