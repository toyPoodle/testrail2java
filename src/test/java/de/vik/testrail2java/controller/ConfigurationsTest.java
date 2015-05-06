package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.ConfigurationGroup;
import de.vik.testrail2java.types.Project.ProjectId;

import static de.vik.testrail2java.testhelpers.Mockups.testGetList;

public class ConfigurationsTest {

    @Test
    public void getConfigs() throws Exception {
        testGetList(ConfigurationGroup.class, "get_configs/1",
                (client) -> new Configurations(client).getConfigs(new ProjectId(1)));
    }

}