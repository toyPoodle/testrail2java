package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.controller.Runs.RunFilter;

import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static de.vik.testrail2java.types.primitive.Primitives.milestoneId;
import static de.vik.testrail2java.types.primitive.Primitives.suiteId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static de.vik.testrail2java.types.primitive.Primitives.userId;
import static org.junit.Assert.*;

public class RunFilterTest {


    @Test
    public void testName() throws Exception {
        assertThat(RunFilter.bySuiteId(suiteId(1)), asStringIs("suite_id=1"));
        assertThat(RunFilter.byCreatedAfter(timestamp(123L)), asStringIs("created_after=123"));
        assertThat(RunFilter.byCreatedBefore(timestamp(123L)), asStringIs("created_before=123"));
        assertThat(RunFilter.byCreatedBy(userId(2)), asStringIs("created_by=2"));
        assertThat(RunFilter.byMilestoneId(milestoneId(3)), asStringIs("milestone_id=3"));
        assertThat(RunFilter.byMilestoneId(milestoneId(3), milestoneId(4)), asStringIs("milestone_id=3%2C4"));
        assertThat(RunFilter.byIsCompleted(), asStringIs("is_completed=1"));
        assertThat(RunFilter.byIsActive(), asStringIs("is_completed=0"));
        assertThat(RunFilter.byLimit(5), asStringIs("limit=5"));
        assertThat(RunFilter.byOffset(6), asStringIs("offset=6"));
    }
}