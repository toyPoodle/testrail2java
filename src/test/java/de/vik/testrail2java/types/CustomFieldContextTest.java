package de.vik.testrail2java.types;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.Test;

import de.vik.testrail2java.controller.ResultFields;
import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.RestClient;
import de.vik.testrail2java.serialization.GsonBuilder;
import de.vik.testrail2java.types.CustomFieldDefinition.CustomFieldContext;

import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CustomFieldContextTest {

    @Test
    public void deserialization() throws Exception {
        String json = "{\n" +
                "        \"is_global\": true,\n" +
                "        \"project_ids\": [1,2]\n" +
                "      }";

        final CustomFieldContext context = new GsonBuilder().create().fromJson(json, CustomFieldContext.class);
        
        assertThat(context.getIsGlobal(), equalTo(true));
        assertThat(context.getProjectIds(), Matchers.hasItems(projectId(1), projectId(2)));
    }
}