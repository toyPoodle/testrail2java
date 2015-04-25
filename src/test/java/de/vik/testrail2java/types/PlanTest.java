package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PlanTest {

    @Test
    public void deserializePlan() throws Exception {
        String json = "{" +
                "    \"assignedto_id\": 1," +
                "    \"blocked_count\": 2," +
                "    \"completed_on\": 3," +
                "    \"created_by\": 4," +
                "    \"created_on\": 5," +
                "    \"custom_status1_count\": 6," +
                "    \"custom_status2_count\": 0," +
                "    \"custom_status3_count\": 0," +
                "    \"custom_status4_count\": 0," +
                "    \"custom_status5_count\": 0," +
                "    \"custom_status6_count\": 0," +
                "    \"custom_status7_count\": 0," +
                "    \"description\": \"self-describing\"," +
                "    \"entries\": [" +
                "    {" +
                "        \"id\": \"3933d74b-4282-4c1f-be62-a641ab427063\"," +
                "        \"name\": \"File Formats\"," +
                "        \"runs\": [" +
                "        {" +
                "            \"assignedto_id\": 6," +
                "            \"blocked_count\": 0," +
                "            \"completed_on\": null," +
                "            \"config\": \"Firefox, Ubuntu 12\"," +
                "            \"config_ids\": [" +
                "                2," +
                "                6" +
                "            ]," +
                "            \"custom_status1_count\": 0," +
                "            \"custom_status2_count\": 0," +
                "            \"custom_status3_count\": 0," +
                "            \"custom_status4_count\": 0," +
                "            \"custom_status5_count\": 0," +
                "            \"custom_status6_count\": 0," +
                "            \"custom_status7_count\": 0," +
                "            \"description\": null," +
                "            \"entry_id\": \"3933d74b-4282-4c1f-be62-a641ab427063\"," +
                "            \"entry_index\": 1," +
                "            \"failed_count\": 2," +
                "            \"id\": 81," +
                "            \"include_all\": false," +
                "            \"is_completed\": false," +
                "            \"milestone_id\": 7," +
                "            \"name\": \"File Formats\"," +
                "            \"passed_count\": 2," +
                "            \"plan_id\": 80," +
                "            \"project_id\": 1," +
                "            \"retest_count\": 1," +
                "            \"suite_id\": 4," +
                "            \"untested_count\": 3," +
                "            \"url\": \"http://<server>/testrail/index.php?/runs/view/81\"" +
                "        }" +
                "        ]," +
                "        \"suite_id\": 4" +
                "    }" +
                "    ]," +
                "    \"failed_count\": 7," +
                "    \"id\": 8," +
                "    \"is_completed\": true," +
                "    \"milestone_id\": 9," +
                "    \"name\": \"System test\"," +
                "    \"passed_count\": 10," +
                "    \"project_id\": 11," +
                "    \"retest_count\": 12," +
                "    \"untested_count\": 13," +
                "    \"url\": \"http://<server>/testrail/index.php?/plans/view/8\"" +
                "}";
        final Plan actual = new GsonBuilder().create().fromJson(json, Plan.class);

        assertThat(actual.getAssignedtoId().getValue(), equalTo("1"));
        assertThat(actual.getBlockedCount(), equalTo(2));
        assertThat(actual.getCompletedOn().getValue(), equalTo(3L));
        assertThat(actual.getCreatedBy().getValue(), equalTo("4"));
        assertThat(actual.getCreatedOn().getValue(), equalTo(5L));
        assertThat(actual.getCustomStatus1Count(), equalTo(6));
        assertThat(actual.getDescription(), equalTo("self-describing"));
        assertThat(actual.getEntries(), hasSize(1));
        assertThat(actual.getFailedCount(), equalTo(7));
        assertThat(actual.getId().getValue(), equalTo("8"));
        assertThat(actual.isCompleted(), equalTo(true));
        assertThat(actual.getMilestoneId().getValue(), equalTo("9"));
        assertThat(actual.getName(), equalTo("System test"));
        assertThat(actual.getPassedCount(), equalTo(10));
        assertThat(actual.getProjectId().getValue(), equalTo("11"));
        assertThat(actual.getRetestCount(), equalTo(12));
        assertThat(actual.getUntestedCount(), equalTo(13));
        assertThat(actual.getUrl(), equalTo("http://<server>/testrail/index.php?/plans/view/8"));

    }

    @Test
    public void deserializePlanEntry() throws Exception {
        String json = "{" +
                "    \"id\": \"22cadd88-d43d-48bb-97d7-2726af22166c\"," +
                "    \"suite_id\": 7," +
                "    \"name\": \"Web\"," +
                "    \"runs\": [" +
                "        {" +
                "            \"suite_id\": 1," +
                "            \"assignedto_id\": 9," +
                "            \"name\": \"Web\"," +
                "            \"include_all\": true," +
                "            \"is_completed\": true," +
                "            \"passed_count\": 10," +
                "            \"blocked_count\": 11," +
                "            \"untested_count\": 12," +
                "            \"retest_count\": 13," +
                "            \"failed_count\": 14," +
                "            \"project_id\": 15," +
                "            \"plan_id\": 16," +
                "            \"entry_index\": 1," +
                "            \"entry_id\": \"22cadd88-d43d-48bb-97d7-2726af22166c\"," +
                "            \"case_ids\": [18, 19]," +
                "            \"config_ids\": [2, 5]," +
                "            \"id\": 17" +
                "        }" +
                "    ]," +
                "    \"assignedto_id\": 8," +
                "    \"include_all\": true," +
                "    \"config_ids\": [18, 19]" +
                "}";

        final Plan.PlanEntry actual = new GsonBuilder().create().fromJson(json, Plan.PlanEntry.class);

        assertThat(actual.getConfigIds(), hasSize(2));
        assertThat(actual.getConfigIds().get(0).getValue(), equalTo("18"));
        assertThat(actual.getConfigIds().get(1).getValue(), equalTo("19"));

        assertThat(actual.getId().getValue(), equalTo("22cadd88-d43d-48bb-97d7-2726af22166c"));
        assertThat(actual.getName(), equalTo("Web"));
        assertThat(actual.getRuns(), hasSize(1));
        assertThat(actual.getSuiteId().getValue(), equalTo("7"));
        assertThat(actual.getAssignedtoId().getValue(), equalTo("8"));
        assertThat(actual.isIncludeAll(), equalTo(true));

        Plan.TestRun run = actual.getRuns().get(0);
        assertThat(run.getSuiteId().getValue(), equalTo("1"));
        assertThat(run.getAssignedtoId().getValue(), equalTo("9"));
        assertThat(run.getName(), equalTo("Web"));
        assertThat(run.isIncludeAll(), equalTo(true));
        assertThat(run.isCompleted(), equalTo(true));
        assertThat(run.getPassedCount(), equalTo(10));
        assertThat(run.getBlockedCount(), equalTo(11));
        assertThat(run.getUntestedCount(), equalTo(12));
        assertThat(run.getRetestCount(), equalTo(13));
        assertThat(run.getFailedCount(), equalTo(14));
        assertThat(run.getProjectId().getValue(), equalTo("15"));
        assertThat(run.getPlanId().getValue(), equalTo("16"));
        assertThat(run.getEntryIndex(), equalTo(1));
        assertThat(run.getEntryId().getValue(), equalTo("22cadd88-d43d-48bb-97d7-2726af22166c"));
        assertThat(run.getId().getValue(), equalTo("17"));
        assertThat(run.getConfigIds(), hasSize(2));
        assertThat(run.getConfigIds().get(0).getValue(), equalTo("2"));
        assertThat(run.getConfigIds().get(1).getValue(), equalTo("5"));
        assertThat(run.getCaseIds(), hasSize(2));
        assertThat(run.getCaseIds().get(0).getValue(), equalTo("18"));
        assertThat(run.getCaseIds().get(1).getValue(), equalTo("19"));

    }
/*
    @Test
    public void test() throws Exception {
        ConfigPropertiesReader configReader = new ConfigPropertiesReader("/configfile/config.properties");
        RestClient client = new RestClient(configReader.getProperty("testRailURL"));
        client.setUser(configReader.getProperty("testRailUser"));
        client.setPassword(configReader.getProperty("testRailPassword"));
        final APIClient apiClientGET = new APIClient(client, new GsonBuilder());
        final Plan plan = new Plans(apiClientGET).getPlan(new PlanId(673));
        System.out.println(plan);
    }
    */
}