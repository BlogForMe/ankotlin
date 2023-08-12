package com.kot.tool

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityPlayStoreBinding

class GoogleTopUpActivity : AppCompatActivity() {
    val binding by lazy { ActivityPlayStoreBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent()
        binding.opengoogle.setOnClickListener {
            intent.action = "com.google.android.payments.standard.TOPUP_V1"
            intent.putExtra("gspTopUpRequest", resources.getString(R.string.secret_key))
            resultLauncher.launch(intent)
        }

        binding.openPermission.setOnClickListener {
            if (checkSelfPermission("com.example.dangerousactivity.MY_DANG_PERM") != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf("com.example.dangerousactivity.MY_DANG_PERM"), 1)
            } else {
                val intent = Intent()
                intent.action = "com.example.dangerousactivity.MY_DANG_ACTION"
                startActivity(intent)
            }
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