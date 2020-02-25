package com.comm.util.circledialog;

import android.view.View;

import com.comm.util.circledialog.view.listener.ButtonView;
import com.comm.util.circledialog.view.listener.CloseView;

/**
 * Created by hupei on 2017/3/29.
 */

public interface BuildView {

    void buildRootView();

    void buildTitleView();

    void buildBodyView();

    ButtonView buildButton();

    CloseView buildCloseImgView();

    View getRootView();

    <T> T getBodyView();

    void refreshTitle();

    void refreshContent();

    void refreshButton();


}
