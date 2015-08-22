package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class User {

    private final String email;
    private final UserId id;
    private final boolean isActive;
    private final String name;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
    User(String email, UserId id, boolean isActive, String name) {
        this.email = email;
        this.id = id;
        this.isActive = isActive;
        this.name = name;
    }

    /**
     * The email address of the user as configured in TestRail
     */
    public String getEmail() {
        return email;
    }

    /**
     * The unique ID of the user
     */
    public UserId getId() {
        return id;
    }

    /**
     * True if the user is active and false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * The full name of the user
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", isActive=" + isActive +
                ", name='" + name + '\'' +
                '}';
    }

    public static class UserId extends NumericId {
        public UserId(int id) {
            super(id);
        }
    }
}
