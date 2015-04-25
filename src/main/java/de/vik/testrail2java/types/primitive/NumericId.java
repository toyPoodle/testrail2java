package de.vik.testrail2java.types.primitive;

public abstract class NumericId extends Id {

    private final int id;

    protected NumericId(int id) {
        super(id);
        this.id = id;
    }

    public int asInt() {
        return id;
    }
}
