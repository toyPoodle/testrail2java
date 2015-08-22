package de.vik.testrail2java;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.RestClient;
import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.controller.Cases;


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

    public Cases cases() {
        return new Cases(getApiClient());
    }

}
