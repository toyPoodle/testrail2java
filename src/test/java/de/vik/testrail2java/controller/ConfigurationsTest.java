package de.vik.testrail2java.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.vik.testrail2java.types.ConfigurationGroup;
import de.vik.testrail2java.testhelpers.Mockups;
import de.vik.testrail2java.types.Project.ProjectId;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class ConfigurationsTest {

    @Test
    public void getConfigs() throws Exception {
        List<ConfigurationGroup> expected = new ArrayList<ConfigurationGroup>();
        Configurations target = new Configurations(Mockups.apiClientGET(ConfigurationGroup.class, "get_configs/1", expected));

        final List<ConfigurationGroup> actual = target.getConfigs(new ProjectId(1));

        assertThat(actual, sameInstance(expected));
    }

}