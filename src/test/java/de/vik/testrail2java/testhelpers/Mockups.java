package de.vik.testrail2java.testhelpers;

import de.vik.testrail2java.net.APIClient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static de.vik.testrail2java.testhelpers.MoreMatchers.uri;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.AdditionalMatchers.aryEq;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class Mockups {

    public static <R> void testGetList(Class<R> resultType, final String uriString, Function<APIClient, List<R>> targetCall) {
        List<R> expected = new ArrayList<>();
        APIClient client = mock(APIClient.class);

        when(client.getList(eq(resultType), uri(uriString))).thenReturn(expected);

        assertThat(targetCall.apply(client), sameInstance(expected));
    }

    public static <R> void testGetItem(Class<R> resultType, final String uriString, Function<APIClient, R> targetCall) {
        R expected = mock(resultType);
        APIClient client = mock(APIClient.class);

        when(client.get(eq(resultType), MoreMatchers.uri(uriString))).thenReturn(expected);

        assertThat(targetCall.apply(client), sameInstance(expected));
    }

    public static <D> void testSubmissionWithData(String uriString, Class<D> dataClass, String[] allowedFields, Consumer<D> testDataSetup, BiFunction<APIClient, D, D> targetCall) {
        D expected = mock(dataClass);
        APIClient apiClient = mock(APIClient.class);
        D data = mock(dataClass);

        testDataSetup.accept(data);
        when(apiClient.post(uri(uriString), eq(data), aryEq(allowedFields), eq(dataClass))).thenReturn(expected);

        final D actual = targetCall.apply(apiClient, data);
        verify(apiClient, times(1)).post(uri(uriString), eq(data), aryEq(allowedFields), eq(dataClass));
        assertThat(actual, sameInstance(expected));
    }

    public static <R> void testSubmissionWithoutData(String uriString, Class<R> resultClass, Function<APIClient, R> targetCall) {
        R expected = mock(resultClass);
        APIClient apiClient = mock(APIClient.class);

        when(apiClient.post(uri(uriString), eq(resultClass))).thenReturn(expected);

        final R actual = targetCall.apply(apiClient);
        verify(apiClient, times(1)).post(uri(uriString), eq(resultClass));
        assertThat(actual, sameInstance(expected));
    }

    public static void testSubmissionWithoutResultAndData(String uriString, Consumer<APIClient> targetCall) {
        APIClient apiClient = mock(APIClient.class);

        targetCall.accept(apiClient);

        verify(apiClient, times(1)).post(uri(uriString));
    }
}
