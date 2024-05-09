package com.kot.hilt.dn

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kot.databinding.ActivityHiltMainBinding
import com.kot.hilt.dn.di.InterfaceUser
import com.kot.hilt.dn.di.MainViewModel
import com.kot.hilt.dn.di.User
import com.kot.hilt.dn.di.User1
import com.kot.hilt.dn.di.User2
import com.kot.hilt.me.model.BannerRepository
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
    lateinit var user3: InterfaceUser

//    @Inject
//    lateinit var user4: User2

//    @Inject
//    lateinit var viewModel: HiltViewModel3
//
//
//    @Inject
//    lateinit var viewModel1: HiltViewModel4
//
@Inject
lateinit var viewModel5: MainViewModel


//    private val mainViewModel by viewModels<MainViewModel>()


    @Inject
    lateinit var bannerImp: BannerRepository

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

//        mainViewModel.test()

        binding.btClick.setOnClickListener {
//            bannerImp.getBanner()
//            user3.test()
//            viewModel5.test()
            Log.i(TAG, "onCreate: ${user}")
        }


//        var ss: String? = null
//        when (ss) {
//
//        }
    }
}