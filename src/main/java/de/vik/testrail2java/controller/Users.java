package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.User;
import de.vik.testrail2java.types.User.UserId;

/**
 * http://docs.gurock.com/testrail-api2/reference-users
 */
public class Users {

    private final APIClient client;

    public Users(APIClient client) {
        this.client = client;
    }

    /**
     * Returns an existing user.
     * @param id The ID of the user
     */
    public User getUser(UserId id) {
        return client.get(User.class, new MethodUri("get_user/:user_id").withParameters(id));
    }

    /**
     * Returns an existing user by his/her email address.
     * @param email The email address to get the user for
     */
    public User getUserByEmail(String email) {
        return client.get(User.class, new MethodUri("get_user_by_email&email=:email").withParameters(email));
    }

    /**
     * Returns a list of users.
     */
    public List<User> getUsers() {
        return client.getList(User.class, new MethodUri("get_users"));
    }
}
