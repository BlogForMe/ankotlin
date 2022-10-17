package com.john.kot.hilt.dn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityHiltMainBinding
import com.john.kot.hilt.dn.di.User
import javax.inject.Inject

class HiltMainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityHiltMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        Log.i(TAG, "user: $user")
    }
}