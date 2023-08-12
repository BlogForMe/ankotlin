package com.kot.tool

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.R
import com.kot.databinding.ActivityShareprefenceBinding

class SharedPreferencesActivity : AppCompatActivity() {
    private val TAG = "SharedPreferencesActivity"
    val binding by viewBinding(ActivityShareprefenceBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shareprefence)
        val spSource = getSharedPreferences("SpSourceCode", Context.MODE_PRIVATE);
        val edit = spSource.edit()
        binding.btSave.setOnClickListener {
//            DelegateSharedPreferencesUtils.User.name = "john"
//            SpBase.contentSomething = "显示"
            edit.putInt("KEY_SP1", 111).commit()
            edit.putInt("KEY_SP2", 222).commit()
        }

        binding.btGet.setOnClickListener {
//            Timber.i("bt_get    "+DelegateSharedPreferencesUtils.User.name)
//            Timber.i("bt_get    "+SpBase.contentSomething)
            val int = spSource.getInt("KEY_SP1", 0)
            Log.i(TAG, "onCreate: ")
        }


    }
}