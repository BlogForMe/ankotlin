package com.comm.util.ui.tab;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.comm.util.R;
import com.comm.util.base.BaseFragment;

/**
 * @author : John
 * @date : 2018/7/18
 */
public class HealthFragment extends BaseFragment {
    public static Fragment newInstance() {
        return new HealthFragment();
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_second;
    }
}
