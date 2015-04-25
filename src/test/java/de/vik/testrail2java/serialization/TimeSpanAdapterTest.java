package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import org.junit.Test;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import de.vik.testrail2java.types.primitive.TimeSpan;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static de.vik.testrail2java.testhelpers.JsonTestHelpers.jsonPrimitive;

public class TimeSpanAdapterTest {

    @Test
    public void deserialize() throws Exception {
        TimeSpan result = target().deserialize(jsonPrimitive("24h 7m"), ignoredType(), ignoredContext());
        assertThat(result.getValue(), equalTo("24h 7m"));
    }

    @Test
    public void serialize() throws Exception {
        final TimeSpan timeSpan = new TimeSpan("12h 5m") {};
        final TimeSpanAdapter target = target();
        JsonSerializationContext context = mock(JsonSerializationContext.class);
        when(context.serialize(timeSpan.getValue(), String.class)).thenReturn(jsonPrimitive(timeSpan.getValue()));

        JsonElement actual = target.serialize(timeSpan, ignoredType(), context);

        assertThat(actual.getAsString(), equalTo("12h 5m"));
    }

    private TimeSpanAdapter target() {
        return new TimeSpanAdapter();
    }

    private JsonDeserializationContext ignoredContext() {
        return null;
    }

    private Type ignoredType() {
        return null;
    }
}