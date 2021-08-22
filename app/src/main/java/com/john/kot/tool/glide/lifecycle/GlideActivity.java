package com.john.kot.tool.glide.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.john.kot.R;

public class GlideActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

//        MyLifecycleFragment fragment = new MyLifecycleFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction();


    }

    @Override
    protected void onResume() {
        super.onResume();
        textView = findViewById(R.id.tv_thread);
        new Handler().post(() -> {
            Log.i("GlideActivity", "onResume: " + textView.getWidth());
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

//
//        new Thread(()->{
//            viewById.setText("刷新完成");
//        }).start();
    }
}