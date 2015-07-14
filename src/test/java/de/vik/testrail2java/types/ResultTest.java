package de.vik.testrail2java.types;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.types.Test.TestId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.custom.StepResult;
import de.vik.testrail2java.types.primitive.TimeSpan;
import de.vik.testrail2java.types.primitive.Timestamp;

import static de.vik.testrail2java.types.primitive.Primitives.statusId;
import static de.vik.testrail2java.types.primitive.Primitives.timeSpan;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static de.vik.testrail2java.types.primitive.Primitives.userId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ResultTest {
    @Test
    public void serialization() throws Exception {
        String expected = "{\n" +
                "  \"assignedto_id\": 1,\n" +
                "  \"comment\": \"This test failed: ..\",\n" +
                "  \"custom_step_results\": [\n" +
                "    {\n" +
                "      \"content\": \"Step 1\",\n" +
                "      \"expected\": \"Expected Result 1\",\n" +
                "      \"actual\": \"Actual Result 1\",\n" +
                "      \"status_id\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"defects\": \"TR-1\",\n" +
                "  \"elapsed\": \"5m\",\n" +
                "  \"status_id\": 5,\n" +
                "  \"version\": \"1.0RC1\"\n" +
                "}";
        final AllowedFields allowedFields = new AllowedFields(Result.class, "assignedtoId", "comment", "customStepResults",
                "defects", "elapsed", "statusId", "version")
                .and(StepResult.class, "content", "expected", "actual", "statusId");
        Gson builder = new GsonBuilder().createFor(allowedFields);

        UserId assignedToId = userId(1);
        UserId createdBy = userId(2);
        Timestamp createdOn = timestamp(1393851801L);
        List<StepResult> stepResults = Collections.singletonList(new StepResult("Step 1", "Expected Result 1", "Actual Result 1", statusId(1)));
        TimeSpan elapsed = timeSpan("5m");
        Result.ResultId resultId = new Result.ResultId(3);
        Status.StatusId statusId = statusId(5);
        TestId testId = new TestId(4);
        Result result = new Result(assignedToId, "This test failed: ..", createdBy, createdOn, stepResults, "TR-1", elapsed, resultId, statusId, testId, "1.0RC1");

        final String actual = builder.toJson(result, Result.class);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "  \"assignedto_id\": 1,\n" +
                "  \"comment\": \"This test failed: ..\",\n" +
                "  \"created_by\": 2,\n" +
                "  \"created_on\": 1393851801,\n" +
                "  \"custom_step_results\": [\n" +
                "  {\n" +
                "      \"content\": \"Step 1\",\n" +
                "      \"expected\": \"Expected Result 1\",\n" +
                "      \"actual\": \"Actual Result 1\",\n" +
                "      \"status_id\": 1\n" +
                "  }\n" +
                "  ],\n" +
                "  \"defects\": \"TR-1\",\n" +
                "  \"elapsed\": \"5m\",\n" +
                "  \"id\": 3,\n" +
                "  \"status_id\": 5,\n" +
                "  \"test_id\": 4,\n" +
                "  \"version\": \"1.0RC1\"\n" +
                "}";
        final Result result = new GsonBuilder().create().fromJson(json, Result.class);

        assertThat(result.getAssignedToId().asInt(), equalTo(1));
        assertThat(result.getComment(), equalTo("This test failed: .."));
        assertThat(result.getCreatedBy().asInt(), equalTo(2));
        assertThat(result.getCreatedOn().getValue(), equalTo(1393851801L));
        assertThat(result.getStepResults().size(), equalTo(1));
        assertThat(result.getDefects(), equalTo("TR-1"));
        assertThat(result.getElapsed().getValue(), equalTo("5m"));
        assertThat(result.getId().asInt(), equalTo(3));
        assertThat(result.getStatusId().asInt(), equalTo(5));
        assertThat(result.getTestId().asInt(), equalTo(4));
        assertThat(result.getVersion(), equalTo("1.0RC1"));
    }
}