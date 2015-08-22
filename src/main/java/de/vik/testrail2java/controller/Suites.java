package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Suite;
import de.vik.testrail2java.types.Suite.SuiteId;

/**
 * http://docs.gurock.com/testrail-api2/reference-suites
 */
public class Suites {
    private final APIClient client;

    public Suites(APIClient client) {
        this.client = client;
    }

    /**
     * Returns an existing test suite.
     * @param id The ID of the test suite
     */
    public Suite getSuite(SuiteId id) {
        return client.get(Suite.class, new MethodUri("get_suite/:suite_id").withParameters(id));
    }

    /**
     * Returns a list of test suites for a project.
     * @param id The ID of the project
     */
    public List<Suite> getSuites(ProjectId id) {
        return client.getList(Suite.class, new MethodUri("get_suites/:project_id").withParameters(id));
    }

    /**
     * Creates a new test suite.
     * @param suite suite to add
     */
    public Suite addSuite(Suite suite) {
        final MethodUri uri = new MethodUri("add_suite/:project_id").withParameters(suite.getProjectId());
        final AllowedFields allowedFields = new AllowedFields(Suite.class, "name", "description");
        return client.post(uri, suite, allowedFields, Suite.class);
    }

    /**
     * Updates an existing test suite (partial updates are supported, i.e. you can submit and update specific fields only).
     * @param suite suite to update
     * @return updated suite
     */
    public Suite updateSuite(Suite suite) {
        final MethodUri uri = new MethodUri("update_suite/:suite_id").withParameters(suite.getId());
        final AllowedFields allowedFields = new AllowedFields(Suite.class, "name", "description");
        return client.post(uri, suite, allowedFields, Suite.class);
    }

    /**
     * Deletes an existing test suite. Please note: Deleting a test suite cannot be undone and also deletes all active test runs
     * & results, i.e. test runs & results that weren't closed (archived) yet.
     * @param id The ID of the test suite
     */
    public void deleteSuite(SuiteId id) {
        client.post(new MethodUri("delete_suite/:suite_id").withParameters(id));
    }
}