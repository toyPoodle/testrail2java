package de.vik.testrail2java.testhelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.serialization.AllowedFields;

import static de.vik.testrail2java.testhelpers.MoreMatchers.uri;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Mockups {

    public static <R> void testGetList(Class<R> resultType, final String uriString, Function<APIClient, List<R>> targetCall) {
        List<R> expected = new ArrayList<>();
        expected.add(mock(resultType, "pseudo result list item"));
        APIClient client = mock(APIClient.class);
        when(client.getList(eq(resultType), uri(uriString))).thenReturn(expected);

        final List<R> actual = targetCall.apply(client);

        //Technically not needed, but helps when there is a parameter mismatch
        verify(client).getList(eq(resultType), uri(uriString));
        assertThat(actual, equalTo(expected));
    }

    public static <R> void testGetItem(Class<R> resultType, final String uriString, Function<APIClient, R> targetCall) {
        R expected = mock(resultType);
        APIClient client = mock(APIClient.class);
        when(client.get(eq(resultType), uri(uriString))).thenReturn(expected);

        final R actual = targetCall.apply(client);

        //Technically not needed, but helps when there is a parameter mismatch
        verify(client).get(eq(resultType), uri(uriString));
        assertThat(actual, equalTo(expected));
    }

    public static <D> void testSubmissionWithData(String uriString, Class<D> dataClass, AllowedFields allowedFields, Consumer<D> testDataSetup, BiFunction<APIClient, D, D> targetCall) {
        D expected = mock(dataClass);
        APIClient apiClient = mock(APIClient.class);
        D data = mock(dataClass);

        testDataSetup.accept(data);
        when(apiClient.post(uri(uriString), eq(data), eq(allowedFields), eq(dataClass))).thenReturn(expected);

        final D actual = targetCall.apply(apiClient, data);

        //Request should be submitted only once
        verify(apiClient, times(1)).post(uri(uriString), eq(data), eq(allowedFields), eq(dataClass));
        assertThat(actual, equalTo(expected));
    }

    public static <R> void testSubmissionWithoutData(String uriString, Class<R> resultClass, Function<APIClient, R> targetCall) {
        R expected = mock(resultClass);
        APIClient apiClient = mock(APIClient.class);
        when(apiClient.post(uri(uriString), eq(resultClass))).thenReturn(expected);

        final R actual = targetCall.apply(apiClient);

        //Request should be submitted only once
        verify(apiClient, times(1)).post(uri(uriString), eq(resultClass));
        assertThat(actual, equalTo(expected));
    }

    public static void testSubmissionWithoutResultAndData(String uriString, Consumer<APIClient> targetCall) {
        APIClient apiClient = mock(APIClient.class);

        targetCall.accept(apiClient);

        //Request should be submitted only once
        verify(apiClient, times(1)).post(uri(uriString));
    }
}
