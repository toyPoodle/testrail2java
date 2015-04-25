package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.Type;

/**
 * http://docs.gurock.com/testrail-api2/reference-cases-types
 */
public class Types {
    private final APIClient apiClient;

    public Types(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Type> getCaseTypes() {
        return apiClient.getList(Type.class, new MethodUri("get_case_types"));
    }
}
