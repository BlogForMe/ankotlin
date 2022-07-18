package com.john.kot.tool.lbs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.mvvm.dongnao.viewmodel.MyViewModel.Companion.NAME_KEY
import com.john.kot.mvvm.dongnao.viewmodel.ViewModel1Activity
import com.john.kot.util.lbs.LBSLocationManagerProxy
import com.john.kot.util.lbs.LBSLocationRequest
import java.lang.Exception

class LBSFirebaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lbsfirebase)

        findViewById<Button>(R.id.testCatch).setOnClickListener {
//            try {
//                getLocation()
//            }catch (e:Exception){
//                e.printStackTrace()
//            }

            val intent = Intent(this, ViewModel1Activity::class.java)
            intent.putExtra(NAME_KEY, "17737373773")
            startActivity(intent)
        }
    }

    @Throws(java.lang.Exception::class)
    protected fun getLocation(): String? {
        val request = LBSLocationRequest()
//        LogUtils.d("getLbsInfo "+ Thread.currentThread().name)

        return LBSLocationManagerProxy.getInstance().getLastKnownLocation(this, request)
    }

}