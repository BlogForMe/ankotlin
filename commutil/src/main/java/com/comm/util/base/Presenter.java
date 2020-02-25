package com.comm.util.base;

import android.widget.Chronometer;
import android.widget.RelativeLayout;

public interface Presenter<T extends BaseView> {
    void attachView(T view);

    void detachView();

    void removeAllView();

}
