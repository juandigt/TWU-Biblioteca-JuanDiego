package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {


    private static User user;

    @Before
    public void setUp() {

        user = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
    }

    @Test
    public void testIfUserGetsInitializedCorrectly() {
        assertEquals("password", user.getPassword());
        assertEquals("Juandi", user.getName());
        assertEquals("Garcia", user.getSurnames());
        assertEquals("email@email.com", user.getEmail());
        assertEquals(135415, user.getPhone());
    }

    @Test
    public void userCAnLogInWithTheCorrectNameAndPassword() {
        ArrayList<User> users = new ArrayList<User>();
        User user = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
        users.add(user);
        assertTrue(User.login("Juandi", "password",  user));
    }

    @Test
    public void userCAnNotLogInWithTheIncorrectNameAndPassword() {
        ArrayList<User> users = new ArrayList<User>();
        User user = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
        users.add(user);
        assertFalse(User.login("name", "password",  user));
    }

    @Test
    public void findUserReturnTheRightUserFromUserListWithUserNameAndPasswordGiven() {
        ArrayList<User> usersList = new ArrayList<User>();
        User currentUser = new User();
        User user = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
        usersList.add(user);

        User expected = currentUser.findUser("Juandi", "password",  usersList);

        assertEquals(expected, user);
    }

    @Test
    public void findUserReturnErrorWhenTheUserNameAndPasswordGivenAreNotInUserList() {
        ArrayList<User> usersList = new ArrayList<User>();
        User currentUser = new User();
        User user = new User("1", "password", "Juandi","Garcia", "email@email.com", 135415);
        usersList.add(user);

        User expected = currentUser.findUser("otherUser", "password",  usersList);

        assertTrue(User.isCurrentUserEmpty(expected));
    }

}
