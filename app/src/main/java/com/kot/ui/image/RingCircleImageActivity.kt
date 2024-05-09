package com.kot.ui.image

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.android.util.viewbind.viewBinding
import com.kot.R
import com.kot.databinding.ActivityRingCircleImageBinding
import kotlinx.coroutines.launch

class RingCircleImageActivity : AppCompatActivity() {
    val TAG = "RingCircleImageActivity"
    val binding by viewBinding(ActivityRingCircleImageBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_ring_circle_image)

//        if (Lifecycle.State.INITIALIZED.isAtLeast(Lifecycle.State.RESUMED)){
//
//        }
//        Log.i(
//            TAG,
//            "INITIALIZED:  ${Lifecycle.State.INITIALIZED.isAtLeast(Lifecycle.State.INITIALIZED)}"
//        )
//        Log.i(TAG, "RESUMED:  ${Lifecycle.State.RESUMED.isAtLeast(Lifecycle.State.RESUMED)}")
//        Log.i(TAG, "STARTED:  ${Lifecycle.State.STARTED.isAtLeast(Lifecycle.State.STARTED)}")
//        Log.i(TAG, "RESUMED:  ${Lifecycle.State.RESUMED.isAtLeast(Lifecycle.State.RESUMED)}")


//        Log.i(TAG, "onCreate: ")
        binding.ringCircleImage.setRingColor(resources.getColor(R.color.bgGreenColor))


        binding.ringCircleImage.setOnClickListener {
            lifecycleScope.launchWhenResumed {
                Log.i(TAG, "onResume:launchWhenResumed ")
            }
            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                    Log.i(TAG, "onResume:  repeatOnLifecycle")
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()

    }
}