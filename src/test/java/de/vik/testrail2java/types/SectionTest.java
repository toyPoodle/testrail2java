package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.serialization.GsonBuilder;

import static de.vik.testrail2java.types.primitive.Primitives.sectionId;
import static de.vik.testrail2java.types.primitive.Primitives.suiteId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SectionTest {

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "  \"depth\": 3,\n" +
                "  \"description\": \"a description\",\n" +
                "  \"display_order\": 4,\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Prerequisites\",\n" +
                "  \"parent_id\": 2,\n" +
                "  \"suite_id\": 1\n" +
                "}";
        final Section section = new GsonBuilder().create().fromJson(json, Section.class);
        assertThat(section.getDepth(), equalTo(3));
        assertThat(section.getDescription(), equalTo("a description"));
        assertThat(section.getDisplayOrder(), equalTo(4));
        assertThat(section.getId().asInt(), equalTo(1));
        assertThat(section.getName(), equalTo("Prerequisites"));
        assertThat(section.getParentId().asInt(), equalTo(2));
        assertThat(section.getSuiteId().asInt(), equalTo(1));
    }

    @Test
    public void serialization() throws Exception {
        Section section = new Section(1, "a description", 2, sectionId(3), sectionId(4), "a name", suiteId(5));
        AllowedFields allowedFields = new AllowedFields(Section.class, "description", "suiteId", "parentId", "name");
        final String actual = new GsonBuilder().createFor(allowedFields).toJson(section);
        String expected = "{\n" +
                "  \"description\": \"a description\",\n" +
                "  \"parent_id\": 4,\n" +
                "  \"name\": \"a name\",\n" +
                "  \"suite_id\": 5\n" +
                "}";
        assertThat(actual, equalTo(expected));
    }
}