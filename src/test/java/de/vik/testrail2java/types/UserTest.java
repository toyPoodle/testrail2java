package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "     \"email\": \"alexis@example.com\",\n" +
                "     \"id\": 1,\n" +
                "     \"is_active\": true,\n" +
                "     \"name\": \"Alexis Gonzalez\"\n" +
                "     }";
        final User user = new GsonBuilder().create().fromJson(json, User.class);
        assertThat(user.getEmail(), equalTo("alexis@example.com"));
        assertThat(user.getId().asInt(), equalTo(1));
        assertThat(user.isActive(), equalTo(true));
        assertThat(user.getName(), equalTo("Alexis Gonzalez"));
    }
}