package com.john.kot.arch.recyclerview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class RecycleViewModel extends ViewModel {

    private MutableLiveData<String[]> recycleLiveData;

    public LiveData<String[]> getRequestData() {
        if (recycleLiveData==null){
            recycleLiveData = new MutableLiveData<>();
        }
        return  recycleLiveData;
    }

    public void requestRecycleData(){
//        recycleLiveData.setValue();
    }


}
