package com.john.kot.mvvm.dongnao.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.john.kot.R;

public class Step2Activity extends AppCompatActivity {

    private MyChronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        chronometer = (MyChronometer)findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }
}