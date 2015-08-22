package de.vik.testrail2java.types.custom;

import de.vik.testrail2java.types.Status.StatusId;

public class StepResult {
    private final String content;
    private final String expected;
    private final String actual;
    private final StatusId statusId;

    public StepResult(String content, String expected, String actual, StatusId statusId) {
        this.content = content;
        this.expected = expected;
        this.actual = actual;
        this.statusId = statusId;
    }

    public String getContent() {
        return content;
    }

    public String getExpected() {
        return expected;
    }

    public String getActual() {
        return actual;
    }

    public StatusId getStatusId() {
        return statusId;
    }

    @Override
    public String toString() {
        return "StepResult{" +
                "content='" + content + '\'' +
                ", expected='" + expected + '\'' +
                ", actual='" + actual + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}
