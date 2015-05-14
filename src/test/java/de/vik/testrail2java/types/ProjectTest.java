package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProjectTest {

    @Test
    public void deserialization() throws Exception {
        String json= "{" +
                "    \"announcement\": \"Make it Run\"," +
                "    \"completed_on\": 1," +
                "    \"id\": 3," +
                "    \"is_completed\": true," +
                "    \"name\": \"Datahub\"," +
                "    \"show_announcement\": true," +
                "    \"suite_mode\": 2," +
                "    \"url\": \"http://<server>/testrail/index.php?/projects/overview/3\"" +
                "}";
        final Project actual = new GsonBuilder().create().fromJson(json, Project.class);
        assertThat(actual.getName(), equalTo("Datahub"));
        assertThat(actual.getId().asInt(), equalTo(3));
        assertThat(actual.getAnnouncement(), equalTo("Make it Run"));
        assertThat(actual.getCompletedOn().getValue(), equalTo(1L));
        assertThat(actual.getSuiteMode(), equalTo(SuiteMode.SINGLE_SUITE_WITH_BASELINES));
        assertThat(actual.getUrl(), equalTo("http://<server>/testrail/index.php?/projects/overview/3"));
        assertThat(actual.isCompleted(), equalTo(true));
        assertThat(actual.isShowAnnouncement(), equalTo(true));
    }

    @Test
    public void serialization() throws Exception {
        Project project = new Project("announcement", timestamp(1L), projectId(2), true, "name", true, SuiteMode.SINGLE_SUITE, "url");
        final String[] allowedFields = {"name", "announcement", "showAnnouncement", "suiteMode", "isCompleted"};
        final String actual = new GsonBuilder().createFor(allowedFields).toJson(project);
        assertThat(actual, equalTo(
                "{\n" +
                "  \"announcement\": \"announcement\",\n" +
                "  \"is_completed\": true,\n" +
                "  \"name\": \"name\",\n" +
                "  \"show_announcement\": true,\n" +
                "  \"suite_mode\": 1\n" +
                "}"));
    }
}