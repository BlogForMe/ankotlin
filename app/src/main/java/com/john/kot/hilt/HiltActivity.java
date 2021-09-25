package com.john.kot.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.john.kot.R;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HiltActivity extends AppCompatActivity {

    String TAG ="HiltActivity";
    @Inject
    User user; //inject注解作用在User变量上,注入对象实例

    @Inject
    User1 user1; // 方式2

    @Inject
    User1 user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilt);
        Log.i(TAG, "user: " + user);

        //测试  ActivityComponent
        Log.i(TAG, "user1: " + user1);
        Log.i(TAG, "user2: " + user2);

        startActivity(new Intent(this,SecondActivity.class));
    }
}