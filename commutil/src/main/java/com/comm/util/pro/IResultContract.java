package com.comm.util.pro;

import android.util.ArrayMap;

import com.comm.util.base.BaseView;
import com.comm.util.bean.BaseCount;
import com.comm.util.bean.DoctorDetail;
import com.comm.util.bean.MeasureRxData;

import java.util.List;

public interface IResultContract {

    interface View extends BaseView {

        void showLoading();

        void hideLoading();

        void measureRxResult(MeasureRxData measureRxData);


        void replyResult(BaseCount baseCount);

        void doctorResult(BaseCount<List<DoctorDetail>> response);

        void illCommitResult(BaseCount response);

    }


    interface Presenter {
        void insertReply(ArrayMap<String, Object> map);
    }
}