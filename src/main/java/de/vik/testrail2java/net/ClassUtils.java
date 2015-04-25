package de.vik.testrail2java.net;

import java.lang.reflect.Array;

public class ClassUtils {

    /**
     * @see Class#isAssignableFrom(Class)
     */
    public static boolean isAssignable(Class<?> from, Class<?> to) {
        return to.isAssignableFrom(from);
    }

    /**
     * Returns an array class for the given glass, i.e. Foo[].class for Foo.class.
     * DOESN'T WORK WITH PRIMITIVES
     */
    public static <T> Class<T[]> arrayTypeFor(Class<T> clazz) {
        return (Class<T[]>) Array.newInstance(clazz, 0).getClass();
    }
}
