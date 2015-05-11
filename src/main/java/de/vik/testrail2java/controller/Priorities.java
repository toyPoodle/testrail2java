package de.vik.testrail2java.controller;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.Priority;

import java.util.List;

public class Priorities {
    private APIClient client;

    public Priorities(APIClient client) {
        this.client = client;
    }

    /**
     * Returns a list of available priorities.
     */
    public List<Priority> getPriorities() {
        return client.getList(Priority.class, new MethodUri("get_priorities"));
    }
}
