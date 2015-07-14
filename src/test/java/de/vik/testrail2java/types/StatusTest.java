package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StatusTest {

    @Test
    public void deserialization() throws Exception {
        String json = 
            "{\n" +
            "  \"color_bright\": 12709313,\n" +
            "  \"color_dark\": 6667107,\n" +
            "  \"color_medium\": 9820525,\n" +
            "  \"id\": 1,\n" +
            "  \"is_final\": true,\n" +
            "  \"is_system\": true,\n" +
            "  \"is_untested\": true,\n" +
            "  \"label\": \"Untested\",\n" +
            "  \"name\": \"untested\"\n" +
            "}";
        final Status actual = new GsonBuilder().create().fromJson(json, Status.class);
        assertThat(actual.getColorBright(), equalTo(12709313));
        assertThat(actual.getColorDark(), equalTo(6667107));
        assertThat(actual.getColorMedium(), equalTo(9820525));
        assertThat(actual.getId().asInt(), equalTo(1));
        assertThat(actual.isFinal(), equalTo(true));
        assertThat(actual.isSystem(), equalTo(true));
        assertThat(actual.isUntested(), equalTo(true));
        assertThat(actual.getLabel(), equalTo("Untested"));
        assertThat(actual.getName(), equalTo("untested"));
    }
}