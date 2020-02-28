package com.john.kot.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import kotlinx.android.synthetic.main.test_content_main.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_content_main)

        button.setOnClickListener{
//            message.text = "Welcome,Jake Smith"
            message.text = "Welcome,${firstName.text} ${lastName.text}"
        }

    }
}
