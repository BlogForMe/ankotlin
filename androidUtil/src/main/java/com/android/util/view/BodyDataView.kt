package com.android.util.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.android.util.DisplayUtils
import com.android.util.R
import timber.log.Timber
import java.lang.Exception


//体重组合控件
class BodyDataView : RelativeLayout{

    private var tvValueFat: TextView? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context, attrs)
    }

    private fun initView(context: Context?, attrs: AttributeSet?) {
        try {
            var ta = context?.obtainStyledAttributes(attrs, R.styleable.BodyDataView)
            var bodyValuetxt = ta?.getString(R.styleable.BodyDataView_body_value_txt)
            var bodyValueTitle = ta?.getString(R.styleable.BodyDataView_body_value_title)
            var imgResource:Int = ta!!.getResourceId(R.styleable.BodyDataView_img_body_check, R.mipmap.ble_back_home)
            var bodyValueTextSize = ta?.getDimensionPixelSize(R.styleable.BodyDataView_body_value_text_size,16).toFloat()

            var view = LayoutInflater.from(context).inflate(R.layout.item_body_view, this,false)
            tvValueFat = view.findViewById<TextView>(R.id.tv_fat)

            var tvTitle = view.findViewById<TextView>(R.id.tv_t_fat)
            var ivFat = view.findViewById<ImageView>(R.id.iv_fat)
            ivFat?.setImageResource(imgResource)
            tvValueFat?.text=(bodyValuetxt)
            tvValueFat?.setTextSize(TypedValue.COMPLEX_UNIT_PX,bodyValueTextSize)
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,bodyValueTextSize)
            tvTitle.text=(bodyValueTitle)
            addView(view)
            ta.recycle()

            Timber.i("bodyValueTextSize $bodyValueTextSize")
        }catch (e:Exception){
            e.printStackTrace()
        }


    }

    public fun setBdFatValue(txt :String) {
        tvValueFat?.let {
            it.text=txt
        }
        invalidate()
    }
}