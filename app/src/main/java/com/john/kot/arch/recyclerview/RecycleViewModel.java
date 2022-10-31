package com.john.kot.arch.recyclerview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecycleViewModel extends ViewModel {
    private static final int DATASET_COUNT = 4;
//    protected String[] mDataset;

    private MutableLiveData<String[]> recycleLiveData;

    public LiveData<String[]> getRequestData() {
        if (recycleLiveData==null){
            recycleLiveData = new MutableLiveData<>();
        }
        return  recycleLiveData;
    }

    public void requestRecycleData(){
        String[] data = initDataset();
        recycleLiveData.setValue(data);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private String[] initDataset() {
        String[] mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        }
        return mDataset;
    }


}
