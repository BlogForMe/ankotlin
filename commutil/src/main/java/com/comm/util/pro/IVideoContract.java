package com.comm.util.pro;

import com.comm.util.base.BaseView;
import com.comm.util.bean.BaseCount;

public interface IVideoContract {

    interface View extends BaseView {

        void successHandOff();
        void showWaterId(int videoRecordId);
        void resultSuccess(BaseCount response);
    }


    interface Presenter {

    }
}