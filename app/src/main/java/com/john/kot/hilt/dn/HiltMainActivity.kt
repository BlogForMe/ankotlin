package com.john.kot.hilt.dn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityHiltMainBinding
import com.john.kot.hilt.dn.di.User
import com.john.kot.hilt.dn.di.User1
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltMainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    @Inject
    lateinit var user: User

    @Inject
    lateinit var user1: User1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityHiltMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        Log.i(TAG, "user: $user")
        Log.i(TAG, "user1: $user1")
    }
}