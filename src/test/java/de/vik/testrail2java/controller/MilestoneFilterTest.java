package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.controller.Milestones.MilestoneFilter;

import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static org.junit.Assert.*;

public class MilestoneFilterTest {

    @Test
    public void filterKeys() throws Exception {
        assertThat(MilestoneFilter.byIsCompleted(), asStringIs("is_completed=1"));
        assertThat(MilestoneFilter.byIsNotCompleted(), asStringIs("is_completed=0"));
    }
}