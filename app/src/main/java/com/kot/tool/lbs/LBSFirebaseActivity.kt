package com.kot.tool.lbs

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.util.ToastUtil
import com.kot.R

class LBSFirebaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lbsfirebase)

        val ss: String? = null
        findViewById<Button>(R.id.testCatch).setOnClickListener {
//            try {
//                getLocation()
//            }catch (e:Exception){
//                e.printStackTrace()
//            }

//            val intent = Intent(this, ViewModel1Activity::class.java)
//            intent.putExtra(NAME_KEY, "17737373773")
//            startActivity(intent)

//            try {
//                Thread.sleep(30000)
//            }catch (e:Exception){
//                e.printStackTrace()
//            }
            if (ss == "null") {
                ToastUtil.showShort("i am null")
            }
        }


        findViewById<Button>(R.id.openstyle).setOnClickListener {
        }
    }

//
//    @Throws(java.lang.Exception::class)
//    protected fun getLocation(): String? {
//        val request = LBSLocationRequest()
////        LogUtils.d("getLbsInfo "+ Thread.currentThread().name)
//
//        return LBSLocationManagerProxy.getInstance().getLastKnownLocation(this, request)
//    }


}