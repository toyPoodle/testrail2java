package de.vik.testrail2java.types.custom;

import org.junit.Test;

import com.google.gson.Gson;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.types.Status.StatusId;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StepResultTest {

    @Test
    public void serialization() throws Exception {
        final Gson gson = new GsonBuilder().createFor(new AllowedFields(StepResult.class, "content", "expected", "actual", "statusId"));
        final StepResult stepResult = new StepResult("Step 1", "Expected Result 1", "Actual Result 1", new StatusId(1));
        final String actual = gson.toJson(stepResult, StepResult.class);
        String expected = "{\n" +
                "  \"content\": \"Step 1\",\n" +
                "  \"expected\": \"Expected Result 1\",\n" +
                "  \"actual\": \"Actual Result 1\",\n" +
                "  \"status_id\": 1\n" +
                "}";
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "  \"content\": \"Step 1\",\n" +
                "  \"expected\": \"Expected Result 1\",\n" +
                "  \"actual\": \"Actual Result 1\",\n" +
                "  \"status_id\": 1\n" +
                "}";

        final Gson gson = new GsonBuilder().create();
        final StepResult actual = gson.fromJson(json, StepResult.class);

        assertThat(actual.getContent(), equalTo("Step 1"));
        assertThat(actual.getExpected(), equalTo("Expected Result 1"));
        assertThat(actual.getActual(), equalTo("Actual Result 1"));
        assertThat(actual.getStatusId().asInt(), equalTo(1));
    }
}