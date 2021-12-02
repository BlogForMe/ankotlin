package com.john.kot.viewGroup

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityViewGroupBinding

class ViewGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var textViewM = LayoutInflater.from(this).inflate(R.layout.item_textview, null)

        for (index in 0 until 5){

        }
    }


}