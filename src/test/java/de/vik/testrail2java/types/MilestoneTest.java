package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class MilestoneTest {

    @Test
    public void deserialize() throws Exception {
        String json = "{" +
                "    \"completed_on\": 1389968184," +
                "    \"description\": \"Works on my machine\"," +
                "    \"due_on\": 1391968185," +
                "    \"id\": 6," +
                "    \"is_completed\": true," +
                "    \"name\": \"Release 1.5\"," +
                "    \"project_id\": 1," +
                "    \"url\": \"http://<server>/testrail/index.php?/milestones/view/6\"" +
                "}";
        final Milestone actual = new GsonBuilder().create().fromJson(json, Milestone.class);
        assertThat(actual.getCompletedOn().getValue(), equalTo(1389968184L));
        assertThat(actual.getDescription(), equalTo("Works on my machine"));
        assertThat(actual.getDueOn().getValue(), equalTo(1391968185L));
        assertThat(actual.getId().getValue(), equalTo("6"));
        assertThat(actual.isCompleted(), equalTo(true));
        assertThat(actual.getName(), equalTo("Release 1.5"));
        assertThat(actual.getProjectId().getValue(), equalTo("1"));
        assertThat(actual.getUrl(), equalTo("http://<server>/testrail/index.php?/milestones/view/6"));
    }
}