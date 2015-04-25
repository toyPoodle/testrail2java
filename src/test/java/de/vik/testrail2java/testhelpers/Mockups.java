package de.vik.testrail2java.testhelpers;

import java.util.List;

import de.vik.testrail2java.net.APIClient;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
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

}
