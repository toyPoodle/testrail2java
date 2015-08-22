package de.vik.testrail2java.types;

import de.vik.testrail2java.serialization.GsonBuilder;

import static de.vik.testrail2java.types.primitive.Primitives.timeSpan;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestTest {

    @org.junit.Test
    public void deserialization() throws Exception {
        String json = "{" +
                "  \"assignedto_id\": 1," +
                "  \"case_id\": 2," +
                "  \"custom_expected\": \"nothing\"," +
                "  \"custom_preconds\": \"something\"," +
                "  \"custom_steps_separated\": [" +
                "    {" +
                "      \"content\": \"Step 1\"," +
                "      \"expected\": \"Expected Result 1\"" +
                "    }," +
                "    {" +
                "      \"content\": \"Step 2\"," +
                "      \"expected\": \"Expected Result 2\"" +
                "    }" +
                "  ]," +
                "  \"estimate\": \"1m 5s\"," +
                "  \"estimate_forecast\": \"1h 5m\"," +
                "  \"id\": 100," +
                "  \"milestone_id\": 101," +
                "  \"refs\": \"ISSUE-1\"," +
                "  \"priority_id\": 3," +
                "  \"run_id\": 4," +
                "  \"status_id\": 5," +
                "  \"title\": \"Verify line spacing on multi-page document\"," +
                "  \"type_id\": 6" +
                "}";
        final Test actual = new GsonBuilder().create().fromJson(json, Test.class);
        assertThat(actual.getAssignedToId().asInt(), equalTo(1));
        assertThat(actual.getCaseId().asInt(), equalTo(2));
        assertThat(actual.getExpected(), equalTo("nothing"));
        assertThat(actual.getPreconditions(), equalTo("something"));
        assertThat(actual.getSteps().size(), equalTo(2));
        assertThat(actual.getEstimate(), equalTo(timeSpan("1m 5s")));
        assertThat(actual.getEstimateForecast(), equalTo(timeSpan("1h 5m")));
        assertThat(actual.getId().asInt(), equalTo(100));
        assertThat(actual.getMilestoneId().asInt(), equalTo(101));
        assertThat(actual.getRefs(), equalTo("ISSUE-1"));
        assertThat(actual.getPriorityId().asInt(), equalTo(3));
        assertThat(actual.getRunId().asInt(), equalTo(4));
        assertThat(actual.getStatusId().asInt(), equalTo(5));
        assertThat(actual.getTitle(), equalTo("Verify line spacing on multi-page document"));
        assertThat(actual.getTypeId().asInt(), equalTo(6));

    }
}