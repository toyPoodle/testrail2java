package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.controller.Plans.PlanFilter;

import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static de.vik.testrail2java.types.primitive.Primitives.milestoneId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static de.vik.testrail2java.types.primitive.Primitives.userId;
import static org.junit.Assert.*;

public class PlanFilterTest {
    @Test
    public void filterKeys() throws Exception {
        assertThat(PlanFilter.byIsCompleted(), asStringIs("is_completed=1"));
        assertThat(PlanFilter.byCreatedBy(userId(1)), asStringIs("created_by=1"));
        assertThat(PlanFilter.byCreatedBy(userId(1), userId(2)), asStringIs("created_by=1%2C2"));
        assertThat(PlanFilter.byCreatedAfter(timestamp(3)), asStringIs("created_after=3"));
        assertThat(PlanFilter.byCreatedBefore(timestamp(4)), asStringIs("created_before=4"));
        assertThat(PlanFilter.byIsActive(), asStringIs("is_completed=0"));
        assertThat(PlanFilter.byLimit(5), asStringIs("limit=5"));
        assertThat(PlanFilter.byOffset(6), asStringIs("offset=6"));
        assertThat(PlanFilter.byMilestoneId(milestoneId(7)), asStringIs("milestone_id=7"));
        assertThat(PlanFilter.byMilestoneId(milestoneId(8), milestoneId(9)), asStringIs("milestone_id=8%2C9"));
    }
}