package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.controller.Projects.ProjectFilter;

import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static org.junit.Assert.assertThat;

public class ProjectFilterTest {

    @Test
    public void filterKeys() throws Exception {
        assertThat(ProjectFilter.isActive(), asStringIs("is_completed=0"));
        assertThat(ProjectFilter.isCompleted(), asStringIs("is_completed=1"));
    }
}