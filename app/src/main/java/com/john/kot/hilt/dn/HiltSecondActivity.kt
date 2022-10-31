package com.john.kot.hilt.dn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityHiltSecondBinding
import com.john.kot.hilt.dn.di.User2
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HiltSecondActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    @Inject
    lateinit var user5: User2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityHiltSecondBinding.inflate(layoutInflater)
        setContentView(biding.root)
        Log.i(TAG, "user5: $user5")
    }
}