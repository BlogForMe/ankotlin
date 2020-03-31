package com.john.kot.permission;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.john.kot.R;

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        findViewById(R.id.button4).setOnClickListener(v -> {
            startUse();
        });

    }


    private void startUse() {

//    点击登录按钮时 ，获取申请权限的结果 并且这里动态申请了“悬浮窗”的权限
// 1. 如何小于6.0 直接登陆
// 2. 申请悬浮窗权限，如果没有，直接跳转到具体页面进行设置，完成后在onActivityResult 中判断是否允许该权限
//    如果允许再次动态申请一次权限，上面如果点击了全部禁止且勾选了禁止访问请调用 getRequestPermission()方法，
//    自动跳转到应用程序列表中让用户手动设置权限

        if (getSdkVersionSix()) {
            if (Settings.canDrawOverlays(this)) {
                if (getRequestPermission().equals("1")) { // 如果等于1则登录
//                    init_IntentLogIn(getAccount(), getPwd());
                    Toast.makeText(this, "开始使用", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "R.string.login_canDrawOverlays", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivityForResult(intent, 2);
            }
        } else {
//        init_IntentLogIn(getAccount(), getPwd()); // 6.0以下直接登录
            directUse();
        }
    }

    private void directUse() {
        Toast.makeText(this, "R.string.login_canDrawOverlays", Toast.LENGTH_SHORT).show();

    }


    //    用户是否禁止权限
    private boolean mShowRequestPermission = true;

    //    申请权限  -- 进入登录页面时申请权限
    private void init_permission() {
        if (getSdkVersionSix()) {
            String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECORD_AUDIO};
            List<String> mPermissionList = new ArrayList<>();
            for (int i = 0; i < permissions.length; i++) {
                if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                    mPermissionList.add(permissions[i]);
                }
            }

            if (mPermissionList.isEmpty()) {// 全部允许
                mShowRequestPermission = true;
            } else {//存在未允许的权限
                String[] permissionsArr = mPermissionList.toArray(new String[mPermissionList.size()]);
                ActivityCompat.requestPermissions(this, permissionsArr, 101);
            }
        }
    }

//    权限提示框 ，如果点击禁止且不勾选禁止访问，则无线循环弹出申请框，哈哈，就是这么任性。
//    如果全部允许则正常操作。如果全部禁止且禁止访问，点击登录按钮时再校验一遍，

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 101:
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        //判断是否勾选禁止后不再询问
                        boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i]);
                        if (showRequestPermission) {
                            init_permission();
                            return;
                        } else { // false 被禁止了，不在访问
                            mShowRequestPermission = false;//已经禁止了
                        }
                    }
                }
                break;
        }
    }


    //    判断SDK是否在6.0以上
    public boolean getSdkVersionSix() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    //    处理申请的悬浮窗和其他权限
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (Settings.canDrawOverlays(this)) {
                init_permission();
            } else {
                Toast.makeText(this, "R.string.login_canDrawOverlays", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 3) {
            init_permission();
        }
    }

    //    申请权限后的操作
    public String getRequestPermission() {
        if (mShowRequestPermission) {
            return "1";
        } else {// 被禁止后提示用户必须到设置中授权，跳转到应用程序列表页面
            Toast.makeText(this, "请到应用列表授予权限", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            startActivityForResult(intent, 3);
            return "-1";
        }
    }
}
