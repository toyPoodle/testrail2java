package de.vik.testrail2java.net;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import de.vik.testrail2java.TestRailException;
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
        try {
            return key + "=" + URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            // by definition UTF-8 should be supported by every Java VM
            // http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
            // so just repackage the exception to make compiler happy
            throw new TestRailException(e);
        }
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
