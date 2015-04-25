package de.vik.testrail2java.serialization;

import java.lang.reflect.Type;

import org.junit.Test;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import de.vik.testrail2java.testhelpers.JsonTestHelpers;
import de.vik.testrail2java.types.primitive.Timestamp;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static de.vik.testrail2java.testhelpers.JsonTestHelpers.jsonPrimitive;

public class TimestampAdapterTest {
    @Test
    public void deserialize() throws Exception {
        TimestampAdapter target = target();

        Timestamp result = target.deserialize(JsonTestHelpers.jsonPrimitive(123456789L), ignoredType(), ignoredContext());

        assertThat(result.getValue(), equalTo(123456789L));
    }

    @Test
    public void serialize() throws Exception {
        final Timestamp timestamp = new Timestamp(9693459L) {};
        final TimestampAdapter target = target();
        JsonSerializationContext context = mock(JsonSerializationContext.class);
        when(context.serialize(timestamp.getValue(), Long.TYPE)).thenReturn(JsonTestHelpers.jsonPrimitive(timestamp.getValue()));

        JsonElement actual = target.serialize(timestamp, ignoredType(), context);

        assertThat(actual.getAsString(), equalTo("9693459"));
    }

    private TimestampAdapter target() {
        return new TimestampAdapter();
    }

    private JsonDeserializationContext ignoredContext() {
        return null;
    }

    private Type ignoredType() {
        return null;
    }
}