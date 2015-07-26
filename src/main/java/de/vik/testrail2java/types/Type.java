package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class Type {
    private TypeId id;
    private boolean isDefault;
    private String name;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
    Type(TypeId id, boolean isDefault, String name) {
        this.id = id;
        this.isDefault = isDefault;
        this.name = name;
    }

    public TypeId getId() {
        return id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getName() {
        return name;
    }

    public static class TypeId extends NumericId {
        public TypeId(int id) {
            super(id);
        }
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", isDefault=" + isDefault +
                ", name='" + name + '\'' +
                '}';
    }
}
