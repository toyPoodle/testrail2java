package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class Project {
    public static class ProjectId extends NumericId {
        public ProjectId(int id) {
            super(id);
        }
    }
}
