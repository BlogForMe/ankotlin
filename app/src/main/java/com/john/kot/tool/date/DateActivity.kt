package com.john.kot.tool.date

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.CustomListener
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.bigkoo.pickerview.view.TimePickerView
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_date.*
import java.text.SimpleDateFormat
import java.util.*


class DateActivity : AppCompatActivity() {

    private var pvCustomLunar: TimePickerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        initLunarPicker()
        bt_date.setOnClickListener {
            pvCustomLunar?.show()
        }
    }

    fun showPicker(){
    }

    private fun initLunarPicker() {
        val selectedDate = Calendar.getInstance() //系统当前时间
        val startDate = Calendar.getInstance()
        startDate[1920, 1] = 23
        val endDate = Calendar.getInstance()
        endDate[2030, 2] = 28
        //时间选择器 ，自定义布局
        pvCustomLunar = TimePickerBuilder(this,
            OnTimeSelectListener { date, v ->
                //选中事件回调
                Toast.makeText(this, getTime(date), Toast.LENGTH_SHORT).show()
            })
            .setDate(selectedDate)
            .setRangDate(startDate, endDate)
            .setLayoutRes(R.layout.pickerview_custom_lunar, object : CustomListener {
                override fun customLayout(v: View) {
                    val tvSubmit =
                        v.findViewById<View>(R.id.tv_finish) as TextView
                    val ivCancel =
                        v.findViewById<View>(R.id.iv_cancel) as ImageView
                    tvSubmit.setOnClickListener {
                        pvCustomLunar?.returnData()
                        pvCustomLunar?.dismiss()
                    }
                    ivCancel.setOnClickListener { pvCustomLunar?.dismiss() }
                    //公农历切换
//                    val cb_lunar =
//                        v.findViewById<View>(R.id.cb_lunar) as CheckBox
//                    cb_lunar.setOnCheckedChangeListener { buttonView, isChecked ->
//                        pvCustomLunar?.setLunarCalendar(!pvCustomLunar?.isLunarCalendar()!!)
//                        //自适应宽
//                        setTimePickerChildWeight(
//                            v,
//                            if (isChecked) 0.8f else 1f,
//                            if (isChecked) 1f else 1.1f
//                        )
//                    }
                }

                /**
                 * 公农历切换后调整宽
                 * @param v
                 * @param yearWeight
                 * @param weight
                 */
//                private fun setTimePickerChildWeight(
//                    v: View,
//                    yearWeight: Float,
//                    weight: Float
//                ) {
//                    val timePicker =
//                        v.findViewById<View>(R.id.timepicker) as ViewGroup
//                    val year = timePicker.getChildAt(0)
//                    val lp =
//                        year.layoutParams as LinearLayout.LayoutParams
//                    lp.weight = yearWeight
//                    year.layoutParams = lp
//                    for (i in 1 until timePicker.childCount) {
//                        val childAt = timePicker.getChildAt(i)
//                        val childLp =
//                            childAt.layoutParams as LinearLayout.LayoutParams
//                        childLp.weight = weight
//                        childAt.layoutParams = childLp
//                    }
//                }
            })
            .setType(booleanArrayOf(true, true, true, false, false, false))
            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
            .setDividerColor(Color.RED)
            .build()
    }


    private fun getTime(date: Date): String {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.time)
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return format.format(date)
    }
}
