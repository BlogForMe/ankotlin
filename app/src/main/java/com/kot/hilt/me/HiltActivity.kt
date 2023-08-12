package com.kot.hilt.me

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kot.R
import com.kot.hilt.model.User1
import com.kot.hilt.model.User6
import com.kot.hilt.model.UserParam1
import com.kot.hilt.model.UserParam5
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {
    var TAG = "HiltActivity"

    @Inject
    lateinit var user1: User1 // 方式2

    @Inject
    lateinit var userParam: UserParam1

    @Inject
    lateinit var userParam5: UserParam5

    @Inject
    lateinit var user6: User6 // 方式2

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)
        //测试  ActivityComponent
//        Log.i(TAG, "user1: $user1")
        Log.i(TAG, "userParam: ${userParam.user1}")
        Log.i(TAG, "userParam5: ${userParam5.user5}")

        Log.i(TAG, "user6: $user6")

        //Log.i(TAG, "user2: " + user2);
        startActivity(Intent(this, HiltSecondActivity::class.java));

        //        viewModel.test();
        //        viewModel1.test();
        //        viewModel3.test();

        //MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //viewModel.test();
        //
        //Log.i(TAG, "onCreate:  "+ getScreenW(this) +" " + getScreenH(this));

    }
}