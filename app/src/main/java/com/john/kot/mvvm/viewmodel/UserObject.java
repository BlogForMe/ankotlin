package com.john.kot.mvvm.viewmodel;

public class UserObject {
    private String name;

    public UserObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
                '}' + "\n  ";
    }
}
