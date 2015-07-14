package de.vik.testrail2java.net;


import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Filter <T>{
    private final String key;
    private final String value;

    protected Filter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    protected static String asString(Id value, Id[] furtherValues) {
        String valuesConcatenated = value.getValue();
        for (Id furtherValue : furtherValues) {
            valuesConcatenated += "," + furtherValue.getValue();
        }
        return valuesConcatenated;
    }

    protected static String asString(Timestamp value) {
        return String.valueOf(value.getValue());
    }

    public String asString() {
        return key + "=" + value;
    }

    @Override
    @SuppressWarnings({"ControlFlowStatementWithoutBraces", "SimplifiableIfStatement"})
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filter filter = (Filter) o;

        if (!key.equals(filter.key)) return false;
        return value.equals(filter.value);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
