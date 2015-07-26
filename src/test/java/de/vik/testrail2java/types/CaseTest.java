package de.vik.testrail2java.types;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.types.Case.CaseId;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Suite.SuiteId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.custom.Step;
import de.vik.testrail2java.types.primitive.TimeSpan;
import de.vik.testrail2java.types.primitive.Timestamp;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.User.UserId;

import static de.vik.testrail2java.types.primitive.Primitives.caseId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SuppressWarnings("SpellCheckingInspection")
public class CaseTest {

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "    \"created_by\": 5,\n" +
                "    \"created_on\": 1392300984,\n" +
                "    \"custom_expected\": \"..\",\n" +
                "    \"custom_steps\": \"..\",\n" +
                "    \"custom_steps_separated\":[" +
                "       {" +
                "           \"expected\":\"dog found\"," +
                "           \"content\":\"find dog\"" +
                "       }," +
                "       {" +
                "           \"expected\":\"dog toy found\"," +
                "           \"content\":\"find dog toy\"" +
                "       }," +
                "       {" +
                "           \"expected\":\"dog happy\"," +
                "           \"content\":\"join dog and dog toy\"" +
                "       }" +
                "    ],\n" +
                "    \"custom_preconds\":\"you have a dog\",\n" +
                "    \"custom_testdata\":\"name=wuff\",\n" +
                "    \"estimate\": \"1m 5s\",\n" +
                "    \"estimate_forecast\": \"4m 5s\",\n" +
                "    \"id\": 1,\n" +
                "    \"milestone_id\": 7,\n" +
                "    \"priority_id\": 2,\n" +
                "    \"refs\": \"RF-1, RF-2\",\n" +
                "    \"section_id\": 3,\n" +
                "    \"suite_id\": 6,\n" +
                "    \"title\": \"Change document attributes (author, title, organization)\",\n" +
                "    \"type_id\": 4,\n" +
                "    \"updated_by\": 8,\n" +
                "    \"updated_on\": 1393586511\n" +
                "}";

        Case actual = new GsonBuilder().create().fromJson(json, Case.class);

        assertThat(actual.getCreatedBy().getValue(), equalTo("5"));
        assertThat(actual.getCreatedOn().getValue(), equalTo(1392300984L));
        assertThat(actual.getPreconditions(), equalTo("you have a dog"));
        assertThat(actual.getTestData(), equalTo("name=wuff"));
        assertThat(actual.getEstimate().getValue(), equalTo("1m 5s"));
        assertThat(actual.getEstimateForecast().getValue(), equalTo("4m 5s"));
        assertThat(actual.getId().getValue(), equalTo("1"));
        assertThat(actual.getMilestoneId().getValue(), equalTo("7"));
        assertThat(actual.getPriorityId().getValue(), equalTo("2"));
        assertThat(actual.getRefs(), equalTo("RF-1, RF-2"));
        assertThat(actual.getSectionId().getValue(), equalTo("3"));
        assertThat(actual.getSuiteId().getValue(), equalTo("6"));
        assertThat(actual.getTitle(), equalTo("Change document attributes (author, title, organization)"));
        assertThat(actual.getTypeId().getValue(), equalTo("4"));
        assertThat(actual.getUpdatedBy().getValue(), equalTo("8"));
        assertThat(actual.getUpdatedOn().getValue(), equalTo(1393586511L));
        assertThat(actual.getSteps().size(), equalTo(3));
    }

    @Test
    public void serialization() throws Exception {
        UserId createdBy = new UserId(1);
        Timestamp createdOn = new Timestamp(1392300984L);
        TimeSpan estimate = new TimeSpan("14h, 23s");
        TimeSpan estimateForecast = new TimeSpan("1h, 2s");
        CaseId id = caseId(2);
        MilestoneId milestoneId = new MilestoneId(3);
        PriorityId priorityId = new PriorityId(4);
        String refs = "REF-1, REF-2";
        SectionId sectionId = new SectionId(5);
        SuiteId suiteId = new SuiteId(6);
        String title = "serialization of objects to json";
        TypeId typeId = new TypeId(7);
        UserId updatedBy = new UserId(8);
        Timestamp updatedOn = new Timestamp(1393586511L);
        List<Step> steps = Arrays.asList(new Step("expected 1", "content 1"), new Step("expected 2", "content 2"));
        String preconditions = "there is something to test";
        String testData = "a=b, c=d";
        Case c = new Case(createdBy, createdOn, estimate, estimateForecast, id, milestoneId, priorityId, refs, sectionId, suiteId, title,
                typeId, updatedBy, updatedOn, steps, preconditions, testData);

        Gson gson = new GsonBuilder().create();

        String json = gson.toJson(c);

        String expected = "{\n" +
                "  \"created_by\": 1,\n" +
                "  \"created_on\": 1392300984,\n" +
                "  \"estimate\": \"14h, 23s\",\n" +
                "  \"estimate_forecast\": \"1h, 2s\",\n" +
                "  \"id\": 2,\n" +
                "  \"milestone_id\": 3,\n" +
                "  \"priority_id\": 4,\n" +
                "  \"refs\": \"REF-1, REF-2\",\n" +
                "  \"section_id\": 5,\n" +
                "  \"suite_id\": 6,\n" +
                "  \"title\": \"serialization of objects to json\",\n" +
                "  \"type_id\": 7,\n" +
                "  \"updated_by\": 8,\n" +
                "  \"updated_on\": 1393586511,\n" +
                "  \"custom_steps_separated\": [\n" +
                "    {\n" +
                "      \"expected\": \"expected 1\",\n" +
                "      \"content\": \"content 1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"expected\": \"expected 2\",\n" +
                "      \"content\": \"content 2\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"custom_preconds\": \"there is something to test\",\n" +
                "  \"custom_testdata\": \"a=b, c=d\"\n" +
                "}";
        assertThat(json, equalTo(expected));
    }

    @Test
    public void fieldExclusion() throws Exception {
        UserId createdBy = new UserId(1);
        Timestamp createdOn = new Timestamp(1392300984L);
        TimeSpan estimate = new TimeSpan("14h, 23s");
        TimeSpan estimateForecast = new TimeSpan("1h, 2s");
        CaseId id = caseId(2);
        MilestoneId milestoneId = new MilestoneId(3);
        PriorityId priorityId = new PriorityId(4);
        String refs = "REF-1, REF-2";
        SectionId sectionId = new SectionId(5);
        SuiteId suiteId = new SuiteId(6);
        String title = "serialization of objects to json";
        TypeId typeId = new TypeId(7);
        UserId updatedBy = new UserId(8);
        Timestamp updatedOn = new Timestamp(1393586511L);
        List<Step> steps = Arrays.asList(new Step("expected 1", "content 1"), new Step("expected 2", "content 2"));
        String preconditions = "there is something to test";
        String testData = "a=b, c=d";
        final Case c = new Case(createdBy, createdOn, estimate, estimateForecast, id, milestoneId, priorityId, refs, sectionId, suiteId,
                title, typeId, updatedBy, updatedOn, steps, preconditions, testData);

        final Gson gson = new GsonBuilder().createFor(new AllowedFields(Case.class, "createdBy"));

        String json = gson.toJson(c);
        String expected = "{\n" +
                            "  \"created_by\": 1\n" +
                            "}";
        assertThat(json, equalTo(expected));
    }

}