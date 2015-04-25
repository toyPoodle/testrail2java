package de.vik.testrail2java.net;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class ClassUtilsTest {

    private static class A {

    }

    private static class DerivedFromA extends A {

    }

    private static class B {

    }

    @Test
    public void assignmentOfDifferentClasses() throws Exception {
        assertThat(ClassUtils.isAssignable(A.class, B.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(B.class, A.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(A.class, A.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(A.class, DerivedFromA.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(DerivedFromA.class, A.class), equalTo(true));

/*
        assertThat(ClassUtils.isAssignable(boolean.class, Boolean.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(byte.class, Byte.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(char.class, Character.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(double.class, Double.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(float.class, Float.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(int.class, Integer.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(long.class, Long.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(short.class, Short.class), equalTo(true));
        assertThat(ClassUtils.isAssignable(void.class, Void.class), equalTo(true));

        assertThat(ClassUtils.isAssignable(Boolean.class, boolean.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Byte.class, byte.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Character.class, char.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Double.class, double.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Float.class, float.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Integer.class, int.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Long.class, long.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Short.class, short.class), equalTo(false));
        assertThat(ClassUtils.isAssignable(Void.class, void.class), equalTo(false));
        */
    }
}