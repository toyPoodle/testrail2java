package de.vik.testrail2java.net;

import java.util.List;

import de.vik.testrail2java.TestRailException;

public interface APIClientInterface {
    /**
     * Request for a single element.
     * @param resultType Type of element. Java primitive types are not supported.
     * @param uri URI to be called.
     * @return Element requested.
     * @throws TestRailException for any IO errors or incorrect requests.
     */
    <T> T get(Class<T> resultType, MethodUri uri);

    /**
     * Request for a list of elements of same type.
     * @param resultType Type of element. Java primitive types are not supported.
     * @param uri URI to be called.
     * @return Elements requested or an empty list.
     * @throws TestRailException for any IO errors or incorrect requests.
     */
    <T> List<T> getList(Class<T> resultType, MethodUri uri);

    /**
     * Submits an element.
     * @param uri URI to be called.
     * @param data Element to submit
     * @param allowedFields Fields of the element which are relevant for submission.
     * @param resultType Type of returned element. Java primitive types are not supported.
     * @return Element of result type.
     */
    <T> T post(MethodUri uri, T data, String[] allowedFields, Class<T> resultType);

    /**
     * Submits a call to an URI without data.
     * @param uri URI to be called.
     * @param resultType Type of response element. Java primitive types are not supported.
     * @return Element of result type.
     */
    <T> T post(MethodUri uri, Class<T> resultType);

    /**
     * Submits a call to an URI without data.
     * @param uri URI to be called.
     */
    void post(MethodUri uri);
}
