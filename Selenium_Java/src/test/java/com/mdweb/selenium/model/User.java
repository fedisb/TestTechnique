package com.mdweb.selenium.model;

public class User {
    private String UserEmail;
    private String password;

    public User generateDefaultUser1() {
        User user = new User();
        user.setUserEmail("test1@test.com");
        user.setPassword("test");
        return user;
    }
    public User generateDefaultUser() {
        User user = new User();
        user.setUserEmail("test@test.com");
        user.setPassword("test");
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }
}