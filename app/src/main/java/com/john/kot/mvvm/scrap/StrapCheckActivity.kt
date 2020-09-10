package com.john.kot.mvvm.scrap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.john.kot.R
import kotlinx.android.synthetic.main.ble_activity_temp.*
import timber.log.Timber

/**
 * 手环
 */
class StrapCheckActivity :AppCompatActivity() {


    private lateinit var mBodyDataModel: BodyDataModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ble_activity_temp)
        mBodyDataModel = ViewModelProvider(this).get(BodyDataModel::class.java)
        resultFragment()
        iv_back.setOnClickListener {
            mBodyDataModel.activityTime.value  = "333333333333222222222222222222222323233333332222222233232232222223333333"
//            Timber.i("mBodyDataModel.activityTime.value ${mBodyDataModel.spData.value}")

        }
    }



    private fun resultFragment(){
        val ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.fl_content, StrapFragment.newInstance())
        ft.replace(R.id.fl_content, BodyDataFragment.newInstance())
        ft.commitAllowingStateLoss()
    }



//    fun obtainViewModel(): BodyDataModel = mBodyDataModel
}