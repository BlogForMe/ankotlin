package com.john.kot.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class UserModel extends ViewModel {

    private final MutableLiveData userLiveData = new MutableLiveData();
    private final LinkedList<User> userList = new LinkedList<>();

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
