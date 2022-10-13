package com.john.kot.hilt;

import javax.inject.Inject;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.john.kot.R;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HiltActivity extends AppCompatActivity {

    String TAG = "HiltActivity";

    @Inject
    User1 user1; // 方式2

    //@Inject
    //User1 user2;

    //@Inject
    //ViewModel viewModel;
    //
    //@Inject
    //ViewModel1 viewModel1;
    //
    //@Inject
    //ViewModel3 viewModel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilt);
        //测试  ActivityComponent
        Log.i(TAG, "user1: " + user1);
        //Log.i(TAG, "user2: " + user2);
        //startActivity(new Intent(this, SecondActivity.class));

        //        viewModel.test();
        //        viewModel1.test();
        //        viewModel3.test();

        //MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //viewModel.test();
        //
        //Log.i(TAG, "onCreate:  "+ getScreenW(this) +" " + getScreenH(this));

    }
}