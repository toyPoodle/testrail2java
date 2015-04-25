package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class ConfigurationGroupTest {

    @Test
    public void deserializeConfigurationGroup() throws Exception {

        String json = "{" +
                "        \"configs\": [" +
                "            {" +
                "                \"group_id\": 1," +
                "                \"id\": 1," +
                "                \"name\": \"Chrome\"" +
                "            }," +
                "            {" +
                "                \"group_id\": 1," +
                "                \"id\": 2," +
                "                \"name\": \"Firefox\"" +
                "            }," +
                "            {" +
                "                \"group_id\": 1," +
                "                \"id\": 3," +
                "                \"name\": \"Internet Explorer\"" +
                "            }" +
                "        ]," +
                "        \"id\": 1," +
                "        \"name\": \"Browsers\"," +
                "        \"project_id\": 2" +
                "    }";
        final ConfigurationGroup actual = new GsonBuilder().create().fromJson(json, ConfigurationGroup.class);

        assertThat(actual.getConfigs(), hasSize(3));
        assertThat(actual.getId().getValue(), equalTo("1"));
        assertThat(actual.getName(), equalTo("Browsers"));
        assertThat(actual.getProjectId().getValue(), equalTo("2"));
    }

    @Test
    public void deserializeConfiguration() throws Exception {

        String json = "{" +
                "    \"group_id\": 1," +
                "    \"id\": 2," +
                "    \"name\": \"Chrome\"" +
                "}";
        final ConfigurationGroup.Configuration actual = new GsonBuilder().create().fromJson(json, ConfigurationGroup.Configuration.class);

        assertThat(actual.getGroupId().getValue(), equalTo("1"));
        assertThat(actual.getId().getValue(), equalTo("2"));
        assertThat(actual.getName(), equalTo("Chrome"));
    }
}