package com.android.util.base;

import android.os.Bundle;

/**
 * @author : John
 * @date : 2018/8/1
 */
public abstract class CMvpActivity<P extends CBasePresenter> extends CBaseActivity implements  BaseView{
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attachView(this);
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
