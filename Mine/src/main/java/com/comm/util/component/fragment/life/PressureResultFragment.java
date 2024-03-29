package com.comm.util.component.fragment.life;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.android.util.DisplayUtils;
import com.android.util.base.BaseFragment;
import timber.log.Timber;

import static com.android.util.base.CBaseFragment.PARAMS_01;
import static com.android.util.base.CBaseFragment.PARAMS_02;
import static com.android.util.base.CBaseFragment.PARAMS_03;
import static com.android.util.circledialog.Controller.dp2px;

/**
 * @author : John
 * @date : 2018/9/30
 */
public class PressureResultFragment extends BaseFragment {

    //(R.id.tv_systolic)
    TextView tvSystolic;
    //(R.id.tv_diastolic)
    TextView tvDiastolic;
    //(R.id.tv_mean_ap)
    TextView tvMeanap;

    //(R.id.tv_systolic_line)
    TextView tvSystolicLine;
    //(R.id.tv_diastolic_line)
    TextView tvDiastolicLine;
    //(R.id.tv_mean_ap_line)
    TextView tvMeanapLine;

    //(R.id.tv_current_time)
    TextView tvCurrentTime;

    //(R.id.iv_press_line_1)
    ImageView ivPressLine1;
    //(R.id.iv_press_line_2)
    ImageView ivPressLine2;
    //(R.id.iv_press_line_3)
    ImageView ivPressLine3;
    private float highInt;
    private float lowInt, pulseInt;

    public static PressureResultFragment newInstance(float systolic, float diastolic,
                                                     float meanArterialPressure) {
        Bundle bundle = new Bundle();
        bundle.putFloat(PARAMS_01, systolic);
        bundle.putFloat(PARAMS_02, diastolic);
        bundle.putFloat(PARAMS_03, meanArterialPressure);
        PressureResultFragment pressureResultFragment = new PressureResultFragment();
        pressureResultFragment.setArguments(bundle);
        return pressureResultFragment;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arg = getArguments();
        highInt = arg.getFloat(PARAMS_01);
        tvSystolic.setText(String.valueOf(highInt));
        lowInt = arg.getFloat(PARAMS_02);
        tvDiastolic.setText(String.valueOf(lowInt));
        pulseInt = arg.getFloat(PARAMS_03);
        tvMeanap.setText(String.valueOf(pulseInt));
        tvSystolicLine.setText(String.valueOf(arg.getFloat(PARAMS_01)));
        tvDiastolicLine.setText(String.valueOf(arg.getFloat(PARAMS_02)));
        tvMeanapLine.setText(String.valueOf(arg.getFloat(PARAMS_03)));

        //        ll = new LinearLayout.LayoutParams(getActivity());
        //
        //        tvSystolicLine
        ////        tvSystolicLine.scrollBy(500, 0);
        //
        //        ObjectAnimator.ofFloat(tvSystolicLine, "translationX", 0, 1000).setDuration
        //        (1000).start();

        //        int width = dp2px(getActivity(), (DisplayUtils.getScreenW(getActivity()) - 62));
        //        float dwight = (highInt * width / 190);
        //        Timber.i("setTranslate  " + dwight);
        //        int left = tvSystolicLine.getLeft();
        //        tvSystolicLine.layout(left + (int) dwight, tvSystolicLine.getTop(), (int)
        //        (tvSystolicLine.getRight()+dwight), tvSystolicLine.getBottom());
        //        tvSystolicLine.invalidate();

    }

    @Override
    public void onResume() {
        super.onResume();
        setTranslate(tvSystolicLine, highInt);
        setTranslate(tvDiastolicLine, lowInt);
        setTranslate(tvMeanapLine, pulseInt);
    }

    private void setTranslate(TextView tv, float trueFl) {

        float dwww = DisplayUtils.getScreenW(getContext());
        Timber.i("dwww  " + dwww);
        int jjj = dp2px(getActivity(), 90);
        Timber.i("jjj  " + jjj);
        //        int width = dp2px(getActivity(), (dwww - jjj));
        float dwight = (trueFl * (dwww - jjj) / 190);
        Timber.i("setTranslate  " + dwight);
        //        int left = tv.getLeft();
        //        tv.layout(left + (int) dwight, tv.getTop(), (int) (tv.getRight() + dwight), tv.getBottom());
        //        tv.invalidate();
        ObjectAnimator.ofFloat(tv, "translationX", 0, dwight - dp2px(getActivity(), 40))
            .setDuration(1000).start();
    }
}
