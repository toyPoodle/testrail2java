package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.User;

import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.types.primitive.Primitives.userId;

public class UsersTest {

    @Test
    public void testGetUser() throws Exception {
        testGetItem(User.class, "get_user/1",
                apiClient -> new Users(apiClient).getUser(userId(1)));
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        testGetItem(User.class, "get_user_by_email&email=foo%40bar.com",
                apiClient -> new Users(apiClient).getUserByEmail("foo@bar.com"));
    }

    @Test
    public void testGetUsers() throws Exception {
        testGetList(User.class, "get_users",
                apiClient -> new Users(apiClient).getUsers());
    }
}