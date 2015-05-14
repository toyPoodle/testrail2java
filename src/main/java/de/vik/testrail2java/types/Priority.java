package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class Priority {
    private PriorityId id;
    private boolean isDefault;
    private String name;
    private int priority;
    private String shortName;

    public Priority(PriorityId id, boolean isDefault, String name, int priority, String shortName) {
        this.id = id;
        this.isDefault = isDefault;
        this.name = name;
        this.priority = priority;
        this.shortName = shortName;
    }

    public PriorityId getId() {
        return id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", isDefault=" + isDefault +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", shortName='" + shortName + '\'' +
                '}';
    }

    public static class PriorityId extends NumericId {
        public PriorityId(int id) {
            super(id);
        }
    }
}
