package com.john.kot.arch.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;
import java.util.List;

public class UserModel extends ViewModel {

    private final MutableLiveData userLiveData = new MutableLiveData();
    List<User> userList = new LinkedList<>();

    public LiveData getUser() {
        return userLiveData;
    }

    public UserModel() {
    }

    void doAction() {
        userList.add(new User("lili"));
        userLiveData.postValue(userList);
    }
}
