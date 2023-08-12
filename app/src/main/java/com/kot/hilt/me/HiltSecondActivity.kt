package com.kot.hilt.me

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.hilt.model.User1
import com.john.kot.hilt.model.User6
import com.john.kot.hilt.model.UserParam1
import com.john.kot.hilt.model.UserParam5
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltSecondActivity : AppCompatActivity() {
    var TAG = "HiltSecondActivity"

    @Inject
    lateinit var user3: User1

    @Inject
    lateinit var userParam5: UserParam5


    @Inject
    lateinit var user6: User6 // 方式2

    @Inject
    lateinit var userParam: UserParam1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i(TAG, "userParam: ${userParam.user1}")
        Log.i(TAG, "userParam5: ${userParam5.user5}")

        Log.i(TAG, "user6: $user6")
    }
}