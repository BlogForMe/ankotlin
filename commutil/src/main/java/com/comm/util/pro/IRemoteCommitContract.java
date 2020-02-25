package com.comm.util.pro;

import com.comm.util.base.BaseView;
import com.comm.util.bean.CommitVideo;

public interface IRemoteCommitContract {

    interface View extends VideoSuccess {

        void commitResult(CommitVideo commitVideo);
    }

    interface VideoSuccess  extends BaseView {
        void commitVideoSuccess();
    }

    interface Presenter {

    }
}