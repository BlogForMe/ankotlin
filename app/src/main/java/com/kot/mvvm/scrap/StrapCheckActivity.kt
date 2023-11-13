package com.kot.mvvm.scrap

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kot.R

/**
 * 手环
 */
class StrapCheckActivity : AppCompatActivity() {
    private val TAG = "StrapCheckActivity"

    private lateinit var mBodyDataModel: BodyDataModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ble_activity_temp)
        mBodyDataModel = ViewModelProvider(this).get(BodyDataModel::class.java)
        resultFragment()
//        iv_back.setOnClickListener {
        mBodyDataModel.activityTime.value =
            "333333333333222222222222222222222323233333332222222233232232222223333333"
//            Timber.i("mBodyDataModel.activityTime.value ${mBodyDataModel.spData.value}")

//        }
    }


    private fun resultFragment() {
        val ft = supportFragmentManager.beginTransaction()
        val bodyFragment = BodyDataFragment.newInstance()
        ft.add(R.id.fl_content, bodyFragment)
        ft.commit()
//        ft.commitAllowingStateLoss()
//        ft.commitNow()
//        ft.commitNowAllowingStateLoss()

        Log.i(TAG, "resultFragment: isAdded1  ${bodyFragment.isAdded}")
        Log.i(TAG, "resultFragment: isAdded2  ${bodyFragment.isAdded}")

        Handler().post {

        }
        runOnUiThread { }
//        if (bodyFragment.isAdded.not()) {
//            ft.add(R.id.fl_content, bodyFragment)
//        }
    }


//    fun obtainViewModel(): BodyDataModel = mBodyDataModel
}