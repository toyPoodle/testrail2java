package de.vik.testrail2java.types;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class SuiteModeTest {
    @Test
    public void mappingToValues() throws Exception {
        assertThat(SuiteMode.SINGLE_SUITE.asInt(), equalTo(1));
        assertThat(SuiteMode.SINGLE_SUITE_WITH_BASELINES.asInt(), equalTo(2));
        assertThat(SuiteMode.MULTIPLE_SUITES.asInt(), equalTo(3));
    }
}