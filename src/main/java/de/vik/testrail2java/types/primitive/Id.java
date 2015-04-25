package de.vik.testrail2java.types.primitive;

public abstract class Id implements AsString {

    private final String id;

    protected Id(String id) {
        this.id = id;
    }

    protected Id(int id) {
        this.id = String.valueOf(id);
    }

    public String getValue() {
        return id;
    }

    @Override
    public String asString() {
        return getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id id1 = (Id) o;

        return id.equals(id1.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Id{" +
                "id='" + id + '\'' +
                '}';
    }
}
