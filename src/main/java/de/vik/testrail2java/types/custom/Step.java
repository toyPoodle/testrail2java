package de.vik.testrail2java.types.custom;

public class Step {
    private String expected;
    private String content;

    public Step(String expected, String content) {
        this.expected = expected;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Step{" +
                "expected='" + expected + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public String getExpected() {
        return expected;
    }
}
