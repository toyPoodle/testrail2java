package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.ConfigurationGroup;
import de.vik.testrail2java.types.Project;

public class Configurations {
    private final APIClient apiClient;

    public Configurations(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<ConfigurationGroup> getConfigs(Project.ProjectId id) {
        return apiClient.getList(ConfigurationGroup.class, new MethodUri("get_configs/:project_id").withParameters(id));
    }
}
