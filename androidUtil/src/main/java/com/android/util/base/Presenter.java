package com.android.util.base;

public interface Presenter<T extends BaseView> {
    void attachView(T view);

    void detachView();

    void removeAllView();

}
