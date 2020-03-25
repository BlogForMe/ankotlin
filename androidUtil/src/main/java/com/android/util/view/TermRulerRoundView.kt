package com.comm.util.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.android.util.R
import timber.log.Timber
import java.lang.ref.WeakReference
import java.math.BigDecimal
import java.math.RoundingMode


class TermRulerRoundView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var isRulerInput: Boolean = false
    private var showTxtX: Float = 0.0f
    private var degreeValue = 0.0f
    private var scaleUnit: Float = 0.0f
    private val srcPaint: Paint //外圆环
    private val innnerPaint: Paint //内圆
    private val innerRadius = 35f

    private val txtTitlePaint: Paint
    private val linePaint: Paint
    private val txtPaint: Paint
    private val yellowColorPaint: Paint
    private val yellowLightPaint: Paint
    private val yellowRectPaint: Paint
    private val yellowBtPaint: Paint
    private val whiteBtPaint: Paint
    val startX = 22f + 166 + 15 //左边距离
    val ruleLength = 870 //
    var scrollX = (startX + ruleLength / 8 * 2)

    val txtTop = 60f // 文字高度
    val ruleTop = 120f //尺子高度


    var tempScale = ruleLength / (2 * 8) //刻度线长度

    init {
        scaleUnit = tempScale / 5f; //0.1对应的长度

        val a = context?.theme?.obtainStyledAttributes(attrs, R.styleable.TermRulerRoundView, 0, 0)
        try {
            isRulerInput = a!!.getBoolean(R.styleable.TermRulerRoundView_isRulerInput, false)
        } finally {
            a?.recycle()
        }


        isClickable = true
        srcPaint = Paint().apply {
            color = Color.parseColor("#37BC95");
        }

        innnerPaint = Paint().apply {
            color = Color.parseColor("#A2CB79");
        }



        txtTitlePaint = Paint().apply {
            color = Color.parseColor("#EF8741");
            textSize = 37f
        }

        linePaint = Paint().apply {
            color = Color.parseColor("#999999");
            style = Paint.Style.STROKE
        }

        txtPaint = Paint().apply {
            color = Color.parseColor("#999999");
            textSize = 36f
        }

        yellowColorPaint = Paint().apply {
            color = Color.parseColor("#37BC95");
            textSize = 55f
        }

        yellowLightPaint = Paint().apply {
            color = Color.parseColor("#ffe8f8d8");
        }

        yellowRectPaint = Paint().apply {
            color = Color.parseColor("#EF8741");
        }

        yellowBtPaint = Paint().apply {
            color = Color.parseColor("#FAC742");
        }

        whiteBtPaint = Paint().apply {
            color = Color.WHITE
            strokeWidth = 4f
        }


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        showTxtX = width / 2f - 200f


        val bitmapWeak = WeakReference<Bitmap>(
            BitmapFactory.decodeResource(
                context.resources,
                R.mipmap.bg_temprature
            )
        )


        val rulerBitmap = bitmapWeak.get()
        if (rulerBitmap != null) {
            canvas?.drawBitmap(rulerBitmap, 0f, ruleTop, Paint())
        }
//        //Timber.i("bitmap width ${rulerBitmap?.width}  height ${rulerBitmap?.height}")
        val imgHeight = rulerBitmap?.height!!.toFloat()
//       val medleRect = RectF(0f,0f,rulerBitmap.width.toFloat(),20f);
        //中线
        val waterHeight = 15
        val topF = (ruleTop + imgHeight / 2) - waterHeight / 2;
        val bottomF = waterHeight / 2 + (ruleTop + imgHeight / 2);
        val middleRect = RectF(60f, topF, rulerBitmap?.width.toFloat() - 10, bottomF)
        canvas?.drawRoundRect(middleRect, 10f, 10f, linePaint)

        val yellowRect = RectF(60f, topF, scrollX, bottomF)
        canvas?.drawRect(yellowRect, yellowRectPaint)

        //Timber.i("rulerBitmap?.width    ${rulerBitmap?.width}")
//        var tempScale = (rulerBitmap?.width.toFloat() - 30f - 42f) / (2 * 9) //刻度线长度


        val longHScale = 20


        //刻度
        for (i in 0..16) {
            if ((i + 1) % 2 == 0) {
                canvas?.drawLine(
                    startX + tempScale * i,
                    topF - 5,
                    startX + tempScale * i,
                    topF,
                    linePaint
                )
                canvas?.drawLine(
                    startX + tempScale * i,
                    bottomF,
                    startX + tempScale * i,
                    bottomF + 5,
                    linePaint
                )
            }

            val drawTxt = (34 + i / 2).toString()
            val txtRect = Rect()
            txtPaint.getTextBounds(drawTxt, 0, drawTxt.length, txtRect)
            //底部长线
            if (i % 4 == 0) {
                canvas?.drawLine(
                    startX + tempScale * i,
                    bottomF,
                    startX + tempScale * i,
                    bottomF + longHScale,
                    linePaint
                )

                canvas?.drawText(
                    drawTxt,
                    startX + tempScale * i - txtRect.width() / 2,
                    bottomF + longHScale + txtRect.height(),
                    txtPaint
                )
            }

            //头部长线
            if ((i + 2) % 4 == 0) {
                canvas?.drawLine(
                    startX + tempScale * i,
                    topF - longHScale,
                    startX + tempScale * i,
                    topF,
                    linePaint
                )
                canvas?.drawText(
                    drawTxt,
                    startX + tempScale * i - txtRect.width() / 2,
                    topF - longHScale,
                    txtPaint
                )
            }
        }

        val centerY = (topF + longHScale / 2)
        val srcRadius: Float = (innerRadius + 8)
//        //Timber.i("scrollX   $scrollX   centerY  $centerY")

        if (isRulerInput) {
            canvas?.drawCircle(scrollX, centerY, srcRadius, srcPaint);
            canvas?.drawCircle(scrollX, centerY, innerRadius, innnerPaint);

            var rectCircleFirstX = (scrollX - innerRadius + 10) //第一个圆柱坐标
            for (i in 0..2) {
                val rectF = RectF(
                    rectCircleFirstX + (10 * i),
                    centerY - 20f,
                    rectCircleFirstX + 10f + (10 * i),
                    centerY + 20
                );
                rectCircleFirstX = (rectCircleFirstX + 10);
                canvas?.drawRoundRect(rectF, 10f, 10f, srcPaint)
            }
        }
        //Timber.i("onDraw scrollX   $scrollX")

//        val df =DecimalFormat("#0.0")
        val degreeOrigin = ((scrollX - startX) / (scaleUnit * 10) + 34).toString()
        degreeValue = BigDecimal(degreeOrigin).setScale(1, RoundingMode.HALF_UP).toFloat()
//        degreeDf=df.format(degreeValue)
        val showDegreeTxt = degreeValue.toString().plus("℃")


        val showTxtRect = Rect()
        yellowColorPaint.getTextBounds(showDegreeTxt, 0, showDegreeTxt.length, showTxtRect)

        val rf = RectF(
            showTxtX - 20 - 150,
            txtTop - 20 - showTxtRect.height(),
            showTxtX + 20 + 150 + showTxtRect.width(),
            txtTop + 20
        )
        canvas?.drawRoundRect(rf, 10f, 10f, yellowLightPaint) //度数背景边框

        Timber.i("showTxtRect.width()   ${showTxtRect.width()}")
        //Timber.i(" onDraw degree  $   startX  $startX")
        Timber.i("onDraw    $degreeValue")
        if (degreeValue < 37.5) {
            yellowColorPaint.color = Color.parseColor("#37BC95")
        } else if ((degreeValue >= 37.5) && (degreeValue <= 38)) {
            yellowColorPaint.color = Color.parseColor("#EF8741")
            Timber.i("degreeValue   $degreeValue")
        } else if (degreeValue > 38) {
            yellowColorPaint.color = Color.parseColor("#EC4736")
        }
        canvas?.drawText(showDegreeTxt, showTxtX, txtTop, yellowColorPaint) //度数显示

        val btCircle = 30f
        if (isRulerInput) {
            canvas?.drawCircle(
                showTxtX - 100,
                txtTop - showTxtRect.height() / 2,
                btCircle,
                yellowBtPaint
            )
            canvas?.drawLine(
                showTxtX - 100 - btCircle + 5,
                txtTop - showTxtRect.height() / 2,
                showTxtX - 100 + btCircle - 5,
                txtTop - showTxtRect.height() / 2,
                whiteBtPaint
            )

            val addCircleY = showTxtX + showTxtRect.width() + 100
            canvas?.drawCircle(
                addCircleY,
                txtTop - showTxtRect.height() / 2,
                btCircle,
                yellowBtPaint
            )
            canvas?.drawLine(
                addCircleY - btCircle + 5,
                txtTop - showTxtRect.height() / 2,
                addCircleY + btCircle - 5,
                txtTop - showTxtRect.height() / 2,
                whiteBtPaint
            )
            canvas?.drawLine(
                addCircleY,
                txtTop - showTxtRect.height() / 2 - btCircle + 5,
                addCircleY,
                txtTop - showTxtRect.height() / 2 + btCircle - 5,
                whiteBtPaint
            )
        }

    }

    var downX: Float = 0.toFloat()
    //    var anOffset :Float = 0.toFloat()
    override fun onTouchEvent(event: MotionEvent): Boolean {
        //Timber.i("action onTouchEvent: " + event.action)
        if (!isRulerInput) {
            return false
        }
        if (event.x >= startX - 5 && event.x <= (startX + ruleLength)) //-5更好的拖动到34 返回
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    downX = event.x
                    //Timber.i("onTouchEvent ACTION_DOWN downX    $downX")
                }

                MotionEvent.ACTION_MOVE -> {
//                anOffset = scrollX - downX
//                //向右滑动
//                //Timber.i("onTouchEvent ACTION_MOVE    scrollX   $scrollX    downX   $downX")
                    //Timber.i("onTouchEvent ACTION_MOVE    Math.abs(scrollX-downX) ${Math.abs(scrollX-downX)}  scaleUnit  $scaleUnit ")
                    if (event.y > ruleTop) {
                        scrollX = event.x
                        if (Math.abs(scrollX - downX) >= (scaleUnit / 3)) {
                            //Timber.i("onTouchEvent ACTION_MOVE    invalidate()")
                            invalidate()
                        }
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (event.y < ruleTop) {
                        if (event.x < showTxtX) {
                            scrollX -= scaleUnit
                        } else if (event.x > showTxtX + 150) {
                            Timber.i("scrollX   $scrollX")
                            scrollX += scaleUnit
                        }
                        invalidate()
                    }
                }
            }
        return super.onTouchEvent(event)
    }


    fun getDegree(): String? {
        return degreeValue.toString()
    }

    fun setDegree(valueDegree: String) {
        if (!valueDegree.isNullOrBlank()) {
            var ddf = (valueDegree.toFloat() - 34)
            var mmm = ddf * (scaleUnit * 10)
            scrollX = (mmm + startX)
//            val degreeOrigin = ((scrollX - startX) / (scaleUnit * 10) + 34).toString()
            if (scrollX >= startX - 5 && scrollX <= (startX + ruleLength)) {
                invalidate()
            }

            Timber.i("valueDegree   $valueDegree   scrollX  $scrollX ")
        }
    }

}