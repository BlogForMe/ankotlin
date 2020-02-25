package com.android.util.base;


import android.os.Bundle;
import android.view.View;


public abstract class CMvpFragment<P extends CBasePresenter> extends CBaseFragment implements BaseView{
    protected P mPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onViewCreated(view, savedInstanceState);
        attachView();
    }

    protected abstract P createPresenter();


    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
