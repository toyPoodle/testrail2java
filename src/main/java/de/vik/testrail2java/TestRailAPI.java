package de.vik.testrail2java;

import de.vik.testrail2java.controller.CaseFields;
import de.vik.testrail2java.controller.Cases;
import de.vik.testrail2java.controller.Configurations;
import de.vik.testrail2java.controller.Milestones;
import de.vik.testrail2java.controller.Plans;
import de.vik.testrail2java.controller.Priorities;
import de.vik.testrail2java.controller.Projects;
import de.vik.testrail2java.controller.ResultFields;
import de.vik.testrail2java.controller.Results;
import de.vik.testrail2java.controller.Runs;
import de.vik.testrail2java.controller.Sections;
import de.vik.testrail2java.controller.Statuses;
import de.vik.testrail2java.controller.Suites;
import de.vik.testrail2java.controller.Tests;
import de.vik.testrail2java.controller.Types;
import de.vik.testrail2java.controller.Users;
import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.RestClient;
import de.vik.testrail2java.serialization.GsonBuilder;


public class TestRailAPI {
    private final String baseUrl;
    private final String testRailUser;
    private final String testRailPassword;

    public TestRailAPI(String baseUrl, String testRailUser, String testRailPassword) {
        this.baseUrl = baseUrl;
        this.testRailUser = testRailUser;
        this.testRailPassword = testRailPassword;
    }

    private APIClient getApiClient() {
        RestClient client = new RestClient(baseUrl);
        client.setUser(testRailUser);
        client.setPassword(testRailPassword);
        return new APIClient(client, new GsonBuilder());
    }

    public CaseFields caseFields() {
        return new CaseFields(getApiClient());
    }

    public Cases cases() {
        return new Cases(getApiClient());
    }

    public Configurations configurations() {
        return new Configurations(getApiClient());
    }

    public Milestones milestones() {
        return new Milestones(getApiClient());
    }

    public Plans plans() {
        return new Plans(getApiClient());
    }

    public Priorities priorities() {
        return new Priorities(getApiClient());
    }

    public Projects projects() {
        return new Projects(getApiClient());
    }

    public ResultFields resultFields() {
        return new ResultFields(getApiClient());
    }

    public Results results() {
        return new Results(getApiClient());
    }

    public Runs runs() {
        return new Runs(getApiClient());
    }

    public Sections sections() {
        return new Sections(getApiClient());
    }

    public Statuses statuses() {
        return new Statuses(getApiClient());
    }

    public Suites suites() {
        return new Suites(getApiClient());
    }

    public Tests tests() {
        return new Tests(getApiClient());
    }

    public Types types() {
        return new Types(getApiClient());
    }

    public Users users() {
        return new Users(getApiClient());
    }
}
