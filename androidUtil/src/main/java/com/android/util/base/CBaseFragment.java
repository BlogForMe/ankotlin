package com.android.util.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author : John
 * @date : 2018/7/15
 */
public abstract class CBaseFragment extends Fragment {
    protected  String TAG = getClass().getSimpleName();

    public static final String PARAMS_01 = "PARAMS_01";
    public static final String PARAMS_02 = "PARAMS_02";
    public static final String PARAMS_03 = "PARAMS_03";
    public static final String PARAMS_04 = "PARAMS_04";

    protected View rootView;
//    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            int view = setLayoutId();
            if (view != 0) {
                rootView = inflater.inflate(view, container, false);
            }
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }

//        unbinder = ButterKnife.bind(this, rootView);

        initView(rootView);
        return rootView;
    }

    protected void setFtBarTitle(String ftTxt) {
        if (rootView==null){
            return;
        }
//        TextView tvFtTitle = rootView.findViewById(R.id.tv_ft_title);
//        TextView tvFtBack = rootView.findViewById(R.id.tv_ft_back);
//        if (tvFtBack != null && isShowBack()) {
//            tvFtBack.setVisibility(View.VISIBLE);
//            tvFtBack.setOnClickListener(new EventUtil() {
//                @Override
//                protected void onEventClick(View v) {
//                    getActivity().onBackPressed();
//                }
//            });
//        }
//        if (tvFtTitle != null) {
//            tvFtTitle.setText(ftTxt);
//        }
    }

    protected boolean isShowBack() {
        return false;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Timber.tag(TAG).i("onViewCreated()");

        isPrepared = true;
        lazyLoad();
    }


    protected void initView(View view) {

    }


    protected abstract int setLayoutId();


    //  http://www.10tiao.com/html/565/201702/2247483988/1.html
    private boolean isPrepared;  //判断view是否加载完成,在视图未初始化的时候，在lazyLoad当中就使用的话，就会有空指针的异常
    protected boolean isVisible;  //判断当前Fragment是否可见状态,标志已经初始化完成，因为setUserVisibleHint是在onCreateView之前调用的

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.d(TAG + "         Test", " setUserVisibleHint() is Visible : ?  " + isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onInvisible() {
    }

    protected void onVisible() {
        lazyLoad();
    }

    private void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        requestData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        //Timber.tag(TAG).i("onHiddenChanged   " + hidden);
    }

    /**
     * 请求数据
     */
    protected void requestData() {
        //Timber.tag(TAG).i(" requestData ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Timber.tag(TAG).d("onCreate()");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (unbinder != null) {
//            unbinder.unbind();
//        }
        //Timber.tag(TAG).i("onDestroy()");
    }


    @Override
    public void onPause() {
        super.onPause();
        //Timber.tag(TAG).d("onPause() ");
    }

    @Override
    public void onStop() {
        super.onStop();
        //Timber.tag(TAG).d("onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
        //Timber.tag(TAG).i("onDestroyView()");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        //Timber.tag(TAG).i("onDetach()");
    }


}