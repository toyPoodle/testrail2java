package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.Status;

/**
 * http://docs.gurock.com/testrail-api2/reference-statuses
 */
public class Statuses {
    private APIClient client;

    public Statuses(APIClient client) {
        this.client = client;
    }

    public List<Status> getStatuses() {
        return client.getList(Status.class, new MethodUri("get_statuses"));
    }
}
