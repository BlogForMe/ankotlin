package com.comm.util.base;

import com.comm.util.rx.RxManager;


public class CBasePresenter<V extends BaseView> implements Presenter<V> {
    public V mvpView;

    protected RxManager mRxManager = new RxManager();

    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        this.mvpView = null;
        mRxManager.unSubscribe();
    }

    @Override
    public void removeAllView() {

    }


}
