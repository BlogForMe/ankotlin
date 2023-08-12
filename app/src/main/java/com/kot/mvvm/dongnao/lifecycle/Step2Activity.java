package com.kot.mvvm.dongnao.lifecycle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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