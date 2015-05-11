package de.vik.testrail2java.controller;

import org.junit.Test;

import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static de.vik.testrail2java.types.primitive.Primitives.milestoneId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static de.vik.testrail2java.types.primitive.Primitives.userId;
import static org.junit.Assert.*;

public class PlanFilterTest {
    @Test
    public void filterKeys() throws Exception {
        assertThat(Plans.PlanFilter.isCompleted(), asStringIs("is_completed=1"));
        assertThat(Plans.PlanFilter.createdBy(userId(1)), asStringIs("created_by=1"));
        assertThat(Plans.PlanFilter.createdBy(userId(1), userId(2)), asStringIs("created_by=1,2"));
        assertThat(Plans.PlanFilter.createdAfter(timestamp(3)), asStringIs("created_after=3"));
        assertThat(Plans.PlanFilter.createdBefore(timestamp(4)), asStringIs("created_before=4"));
        assertThat(Plans.PlanFilter.isActive(), asStringIs("is_completed=0"));
        assertThat(Plans.PlanFilter.limit(5), asStringIs("limit=5"));
        assertThat(Plans.PlanFilter.offset(6), asStringIs("offset=6"));
        assertThat(Plans.PlanFilter.milestoneId(milestoneId(7)), asStringIs("milestone_id=7"));
        assertThat(Plans.PlanFilter.milestoneId(milestoneId(8), milestoneId(9)), asStringIs("milestone_id=8,9"));
    }
}