package de.vik.testrail2java.types;

import org.junit.Test;

import de.vik.testrail2java.serialization.GsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class TypeTest {

    @Test
    public void serialize() throws Exception {
        String json = "{" +
                "        \"id\": 1," +
                "        \"is_default\": false," +
                "        \"name\": \"Automated\"" +
                "    }";
        final Type actual = new GsonBuilder().create().fromJson(json, Type.class);
        assertThat(actual.getId().getValue(), equalTo("1"));
        assertThat(actual.isDefault(), equalTo(false));
        assertThat(actual.getName(), equalTo("Automated"));
    }
}