package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.Status;

import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static org.junit.Assert.*;

public class StatusesTest {

    @Test
    public void testGetStatuses() throws Exception {
        testGetList(Status.class, "get_statuses",
                apiClient -> new Statuses(apiClient).getStatuses());
    }
}