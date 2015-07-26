package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.serialization.GsonBuilder;

import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static de.vik.testrail2java.types.primitive.Primitives.suiteId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SuiteTest {

    @Test
    public void serialization() throws Exception {
        final Suite suite = new Suite(timestamp(1392300984L), "a description", suiteId(1), true, true, true, "Setup & Installation", projectId(2),
                "http://<server>/testrail/index.php?/suites/view/1");
        final String json = new GsonBuilder().createFor(new AllowedFields(Suite.class, "name", "description")).toJson(suite);
        String expected = "{\n" +
                "  \"description\": \"a description\",\n" +
                "  \"name\": \"Setup & Installation\"\n" +
                "}";
        assertThat(json, equalTo(expected));
    }

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "  \"completed_on\": 1392300984,\n" +
                "  \"description\": \"a description\",\n" +
                "  \"id\": 1,\n" +
                "  \"is_baseline\": true,\n" +
                "  \"is_completed\": true,\n" +
                "  \"is_master\": true,\n" +
                "  \"name\": \"Setup & Installation\",\n" +
                "  \"project_id\": 2,\n" +
                "  \"url\": \"http://<server>/testrail/index.php?/suites/view/1\"\n" +
                "}";
        final Suite suite = new GsonBuilder().create().fromJson(json, Suite.class);
        assertThat(suite.getCompletedOn().getValue(), equalTo(1392300984L));
        assertThat(suite.getDescription(), equalTo("a description"));
        assertThat(suite.getId().asInt(), equalTo(1));
        assertThat(suite.isBaseLine(), equalTo(true));
        assertThat(suite.isCompleted(), equalTo(true));
        assertThat(suite.isMaster(), equalTo(true));
        assertThat(suite.getName(), equalTo("Setup & Installation"));
        assertThat(suite.getProjectId(), equalTo(projectId(2)));
        assertThat(suite.getUrl(), equalTo("http://<server>/testrail/index.php?/suites/view/1"));

    }
}