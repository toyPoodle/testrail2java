package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.controller.Tests.TestFilter;

import static de.vik.testrail2java.testhelpers.MoreMatchers.asStringIs;
import static de.vik.testrail2java.types.primitive.Primitives.statusId;
import static org.junit.Assert.*;

public class TestFilterTest {

    @Test
    public void filterKeys() throws Exception {
        assertThat(TestFilter.byStatusId(statusId(1)), asStringIs("status_id=1"));
        assertThat(TestFilter.byStatusId(statusId(1), statusId(2)), asStringIs("status_id=1,2"));
    }
}