package com.john.kot.hilt.dn

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityHiltMainBinding
import com.john.kot.hilt.dn.di.MainViewModel
import com.john.kot.hilt.dn.di.User
import com.john.kot.hilt.dn.di.User1
import com.john.kot.hilt.dn.di.User2
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

//    @Inject
//    lateinit var viewModel: HiltViewModel3
//
//
//    @Inject
//    lateinit var viewModel1: HiltViewModel4
//
//    @Inject
//    lateinit var viewModel5: HiltViewModel5

    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHiltMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Log.i(TAG, "user: $user")
//        Log.i(TAG, "user1: $user1")
//        Log.i(TAG, "user3: $user3")
//        Log.i(TAG, "user4: $user4")
//        startActivity(Intent(this, HiltSecondActivity::class.java))

//        viewModel.test()
//        viewModel1.test()
//        viewModel5.test()

        mainViewModel.test()

//        var ss: String? = null
//        when (ss) {
//
//        }
    }
}