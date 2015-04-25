package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import org.junit.Test;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import de.vik.testrail2java.testhelpers.JsonTestHelpers;
import de.vik.testrail2java.types.Plan;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static de.vik.testrail2java.testhelpers.JsonTestHelpers.jsonPrimitive;

public class PlanEntryIdAdapterTest {

    @Test
    public void deserialize() throws Exception {
        Plan.PlanEntryId result = target().deserialize(JsonTestHelpers.jsonPrimitive("22cadd88-d43d-48bb-97d7-2726af22166c"), ignoredType(), ignoredContext());
        assertThat(result.getValue(), equalTo("22cadd88-d43d-48bb-97d7-2726af22166c"));
    }

    @Test
    public void serialize() throws Exception {
        final Plan.PlanEntryId planEntryId = new Plan.PlanEntryId("22cadd88-d43d-48bb-97d7-2726af22166c") {};
        final PlanEntryIdAdapter target = target();
        JsonSerializationContext context = mock(JsonSerializationContext.class);
        when(context.serialize(planEntryId.getValue(), String.class)).thenReturn(JsonTestHelpers.jsonPrimitive(planEntryId.getValue()));

        JsonElement actual = target.serialize(planEntryId, ignoredType(), context);

        assertThat(actual.getAsString(), equalTo("22cadd88-d43d-48bb-97d7-2726af22166c"));
    }

    private PlanEntryIdAdapter target() {
        return new PlanEntryIdAdapter();
    }

    private JsonDeserializationContext ignoredContext() {
        return null;
    }

    private Type ignoredType() {
        return null;
    }
}