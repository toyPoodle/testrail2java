package de.vik.testrail2java.types;

import java.util.Arrays;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.types.ConfigurationGroup.ConfigurationId;
import de.vik.testrail2java.types.Plan.PlanEntryId;

import static de.vik.testrail2java.types.primitive.Primitives.caseId;
import static de.vik.testrail2java.types.primitive.Primitives.milestoneId;
import static de.vik.testrail2java.types.primitive.Primitives.planId;
import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static de.vik.testrail2java.types.primitive.Primitives.runId;
import static de.vik.testrail2java.types.primitive.Primitives.suiteId;
import static de.vik.testrail2java.types.primitive.Primitives.timestamp;
import static de.vik.testrail2java.types.primitive.Primitives.userId;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class RunTest {

    @Test
    public void deserialization() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        String json = "{\n" +
                "  \"assignedto_id\": 3,\n" +
                "  \"blocked_count\": 1,\n" +
                "  \"completed_on\": 1393900000,\n" +
                "  \"config\": \"Firefox, Ubuntu 12\",\n" +
                "  \"config_ids\": [\n" +
                "    2,\n" +
                "    6\n" +
                "  ],\n" +
                "  \"created_by\": 4,\n" +
                "  \"created_on\": 1393845644,\n" +
                "  \"custom_status1_count\": 5,\n" +
                "  \"custom_status2_count\": 7,\n" +
                "  \"custom_status3_count\": 8,\n" +
                "  \"custom_status4_count\": 9,\n" +
                "  \"custom_status5_count\": 10,\n" +
                "  \"custom_status6_count\": 11,\n" +
                "  \"custom_status7_count\": 12,\n" +
                "  \"description\": \"a description\",\n" +
                "  \"failed_count\": 13,\n" +
                "  \"id\": 81,\n" +
                "  \"include_all\": true,\n" +
                "  \"is_completed\": true,\n" +
                "  \"milestone_id\": 14,\n" +
                "  \"name\": \"File Formats\",\n" +
                "  \"passed_count\": 15,\n" +
                "  \"plan_id\": 80,\n" +
                "  \"project_id\": 16,\n" +
                "  \"retest_count\": 17,\n" +
                "  \"suite_id\": 18,\n" +
                "  \"untested_count\": 19,\n" +
                "  \"entry_id\": \"3933d74b-4282-4c1f-be62-a641ab427063\"," +
                "  \"entry_index\": 20," +
                "  \"case_ids\": [21,22]," +
                "  \"url\": \"http://<server>/testrail/index.php?/runs/view/81\"\n" +
                "}";

        final Run run = new GsonBuilder().create().fromJson(json, Run.class);
        assertThat(run.getAssignedToId().getValue(), equalTo("3"));
        assertThat(run.getBlockedCount(), equalTo(1));
        assertThat(run.getCompletedOn(), equalTo(timestamp(1393900000L)));
        assertThat(run.getConfig(), equalTo("Firefox, Ubuntu 12"));
        assertThat(run.getConfigIds(), hasSize(2));
        assertThat(run.getConfigIds().get(0).getValue(), equalTo("2"));
        assertThat(run.getConfigIds().get(1).getValue(), equalTo("6"));
        assertThat(run.getCreatedBy(), equalTo(userId(4)));
        assertThat(run.getCreatedOn(), equalTo(timestamp(1393845644)));
        assertThat(run.getCustomStatus1Count(), equalTo(5));
        assertThat(run.getCustomStatus2Count(), equalTo(7));
        assertThat(run.getCustomStatus3Count(), equalTo(8));
        assertThat(run.getCustomStatus4Count(), equalTo(9));
        assertThat(run.getCustomStatus5Count(), equalTo(10));
        assertThat(run.getCustomStatus6Count(), equalTo(11));
        assertThat(run.getCustomStatus7Count(), equalTo(12));
        assertThat(run.getDescription(), equalTo("a description"));
        assertThat(run.getFailedCount(), equalTo(13));
        assertThat(run.getId().getValue(), equalTo("81"));
        assertThat(run.isIncludeAll(), equalTo(true));
        assertThat(run.isCompleted(), equalTo(true));
        assertThat(run.getMilestoneId().getValue(), equalTo("14"));
        assertThat(run.getName(), equalTo("File Formats"));
        assertThat(run.getPassedCount(), equalTo(15));
        assertThat(run.getPlanId().getValue(), equalTo("80"));
        assertThat(run.getProjectId().getValue(), equalTo("16"));
        assertThat(run.getRetestCount(), equalTo(17));
        assertThat(run.getSuiteId().getValue(), equalTo("18"));
        assertThat(run.getUntestedCount(), equalTo(19));
        assertThat(run.getEntryId().getValue(), equalTo("3933d74b-4282-4c1f-be62-a641ab427063"));
        assertThat(run.getEntryIndex(), equalTo(20));
        assertThat(run.getCaseIds(), hasSize(2));
        assertThat(run.getCaseIds().get(0).getValue(), equalTo("21"));
        assertThat(run.getCaseIds().get(1).getValue(), equalTo("22"));
        assertThat(run.getUrl(), equalTo("http://<server>/testrail/index.php?/runs/view/81"));
    }

    @Test
    public void serialization() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        AllowedFields allowedFields = new AllowedFields(Run.class, "suiteId", "name", "description",
                "milestoneId", "assignedtoId", "includeAll", "caseIds");
        String actual = new GsonBuilder().createFor(allowedFields).toJson(new Run(userId(1), 2, timestamp(1393900000L), "Firefox, Ubuntu 12",
                Arrays.asList(new ConfigurationId(3), new ConfigurationId(4)), userId(5), timestamp(1393845644L), 6, 7, 8, 9, 10, 11, 12,
                "a description", 13, runId(14), true, true, milestoneId(15), planId(16), "This is a new test run", 17, projectId(18), 19,
                suiteId(20), 21, "url", 22, new PlanEntryId("23"), Arrays.asList(caseId(24), caseId(25))));
        @SuppressWarnings("SpellCheckingInspection")
        final String expected = "{\n" +
                "  \"assignedto_id\": 1,\n" +
                "  \"description\": \"a description\",\n" +
                "  \"include_all\": true,\n" +
                "  \"milestone_id\": 15,\n" +
                "  \"name\": \"This is a new test run\",\n" +
                "  \"suite_id\": 20,\n" +
                "  \"case_ids\": [\n" +
                "    24,\n" +
                "    25\n" +
                "  ]\n" +
                "}";
        assertThat(actual, equalTo(expected));
    }
}