package com.john.kot.tool

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityPlayStoreBinding

class PlayStoreActivity : AppCompatActivity() {
    val binding by lazy { ActivityPlayStoreBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent()
        binding.opengoogle.setOnClickListener {
            intent.action = "com.google.android.payments.standard.TOPUP_V1"
            intent.putExtra("gspTopUpRequest", resources.getString(R.string.secret_key))
            resultLauncher.launch(intent)
        }
    }


    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                Activity.RESULT_OK -> Toast.makeText(this, "succuss", Toast.LENGTH_SHORT).show()
                0 -> Toast.makeText(this, "user topup Abandon", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this, "topup Failed", Toast.LENGTH_SHORT).show()
            }
        }


//    @Deprecated("Deprecated in Java")
//    override fun onBackPressed() {
//        if ("e" == "e") {
//
//        }
//        super.onBackPressed()
//    }
}