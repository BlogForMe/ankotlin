package com.kot.activity.activityresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R

class FirstResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_result)
        initFragment()
    }


    //    val requestCode = 1000
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
////        Timber.d(
////            "onActivityResult resultCode $requestCode resultCode $resultCode  data  ${
////                data?.getStringExtra(
////                    SecondResultActivity.sData
////                )
////            }"
////        )
//    }
//
    private fun initFragment() {
        val ftn =
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_content, ResultOkFragment.newInstance())
        ftn.commit()
    }
}