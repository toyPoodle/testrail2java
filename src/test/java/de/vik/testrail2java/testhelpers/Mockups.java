package de.vik.testrail2java.testhelpers;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import de.vik.testrail2java.net.APIClient;

import static de.vik.testrail2java.testhelpers.MoreMatchers.uri;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Mockups {
    public static <T> APIClient apiClientGET(Class<T> resultEntryClazz, String uri, List<T> expectedResult) {
        APIClient client = mock(APIClient.class);
        when(client.getList(eq(resultEntryClazz), MoreMatchers.uri(uri))).thenReturn(expectedResult);
        return client;
    }

    public static <T> APIClient apiClientGET(Class<T> resultEntryClazz, String uri, T expectedResult) {
        APIClient client = mock(APIClient.class);
        when(client.get(eq(resultEntryClazz), MoreMatchers.uri(uri))).thenReturn(expectedResult);
        return client;
    }

    public static <D> void testSubmissionWithData(String uriString, Class<D> dataClass, String[] allowedFields, Consumer<D> testDataSetup, BiFunction<APIClient, D, D> targetCall) {
        D expected = mock(dataClass);
        APIClient apiClient = mock(APIClient.class);
        D data = mock(dataClass);
        testDataSetup.accept(data);
        when(apiClient.post(uri(uriString), eq(data), eq(allowedFields), eq(dataClass))).thenReturn(expected);
        assertThat(targetCall.apply(apiClient, data), sameInstance(expected));
        verify(apiClient, times(1)).post(uri(uriString), eq(data), eq(allowedFields), eq(dataClass));
    }

    public static <R> void testSubmissionWithoutData(String uriString, Class<R> resultClass, Function<APIClient, R> targetCall) {
        R expected = mock(resultClass);
        APIClient apiClient = mock(APIClient.class);
        when(apiClient.post(uri(uriString), eq(resultClass))).thenReturn(expected);
        assertThat(targetCall.apply(apiClient), sameInstance(expected));
        verify(apiClient, times(1)).post(uri(uriString), eq(resultClass));
    }

    public static <R> void testSubmissionWithoutResultAndData(String uriString, Consumer<APIClient> targetCall) {
        APIClient apiClient = mock(APIClient.class);
        targetCall.accept(apiClient);
        verify(apiClient, times(1)).post(uri(uriString));
    }
}
