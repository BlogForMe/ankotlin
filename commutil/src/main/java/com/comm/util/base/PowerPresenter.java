package com.comm.util.base;

import java.util.ArrayList;
import java.util.List;

public class PowerPresenter<T extends BaseView> extends CBasePresenter<T> {
    private T mvpView;
    private List<Presenter> presenters = new ArrayList<>();

    public final <Q extends Presenter<T>> void requestPresenter(Q... cls) {
        for (Q c1 : cls) {
            c1.attachView(mvpView);
            presenters.add(c1);
        }
    }

    public PowerPresenter(T mvpView) {
        this.mvpView = mvpView;
    }


    @Override
    public void removeAllView() {
        for (Presenter presenter : presenters) {
            presenter.detachView();
        }
    }
}
