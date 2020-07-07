package com.john.kot.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.view.ViewConfiguration
import com.android.util.DisplayUtils.dp2px
import com.john.kot.R
import timber.log.Timber
import java.lang.ref.WeakReference
import java.util.*
import kotlin.math.abs

/**
 * https://github.com/385841539/HorizontalScrollSelectedView
 */
class HorizontalselectedView(mContext: Context?, attrs: AttributeSet?) :
    View(mContext, attrs) {
    private var smallUnit: Float = 0f
    private var mMinimumVelocity: Float
    private var mMaximumVelocity: Float
    private var mVelocityTracker:VelocityTracker? = null

    private  var rectTxt: Rect //文字大小测量
    private var strings: List<String> = ArrayList()//数据源字符串数组

    private var seeSize = 7  // 文字可见数

    private var anInt: Float = 0f //单个字母所占宽度；
    private val textPaint=TextPaint(Paint.ANTI_ALIAS_FLAG)
    private var firstVisible = true
    private var mWidth: Float = 0f//控件宽度
    private var mHeight: Float = 0f//控件总高度
    private var index: Int = 0 // 被选中的文字
    private var downX: Float = 0.toFloat()
    private var anOffset: Float = 0.toFloat() //滑动距离
    private val selectedTextSize: Float
    private val selectedColor: Int
    private var mtextSize: Float
    private val rect = Rect()

    private var textWidth = 0
    private var textHeight = 0
    private var centerTextHeight = 0

    private var selectedPaint  = TextPaint(Paint.ANTI_ALIAS_FLAG) //被选中文字的画笔

    val scaleHeight = dp2px(context, 24f)
    init {
        setWillNotDraw(false)
        isClickable = true

        val tta = context.obtainStyledAttributes(
            attrs,
            R.styleable.HorizontalselectedView
        )
        //两种字体颜色和字体大小
        seeSize = tta.getInteger(R.styleable.HorizontalselectedView_HorizontalselectedViewSeesize, 5)
        selectedTextSize = tta.getFloat(R.styleable.HorizontalselectedView_HorizontalselectedViewSelectedTextSize, 50f)
        selectedColor = tta.getColor(               // 选中字体颜色
            R.styleable.HorizontalselectedView_HorizontalselectedViewSelectedTextColor, context.resources.getColor(android.R.color.black)
        )
        mtextSize = tta.getFloat(R.styleable.HorizontalselectedView_HorizontalunselectedViewTextSize, 40f)
//        val selectTextColor = tta.getColor(
//            R.styleable.HorizontalselectedView_HorizontalunselectedViewTextColor,
//            context.resources.getColor(android.R.color.darker_gray)
//        )


        textPaint?.apply {
            textSize =  mtextSize
            color = Color.parseColor("#DDDDDD")
        }


        selectedPaint?.apply {
            color = selectedColor
            textSize = selectedTextSize
        }

        rectTxt = Rect()

        try {
            tta.recycle()
        }catch (e:Exception){
            e.printStackTrace()
        }

        mMaximumVelocity = ViewConfiguration.get(context).scaledMaximumFlingVelocity.toFloat();
        mMinimumVelocity = ViewConfiguration.get(context).scaledMinimumFlingVelocity.toFloat();
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
            mWidth = width.toFloat()
            mHeight = height.toFloat()
            anInt = mWidth / seeSize
            smallUnit = anInt/10
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        Timber.i("height$height   width $mWidth  height $mHeight")

        //绘制渐变背景

        val bitmapWeak = WeakReference<Bitmap>(BitmapFactory.decodeResource(context.resources, R.mipmap.scrolle_ruler))

        val resizeBitmapWeak = WeakReference<Bitmap>(bitmapWeak.get()?.let { Bitmap.createScaledBitmap(it, mWidth?.toInt(), mHeight?.toInt(), true) })

        val src = Rect(0, 0, mWidth.toInt(), mHeight.toInt())
        resizeBitmapWeak.get()?.let { canvas.drawBitmap(it, src, src, Paint()) }

        /**
         * 绘制渐变背景
         */
//        val colors = intArrayOf(
//            Color.parseColor("#f9f9f9"),
//            Color.parseColor("#EEEEEE"),
//            Color.parseColor("#F2F2F2"),
//            Color.parseColor("#E6E6E6")
//        )
//        val positions = floatArrayOf(0.2F, 0.2f, 0.5f, 1f)
//        val linearGradient = LinearGradient(0f, mHeight, mWidth / 2, mHeight, colors, positions, Shader.TileMode.MIRROR)
//        val mPaint = Paint()
//        mPaint.setShader(linearGradient)
//        canvas?.drawRect(0f, 0f, mWidth, mHeight, mPaint)

        //中间座标绘制
        if (index >= 0 && index <= strings.size - 1) { // index - 1
            val s = strings[index]
            selectedPaint?.getTextBounds(s, 0, s.length, rect)
            val centerTextWidth = rect.width()
            centerTextHeight = rect.height()
            canvas.drawText(strings[index],  mWidth / 2 - centerTextWidth / 2 + anOffset,  (height / 2 + centerTextHeight / 2f), selectedPaint)//绘制被选中文字，注意点是y坐标

           //这里主要是因为strings数据源的文字长度不一样，为了让被选中两边文字距离中心宽度一样，我们取得左右两个文字长度的平均值
//            var width1=0
//            if (index!=0){
//                textPaint?.getTextBounds(strings[index - 1], 0, strings[index - 1].length, rect)
//                width1 = rect.width()
//            }
//            var width2=0
//            if (index!=strings.size - 1){
//                width2 = rect.width()
//                textPaint?.getTextBounds(strings[index + 1], 0, strings[index + 1].length, rect)
//            }
//            textWidth = (width1 + width2) / 2
            textWidth =  rect.width() / 2
            for (i in strings.indices) {//遍历strings，把每个数字都绘制出来，
                if (i == 0) {//得到高，高度是一样的，所以无所谓
                    textPaint?.getTextBounds(strings[0], 0, strings[0].length, rect)
                    textHeight = rect.height()
                }

                /**
                 * getWidth() / 2+(i - index) * anInt - textWidth / 2 + anOffset 每组文字得x坐标,anOffset先不考虑
                 * getWidth() / 2  中心点坐标
                 * (i - index) * anInt 向左或向右得坐标 , index选中年龄，初始化为0， i从第一个开始绘制,
                 * textWidth / 2   文字得宽度
                 */

                if (i != index) {
                    canvas.drawText(strings[i], mWidth / 2+(i - index) * anInt  - textWidth / 2 + anOffset,
                        (getHeight() / 2 + textHeight / 2f),  textPaint)  //画出未选中的文字
                }
                var scaleDifferHeight  = dp2px(context, 43f)  //背景图阴影到刻度的距离
                var scaleHeight = 0f  //粗线刻度高度
                if (i == index) {
                    scaleHeight = dp2px(context, 26f)//中间刻度要高点
                } else {
                    scaleHeight = dp2px(context, 24f)
                }
                /**
                 * 绘制刻度
                 */
                val scalePath = Path()
                val scaleX =  mWidth /2 +(i - index) * anInt   //左边第一个绘制的刻度座标
                scalePath.addRect(scaleX, scaleDifferHeight,scaleX + 5f,scaleDifferHeight + scaleHeight ,  Path.Direction.CW) //上面刻度，5f粗线的宽度

                scalePath.addRect(scaleX,mHeight  - scaleHeight  - scaleDifferHeight ,scaleX + 5f,mHeight - scaleDifferHeight ,  Path.Direction.CW)//下面大刻度

                val smallPath = Path()
                for (k in 1 until  10){
                    smallPath.addRect(scaleX+smallUnit*k, scaleDifferHeight,scaleX+smallUnit*k + 2f,scaleDifferHeight + scaleHeight-10 ,  Path.Direction.CW) //上面刻度，2f粗线的宽度
                    smallPath.addRect(scaleX+smallUnit*k,mHeight  - scaleHeight  - scaleDifferHeight+10 ,scaleX+smallUnit*k + 2f,mHeight - scaleDifferHeight ,  Path.Direction.CW)//下面大刻度
                }

                if (i == index) {
                    canvas.drawPath(scalePath, selectedPaint)
                } else {
                    canvas.drawPath(scalePath, textPaint)
                }

                canvas.drawPath(smallPath,textPaint)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        var height=0
        if (heightMode == MeasureSpec.AT_MOST) {
            height = scaleHeight.toInt() * 2 + rectTxt.height() + dp2px(context, 90f).toInt() * 2
        } else {
            height = heightSize
        }
        setMeasuredDimension(width, height)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker?.addMovement(event);
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x //获得点下去的x坐标
            }
            MotionEvent.ACTION_MOVE -> {
                val scrollX = event.x

                // 计算当前速度， 1000表示每秒像素数等
                mVelocityTracker?.computeCurrentVelocity(1000, mMaximumVelocity)
                // 获取横向速度
                val velocityX = mVelocityTracker?.xVelocity
//                Timber.d("velocityX $velocityX")
                var step = 1
                velocityX?.let {
                    if (abs(velocityX) >5000){
                        step = 6;
                    }else if (abs(velocityX)>4000){
                        step = 5
                    } else if (abs(velocityX)>2000){
                        step = 4
                    }else if (abs(velocityX)>1000){
                        step = 3
                    } else{
                        step=1
                    }
                }

                if (index != 0 && index != strings.size - 1) {
                    anOffset = scrollX - downX     //滑动时的偏移量，用于计算每个是数据源文字的坐标值
                } else {
                    anOffset = ((scrollX - downX) / 1.5).toFloat()  //当滑到两端的时候添加一点阻力
                }
                if (scrollX > downX) {
                    //向右滑动，当滑动距离大于每个单元的长度时，则改变被选中的文字。
                   val translateX = scrollX - downX
                    if (translateX >= anInt/2) {
                        if (index > 0) {
                            anOffset = 0f
                            index -=step
                            downX = scrollX
                        }else{
                            index=0  //处理index<0的情况
                        }
                    }
                } else {
                    //向左滑动，当滑动距离大于每个单元的长度时，则改变被选中的文字。
                    if (downX - scrollX >= anInt/2) {
                        if (index < strings.size - 1) {
                            anOffset = 0f
                            index += step
                            downX = scrollX
                        }else{
                            index=strings.size - 1 //处理index超出的情况
                        }
                    }
                }
//                Timber.i("index  $index  step  $step")
                invalidate()
           }
            MotionEvent.ACTION_UP -> {
                anOffset = 0f
                invalidate()


                mVelocityTracker?.recycle()
                mVelocityTracker = null
            }
            MotionEvent.ACTION_CANCEL->{
                // Return a VelocityTracker object back to be re-used by others.
                mVelocityTracker?.recycle()
                mVelocityTracker = null
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 获得被选中的文本
     *
     * @return 被选中的文本
     */
    fun getSelectedString(): String {
        if (strings.size != 0) {
            return strings[index]
        }
        return ""
    }

    /**
     * 改变中间可见文字的数目
     *
     * @param seeSizes 可见数
     */
    fun setSeeSize(seeSizes: Int) {
        if (seeSize > 0) {
            seeSize = seeSizes
            invalidate()
        }

    }


    /**
     * 向左移动一个单元
     */
    fun setAnLeftOffset() {
        if (index < strings.size - 1) {
            index = index + 1
            invalidate()
        }

    }

    /**
     * 向右移动一个单元
     */
    fun setAnRightOffset() {
        if (index > 0) {
            index = index - 1
            invalidate()
        }
    }

    /**
     * 设置个数据源
     *
     * @param strings 数据源String集合
     */
    fun setData(strings: List<String>) {
        this.strings = strings
        index = strings.size / 2  //默认选中数
        invalidate()
    }
}
