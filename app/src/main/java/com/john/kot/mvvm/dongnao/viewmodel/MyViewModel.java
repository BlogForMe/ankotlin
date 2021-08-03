package com.john.kot.mvvm.dongnao.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.android.util.base.ViewModel;

//public class MyViewModel  extends ViewModel {
//    public MyViewModel(Application application){
//        super();
//    }
//
//    public int number;
//
//}

public class MyViewModel extends AndroidViewModel {
    public MyViewModel(Application application) {
        super(application);
    }

    public int number;
}
