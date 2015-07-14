package de.vik.testrail2java.types.primitive;

public class TimeSpan {
    private final String value;

    public TimeSpan(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    @SuppressWarnings("ControlFlowStatementWithoutBraces")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSpan timeSpan = (TimeSpan) o;

        return value.equals(timeSpan.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "value='" + value + '\'' +
                '}';
    }
}
