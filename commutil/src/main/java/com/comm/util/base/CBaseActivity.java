package com.comm.util.base;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.android.arouter.launcher.ARouter;
import com.comm.util.DrawableUtil;
import com.comm.util.EventUtil;
import com.comm.util.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

import static android.text.TextUtils.isEmpty;
import static com.comm.util.pro.ARouterManager.BOX_MAIN;

/**
 * @author : John
 * @date : 2018/7/15
 */
public abstract class CBaseActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();

//    protected AppManager appManager = AppManager.getAppManager();

    public static final String PARAMS_01 = "PARAMS_01";
    public static final String PARAMS_02 = "PARAMS_02";
    public static final String PARAMS_03 = "PARAMS_03";
    public static final String PARAMS_04 = "PARAMS_04";

    private Unbinder unBinder;
    protected Toolbar mToolbar;
    private TextView mToolBarTitle;
    private ProgressDialog progressDialog;
    private TextView tvTitleHome;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        hideBar();
        super.onCreate(savedInstanceState);
//        showSystemFull();
        setContentView(setLayoutId());
        unBinder = ButterKnife.bind(this);
//        mToolbar = findViewById(R.id.toolbar);
//        if (mToolbar != null) {
//            setSupportActionBar(mToolbar);
//        }
//        mToolBarTitle = findViewById(R.id.tv_title_home);
//        if (mToolBarTitle != null) {
//            //设置默认标题不显示
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//        }
//        if (mToolbar != null && isShowBack()) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //是否显示返回
//        }
//        Log.d(TAG,"亮屏");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        showSystemFull();
//        hideSystemUI();
        Log.d(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideBar();

    }

//    private void hideSystemUI() {
//        // Enables regular immersive mode.
//        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
//        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//
//                        // Set the content to appear under the system bars so that the
//                        // content doesn't resize when the system bars hide and show.
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        // Hide the nav bar and status bar
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
//    }

    private void hideBar() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }






    /**
     * 导航栏是否显示后退按钮
     *
     * @return
     */
    protected boolean isShowBack() {
        return true;
    }

    protected void setToolBarTitle(final String goHomeTxt) {
        tvTitleHome = findViewById(R.id.tv_title_home);
        if (tvTitleHome != null && !isEmpty(goHomeTxt)) {
            tvTitleHome.setVisibility(View.VISIBLE);
            tvTitleHome.setText(goHomeTxt);
            if ("首页".equals(goHomeTxt)) {
                DrawableUtil.setDrawableLeft(tvTitleHome, getDrawable(R.mipmap.btn_title_bar));
                tvTitleHome.setOnClickListener(new EventUtil() {
                    @Override
                    protected void onEventClick(View v) {
                        ARouter.getInstance().build(BOX_MAIN).navigation();
                    }
                });
            } else if ("返回".equals(goHomeTxt)) {
                DrawableUtil.setDrawableLeft(tvTitleHome, getDrawable(R.drawable.ic_page_back));
                tvTitleHome.setOnClickListener(new EventUtil() {
                    @Override
                    protected void onEventClick(View v) {
                        finish();
                    }
                });
            }
        }
    }


    protected abstract int setLayoutId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void showLoading() {
        showProgressDialog();
    }

    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    protected ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMax(100);
        progressDialog.show();
        return progressDialog;
    }

    protected ProgressDialog showSpinnerDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMax(100);
        return progressDialog;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        appManager.remove(this);
        unBinder.unbind();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        if (newConfig.fontScale != 1) {//非默认值
//            getResources();
//        }
//        super.onConfigurationChanged(newConfig);
//    }



    /**
     * https://blog.csdn.net/JohanMan/article/details/79118534
     */
//    @Override
//    public Resources getResources() {
//        Resources res = super.getResources();
//        if (res.getConfiguration().fontScale != 1) {//非默认值
//            Configuration newConfig = new Configuration();
//            newConfig.setToDefaults();//设置默认
//            res.updateConfiguration(newConfig, res.getDisplayMetrics());
////            createConfigurationContext(newConfig);
//        }
//        return super.getResources();
//    }


}
