package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.Milestone;
import de.vik.testrail2java.types.Type;
import de.vik.testrail2java.controller.Cases.CaseFilter;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.User.UserId;

import static org.junit.Assert.assertThat;
import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static de.vik.testrail2java.types.primitive.Primitives.milestoneId;
import static de.vik.testrail2java.types.primitive.Primitives.priorityId;
import static de.vik.testrail2java.types.primitive.Primitives.sectionId;
import static de.vik.testrail2java.types.primitive.Primitives.suiteId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static de.vik.testrail2java.types.primitive.Primitives.typeId;
import static de.vik.testrail2java.types.primitive.Primitives.userId;

public class CaseFilterTest {

    @Test
    public void filterKeys() throws Exception {
        assertThat(CaseFilter.bySuiteId(suiteId(1)), asStringIs("suite_id=1"));
        assertThat(CaseFilter.bySectionId(sectionId(1)), asStringIs("section_id=1"));
        assertThat(CaseFilter.byCreatedAfter(timestamp(1)), asStringIs("created_after=1"));
        assertThat(CaseFilter.byCreatedBefore(timestamp(1)), asStringIs("created_before=1"));
        assertThat(CaseFilter.byCreatedBy(userId(1)), asStringIs("created_by=1"));
        assertThat(CaseFilter.byCreatedBy(userId(1), userIds(2)), asStringIs("created_by=1,2"));
        assertThat(CaseFilter.byMilestoneId(milestoneId(1)), asStringIs("milestone_id=1"));
        assertThat(CaseFilter.byMilestoneId(milestoneId(1), milestoneIds(2)), asStringIs("milestone_id=1,2"));
        assertThat(CaseFilter.byPriorityId(priorityId(1)), asStringIs("priority_id=1"));
        assertThat(CaseFilter.byPriorityId(priorityId(1), priorityIds(2)), asStringIs("priority_id=1,2"));
        assertThat(CaseFilter.byTypeId(typeId(1)), asStringIs("type_id=1"));
        assertThat(CaseFilter.byTypeId(typeId(1), typeIds(2)), asStringIs("type_id=1,2"));
        assertThat(CaseFilter.byUpdatedAfter(timestamp(1)), asStringIs("updated_after=1"));
        assertThat(CaseFilter.byUpdatedBefore(timestamp(1)), asStringIs("updated_before=1"));
        assertThat(CaseFilter.byUpdatedBy(userId(1)), asStringIs("updated_by=1"));
        assertThat(CaseFilter.byUpdatedBy(userId(1), userIds(2)), asStringIs("updated_by=1,2"));
    }

    private Type.TypeId[] typeIds(int value) {
        return new Type.TypeId[]{typeId(value)};
    }

    private PriorityId[] priorityIds(int value) {
        return new PriorityId[]{priorityId(value)};
    }

    private Milestone.MilestoneId[] milestoneIds(int value) {
        return new Milestone.MilestoneId[]{milestoneId(value)};
    }

    private UserId[] userIds(int value) {
        return new UserId[]{userId(value)};
    }
}