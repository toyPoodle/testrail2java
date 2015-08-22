package de.vik.testrail2java.net;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
    }
}