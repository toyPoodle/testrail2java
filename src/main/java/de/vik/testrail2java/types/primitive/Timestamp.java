package de.vik.testrail2java.types.primitive;

public class Timestamp {
    private final long value;

    public Timestamp(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    @SuppressWarnings("ControlFlowStatementWithoutBraces")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timestamp timestamp = (Timestamp) o;

        return value == timestamp.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

    @Override
    public String toString() {
        return "Timestamp{" +
                "value=" + value +
                '}';
    }
}
