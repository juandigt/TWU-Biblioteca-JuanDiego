package com.twu.biblioteca;

import java.util.ArrayList;

public class User {

    private String id;
    private String password;
    private String name;
    private String surnames;
    private String email;
    private int phone;

    public User() {

    }

    public User(String id, String password, String name, String surnames, String email, int phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public static boolean login(String username, String password, User user) {
        return  user.getName().equals(username) && user.getPassword().equals(password);
    }

    public static User findUser(String username, String password, ArrayList<User>  userList){
        User currentUser = new User();
        for (User user: userList )
            if ((user.getName().equals(username)) && (user.getPassword().equals(password))) {
                currentUser = user;
            }
        return currentUser;
    }

    public static boolean isCurrentUserEmpty(User currentUser){

        boolean userObjectIsEmpty = false;
        if (currentUser.id == null &&
            currentUser.password == null &&
            currentUser.name == null &&
            currentUser.surnames == null &&
            currentUser.email == null &&
            currentUser.phone == 0) {

            userObjectIsEmpty = true;
        }
        return userObjectIsEmpty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.id.equals(user.id) && this.password.equals(user.password);
    }

    @Override
    public String toString() {
        return String.format("| %8s | %-30s | %-23s | %9s |", id, (name + " " + surnames).length() > 30 ? (name + " " + surnames).substring(0, 27) + "..." : (name + " " + surnames), email, phone);
    }
}