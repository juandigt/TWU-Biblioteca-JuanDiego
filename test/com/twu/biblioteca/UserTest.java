package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
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

    }
