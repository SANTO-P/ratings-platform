package com.example.demo.vo;

public class UserInformation {

    private String userName;

    @SuppressWarnings("unused")
    public UserInformation() {
    }

    public UserInformation(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
