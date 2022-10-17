package com.john.kot.hilt.dn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityHiltMainBinding
import com.john.kot.hilt.dn.di.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltMainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    @Inject
    lateinit var user: User

    @Inject
    lateinit var user1: User1

    @Inject
    lateinit var user3: User2

    @Inject
    lateinit var user4: User2

    @Inject
    lateinit var viewModel: HiltViewModel3


    @Inject
    lateinit var viewModel1: HiltViewModel4


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityHiltMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
//        Log.i(TAG, "user: $user")
//        Log.i(TAG, "user1: $user1")
//        Log.i(TAG, "user3: $user3")
//        Log.i(TAG, "user4: $user4")
//        startActivity(Intent(this, HiltSecondActivity::class.java))

        viewModel.test()
        viewModel1.test()
    }
}