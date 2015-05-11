package de.vik.testrail2java.types;

import de.vik.testrail2java.serialization.GsonBuilder;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class PriorityTest {

    @Test
    public void deserialization() throws Exception {
        String json = "{" +
                "        \"id\": 1," +
                "        \"is_default\": true," +
                "        \"name\": \"1 - Don't Test\"," +
                "        \"priority\": 2," +
                "        \"short_name\": \"1 - Don't\"" +
                "    }";
        final Priority actual = new GsonBuilder().create().fromJson(json, Priority.class);

        assertThat(actual.getId(), equalTo(new Priority.PriorityId(1)));
        assertThat(actual.getName(), equalTo("1 - Don't Test"));
        assertThat(actual.getPriority(), equalTo(2));
        assertThat(actual.getShortName(), equalTo("1 - Don't"));
        assertThat(actual.isDefault(), equalTo(true));
    }
}