package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class User {

    public static class UserId extends NumericId {
        public UserId(int id) {
            super(id);
        }
    }
}
