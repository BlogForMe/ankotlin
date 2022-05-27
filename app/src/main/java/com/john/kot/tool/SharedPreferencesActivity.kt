package com.john.kot.tool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import com.john.kot.util.DelegateSharedPreferencesUtils
import com.john.kot.util.SpBase
import kotlinx.android.synthetic.main.activity_shareprefence.*
import timber.log.Timber

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shareprefence)
        bt_save.setOnClickListener {
            DelegateSharedPreferencesUtils.User.name = "john"

            SpBase.contentSomething = "显示"
        }

        bt_get.setOnClickListener {
//            Timber.i("bt_get    "+DelegateSharedPreferencesUtils.User.name)
            Timber.i("bt_get    "+SpBase.contentSomething)
        }
    }
}