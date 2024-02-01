package com.comm.util.openlib.rxretrofit;

import android.widget.Button;
import com.android.util.base.BaseFragment;

/**
 * Created by jon on 3/30/18.
 */

public class TestFragment extends BaseFragment {
    //@Override
    //protected void initView(View view) {
    //}
    //
    //@Override
    //protected int setLayoutId() {
    //    return R.layout.fragment_test;
    //}

    //(R.id.error_return)
    public void error_return(Button button) {
        RxOperator.testOnErrorReturn();
    }

    //(R.id.error_resume_next)
    public void error_resume_next(Button button) {
        RxOperator.testOnErrorResumeReturn();
    }

    //(R.id.test_retry)
    public void test_retry(Button button) {
        RxOperator.testRetry();
    }

    //(R.id.retry_when)
    public void retry_when(Button button) {
        RxOperator.testRetryWhen();
    }

}
