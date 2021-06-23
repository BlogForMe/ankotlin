package com.android.util.circledialog.view;

import android.content.Context;
import android.text.method.LinkMovementMethod;

import com.android.util.circledialog.CircleParams;

/**
 * view的层次结构
 * <pre>
 * CardView
 *    ╚--LinearLayout
 *          ╚--TitleView
 *          ╚--BodyView
 *          ╚--ButtonView
 * </pre>
 * Created by hupei on 2018/8/14.
 */

public final class BuildViewConfirmImpl extends AbsBuildView {
    private BodyTextView mBodyTextView;

    public BuildViewConfirmImpl(Context context, CircleParams params) {
        super(context, params);
    }

    @Override
    public void buildBodyView() {
        buildRootView();
        buildTitleView();
        if (mBodyTextView == null) {
            mBodyTextView = new BodyTextView(mContext, mParams.dialogParams, mParams.textParams,
                    mParams.createTextListener);
            mBodyTextView.setMovementMethod(LinkMovementMethod.getInstance());
            addViewByBody(mBodyTextView);
        }
    }

    @Override
    public BodyTextView getBodyView() {
        return mBodyTextView;
    }

    @Override
    public void refreshContent() {
        if (mBodyTextView != null) {
            mBodyTextView.refreshText();
        }
    }
}
