package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.Status;

import static de.vik.testrail2java.testhelpers.Mockups.testGetList;

public class StatusesTest {

    @Test
    public void testGetStatuses() throws Exception {
        testGetList(Status.class, "get_statuses",
                apiClient -> new Statuses(apiClient).getStatuses());
    }
}