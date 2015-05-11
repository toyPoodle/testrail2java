package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class SuiteMode extends NumericId {
    public static final SuiteMode SINGLE_SUITE = new SuiteMode(1);
    public static final SuiteMode SINGLE_SUITE_WITH_BASELINES = new SuiteMode(2);
    public static final SuiteMode MULTIPLE_SUITES = new SuiteMode(3);

    private SuiteMode(int id) {
        super(id);
    }
}
