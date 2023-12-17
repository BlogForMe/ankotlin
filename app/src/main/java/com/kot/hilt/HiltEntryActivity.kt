package com.kot.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.hilt.ISharedPreference
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityHiltBinding
import dagger.hilt.android.EntryPointAccessors

class HiltEntryActivity : AppCompatActivity() {

    val binding by viewBinding(ActivityHiltBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btEntry.setOnClickListener {
            EntryPointAccessors.fromApplication(
                applicationContext, ISharedPreference::class.java
            ).saveCache()
        }

    }
}