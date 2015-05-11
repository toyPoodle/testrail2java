package de.vik.testrail2java.controller;

import de.vik.testrail2java.types.Priority;
import org.junit.Test;

import static de.vik.testrail2java.testhelpers.Mockups.testGetList;

public class PrioritiesTest {

    @Test
    public void testGetPriorities() throws Exception {
        testGetList(Priority.class, "get_priorities", client -> new Priorities(client).getPriorities());
    }
}