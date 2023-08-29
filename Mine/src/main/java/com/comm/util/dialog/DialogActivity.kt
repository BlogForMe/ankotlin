package com.comm.util.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.android.util.circledialog.CircleDialog
import com.comm.util.R
import com.comm.util.bean.PictureTypeEntity
import com.comm.util.dialog.dw.BottomDialog
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DialogActivity : AppCompatActivity() {

    private val TAG = "DialogActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        findViewById<View>(R.id.bt_dialog).setOnClickListener { v: View? ->
            val invest = InvestPwdDialog()
            invest.show(supportFragmentManager, "InvestPwdDialog")
            val findFragmentByTag = supportFragmentManager.findFragmentByTag("InvestPwdDialog")
            Log.i(TAG, "onCreate: invest $invest  findFragmentByTag $findFragmentByTag ")
        }


        findViewById<View>(R.id.btConfirm).setOnClickListener { m: View? ->
            CircleDialog.Builder() //                        .setTitle("标题")
                .setWidth(0.3f)
                .setText(
                    """移动认证简介\n" +
 "\n" +
 "1、什么是移动认证\n""""
                )
                .setPositive(
                    "确定"
                ) { v: View? ->
                    Toast.makeText(this@DialogActivity, "取消", Toast.LENGTH_SHORT).show()
                }
                .setNegative("取消") { v: View? ->
                    Toast.makeText(
                        this@DialogActivity,
                        "取消",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .show(supportFragmentManager)
        }
        findViewById<View>(R.id.btRecycleView).setOnClickListener { v: View? ->
            val listData = ArrayList<PictureTypeEntity>()
            for (i in 0..3) {
                listData.add(PictureTypeEntity(i, "周$i"))
            }
        }

    }

    private fun initListener() {

        //        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id
        //        .ll_bottom_sheet));
        //        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior
        //        .BottomSheetCallback() {
        //            @Override
        //            public void onStateChanged(@NonNull View bottomSheet, int newState) {
        //
        //            }
        //
        //            @Override
        //            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        //
        //            }
        //        });
    }

    //底部弹出Dialog
    fun btBottomDialog(v: View?) {
        BottomDialog.newInstance().show(supportFragmentManager, BottomDialog.TAG)
        //        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    class InvestPwdDialog : DialogFragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
        ): View? {
            return inflater.inflate(R.layout.dialog_alert, container)
        }
    }
}