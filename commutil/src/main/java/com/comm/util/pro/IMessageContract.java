package com.comm.util.pro;

import com.comm.util.base.BaseView;
import com.comm.util.bean.BaseCount;
import com.comm.util.bean.MsgShow;

import java.util.List;

public interface IMessageContract {

    interface View  extends BaseView {


        void showMsg(BaseCount<List<MsgShow>> response);
    }


    interface Presenter {

    }
}