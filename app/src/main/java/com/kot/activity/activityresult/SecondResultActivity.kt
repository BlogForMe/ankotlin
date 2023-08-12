package com.kot.activity.activityresult

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kot.R
import com.kot.mvvm.demo.UserDemo

//@Route(path = ACTIVITY_SECOND)
class SecondResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
    }

    //@Override
    protected fun initView() {
        val list = java.util.ArrayList(listOf(UserDemo("name", 22, "adreww").apply {
            this.from = "cananda"
        }))
        findViewById<View>(R.id.bt_finsh).setOnClickListener { v: View? ->
            setResult(21, Intent().putExtra(sData, list))
            finish()
        }

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
    } //@Override
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
    companion object {
        var sData = "data"
    }
}