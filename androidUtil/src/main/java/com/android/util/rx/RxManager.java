package com.android.util.rx;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxManager {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public  void register(Disposable d){
        mCompositeDisposable.add(d);
    }

    public  void unSubscribe(){
        mCompositeDisposable.dispose();
    }
}
