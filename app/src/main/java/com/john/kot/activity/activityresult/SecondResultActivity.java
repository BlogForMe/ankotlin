package com.john.kot.activity.activityresult;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.john.kot.R;

//@Route(path = ACTIVITY_SECOND)
public class SecondResultActivity extends AppCompatActivity {

    public static String sData = "data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    //@Override
    protected void initView() {
        findViewById(R.id.bt_finsh).setOnClickListener(v -> {
            setResult(21, new Intent().putExtra(sData, "我要回调啦!!!"));
            finish();
        });

        //        findViewById(R.id.bt_islive).setOnClickListener(v -> {
        //            boolean isSendo = DisplayUtils.isMainActivityAlive(SecondActivity.this,
        //            "FirstResultActivity");
        //            boolean isSendo = isExsitActivity(this, FirstResultActivity.class);
        //
        //            boolean isSecond = isExsitActivity(this, SecondActivity.class);
        //
        //            boolean isTop = isTopActivity("SecondActivity");
        //            Timber.i("isSendo   " + isSendo + "    isSecond " + isSecond + " isTop " +
        //            isTop);
        //            Timber.i("getLocalClassName   " + this.getsim);
        //            startActivity(new Intent(this, ThirdActivity.class));
        //        });
    }

    //@Override
    //protected int setLayoutId() {
    //    return R.layout.activity_second;
    //}

    /**
     * 检测某Activity是否在当前Task的栈顶
     */
    //private boolean isTopActivity(String activityName) {
    //    ActivityManager manager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
    //    List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
    //    String cmpNameTemp = null;
    //    if (runningTaskInfos != null) {
    //        cmpNameTemp = runningTaskInfos.get(0).topActivity.getClassName();
    //        Timber.tag("SecondResultActivity").i("cmpNameTemp   " + cmpNameTemp);
    //    }
    //    if (cmpNameTemp == null) {
    //        return false;
    //    }
    //    return cmpNameTemp.equals(activityName);
    //}
}
