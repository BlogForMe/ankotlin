package com.john.kot.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import com.john.kot.databinding.ActivityFragmentBinding
import com.john.kot.util.viewBinding

class FragmentTestActivity : AppCompatActivity() {
    //    val binding by viewBinding(ActivityFragmentBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportFragmentManager.beginTransaction().add(R.id.fl_content, SettingsFragment()).commit()
    }
}