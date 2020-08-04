package com.john.kot

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class BleRestartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ble_restart)

        getPreferences(Context.MODE_PRIVATE).edit{
            putFloat("aaa",10f)
        }
    }
}