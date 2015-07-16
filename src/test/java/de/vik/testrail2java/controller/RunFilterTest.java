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
        assertThat(RunFilter.suiteId(suiteId(1)), asStringIs("suite_id=1"));
        assertThat(RunFilter.createdAfter(timestamp(123L)), asStringIs("created_after=123"));
        assertThat(RunFilter.createdBefore(timestamp(123L)), asStringIs("created_before=123"));
        assertThat(RunFilter.createdBy(userId(2)), asStringIs("created_by=2"));
        assertThat(RunFilter.milestoneId(milestoneId(3)), asStringIs("milestone_id=3"));
        assertThat(RunFilter.milestoneId(milestoneId(3), milestoneId(4)), asStringIs("milestone_id=3,4"));
        assertThat(RunFilter.isCompleted(), asStringIs("is_completed=1"));
        assertThat(RunFilter.isActive(), asStringIs("is_completed=0"));
        assertThat(RunFilter.limit(5), asStringIs("limit=5"));
        assertThat(RunFilter.offset(6), asStringIs("offset=6"));
    }
}