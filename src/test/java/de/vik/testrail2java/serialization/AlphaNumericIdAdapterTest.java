package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import de.vik.testrail2java.testhelpers.JsonTestHelpers;
import de.vik.testrail2java.types.primitive.Id;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlphaNumericIdAdapterTest {

    @Test
    public void deserialize() throws Exception {
        Id result = target().deserialize(JsonTestHelpers.jsonPrimitive("22cadd88-d43d-48bb-97d7-2726af22166c"), TestId.class, ignoredContext());
        assertThat(result, Matchers.instanceOf(TestId.class));
        assertThat(result.getValue(), equalTo("22cadd88-d43d-48bb-97d7-2726af22166c"));
    }

    @Test
    public void serialize() throws Exception {
        final TestId id = new TestId("22cadd88-d43d-48bb-97d7-2726af22166c");
        JsonSerializationContext context = mock(JsonSerializationContext.class);
        when(context.serialize(id.getValue(), String.class)).thenReturn(JsonTestHelpers.jsonPrimitive(id.getValue()));

        JsonElement actual = target().serialize(id, ignoredType(), context);

        assertThat(actual.getAsString(), equalTo("22cadd88-d43d-48bb-97d7-2726af22166c"));
    }

    private AlphaNumericIdAdapter target() {
        return new AlphaNumericIdAdapter();
    }

    private JsonDeserializationContext ignoredContext() {
        return null;
    }

    private Type ignoredType() {
        return null;
    }

    private static class TestId extends Id {
        protected TestId(String id) {
            super(id);
        }
    }
}