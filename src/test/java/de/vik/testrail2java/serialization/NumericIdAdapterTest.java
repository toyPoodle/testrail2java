package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import org.junit.Test;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.NumericId;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static de.vik.testrail2java.testhelpers.JsonTestHelpers.jsonPrimitive;

public class NumericIdAdapterTest {

    @Test
    public void deserialization() throws Exception {
        Id result = target().deserialize(jsonPrimitive(3), resultType(TestId.class), ignoredContext());

        assertThat(result, instanceOf(TestId.class));
        assertThat(result.getValue(), equalTo("3"));
    }

    @Test
    public void serialization() throws Exception {
        final NumericId id = new NumericId(5) {};
        final NumericIdAdapter target = target();
        JsonSerializationContext context = mock(JsonSerializationContext.class);
        when(context.serialize(id.asInt(), int.class)).thenReturn(jsonPrimitive(id.getValue()));

        JsonElement actual = target.serialize(id, ignoredType(), context);

        assertThat(actual.getAsString(), equalTo("5"));
    }

    @Test
    public void deserializationWithPrivateConstructor() throws Exception {
        Id result = target().deserialize(jsonPrimitive(3), resultType(TestIdWithPrivateConstructor.class), ignoredContext());

        assertThat(result, instanceOf(TestIdWithPrivateConstructor.class));
        assertThat(result.getValue(), equalTo("3"));
    }

    private NumericIdAdapter target() {
        return new NumericIdAdapter();
    }

    private Type ignoredType() {
        return null;
    }

    private Type resultType(final Class<?> resultType) {
        return resultType;
    }

    private JsonDeserializationContext ignoredContext() {
        return null;
    }

    public static class TestId extends NumericId {
        public TestId(int id) {
            super(id);
        }
    }

    public static class TestIdWithPrivateConstructor extends NumericId {
        private TestIdWithPrivateConstructor(int id) {
            super(id);
        }
    }
}