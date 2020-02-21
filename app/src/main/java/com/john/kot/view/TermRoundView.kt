package com.john.kot.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.comm.util.DisplayUtils.dp2px
import timber.log.Timber
import java.text.DecimalFormat

/**
 *  a Thermometer
 */
class TermRoundView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var degreeDf: String? = null
    private var scaleUnit: Float = 0.0f
    private val srcPaint: Paint //外圆环
    private val innnerPaint: Paint //内圆
    private val innerRadius = dp2px(context,20f) //内圆半径

    private val linePaint: Paint
    private val txtPaint: Paint
    private val yellowColorPaint: Paint
    private val yellowLightPaint: Paint
    private val yellowRectPaint: Paint
    private val metalPaint: Paint   //黄色矩形线
    val rulerLength=dp2px(context,730f) //温度计到头部到刻度42总长度
    val startX = dp2px(context,126f) //左边距离
    var tempScale =  (rulerLength- startX)/ (2 * 8) //刻度线长度
    val metalWidth= dp2px(context,40f) //the metal of Thermometer

    var scrollX:Float

    val rulerY = dp2px(context,200f)
    val waterHeight  = 15 //水银高度
    val longHScale = 20 //长刻度线的长度

    val txtTop =60f


    init {
        isClickable = true
        scrollX = (startX + tempScale *2 *2) //默认36
        srcPaint = Paint().apply {  //外圆
            color = Color.parseColor("#37BC95");
        }

        innnerPaint = Paint().apply {
            color = Color.parseColor("#A2CB79");
        }

        linePaint = Paint().apply {
            color = Color.parseColor("#999999");
            style = Paint.Style.STROKE
        }

        metalPaint = Paint().apply {
            color = Color.parseColor("#c0c0c2");
        }

        txtPaint = Paint().apply {
            color = Color.parseColor("#999999");
            textSize = 36f
        }

        yellowColorPaint = Paint().apply {
            color = Color.parseColor("#EF8741");
            textSize = 55f
        }

        yellowLightPaint = Paint().apply {
            color = Color.parseColor("#FCF0D1");
        }

        yellowRectPaint = Paint().apply {
            color = Color.parseColor("#EF8741");
        }

        scaleUnit = tempScale /5f; //0.1对应的长度
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //中线
        val topF = rulerY-waterHeight/2
        val bottomF = rulerY+waterHeight/2;
        val metalRect =  RectF(0f,topF-3,metalWidth,bottomF+3)
        canvas?.drawRoundRect(metalRect,10f,10f,metalPaint)

        val middleRect =  RectF(metalWidth,topF, dp2px(context,728f),bottomF)
        canvas?.drawRoundRect(middleRect,10f,10f,linePaint)

//        Timber.i("topF  $topF bottomF   $bottomF    rulerLength $rulerLength")

        val yellowRect =  RectF(metalWidth,topF,scrollX,bottomF)
        canvas?.drawRect(yellowRect,yellowRectPaint)



        //刻度
        for(i in 0..16){
            if ((i+1)%2==0){
                canvas?.drawLine(startX+tempScale*i,rulerY-waterHeight/2-5,startX+tempScale*i,rulerY-waterHeight/2,linePaint)
                canvas?.drawLine(startX+tempScale*i,rulerY+waterHeight/2,startX+tempScale*i,rulerY+waterHeight/2+5,linePaint)
            }

            val drawTxt = (34+i/2).toString()
            val txtRect = Rect()
            txtPaint.getTextBounds(drawTxt,0,drawTxt.length,txtRect)
            //底部长线
            if (i%4==0){
                canvas?.drawLine(startX+tempScale*i,rulerY+waterHeight/2,startX+tempScale*i,rulerY+waterHeight/2+longHScale,linePaint)
                canvas?.drawText(drawTxt,startX+tempScale*i - txtRect.width()/2,rulerY+waterHeight/2+longHScale+txtRect.height(),txtPaint)
            }

            //头部长线
            if ((i+2)%4==0){
                canvas?.drawLine(startX+tempScale*i,rulerY-waterHeight/2-longHScale,startX+tempScale*i,rulerY-waterHeight/2,linePaint)
                canvas?.drawText(drawTxt,startX+tempScale*i-txtRect.width()/2,rulerY-waterHeight/2-longHScale,txtPaint)
            }
        }
        val srcRadius: Float = (innerRadius + 8)
        canvas?.drawCircle(scrollX, rulerY, srcRadius, srcPaint);
        canvas?.drawCircle(scrollX, rulerY, innerRadius, innnerPaint);

        var rectCircleFirstX = (scrollX- dp2px(context,5f)/2-10 - dp2px(context,5f)) //第一个圆柱坐标,10是圆柱间距
        for (i in 0..2) {
            val rectF = RectF(rectCircleFirstX+(10*i), rulerY-20f, rectCircleFirstX+10f+(10*i), rulerY+20);
            rectCircleFirstX = (rectCircleFirstX + 10);
            canvas?.drawRoundRect(rectF, 10f, 10f, srcPaint)
        }
//        Timber.i("onDraw scrollX   $scrollX")
        val df = DecimalFormat("#0.0")
        val degreeValue =(scrollX - startX) / (scaleUnit*10) + 34
        degreeDf=df.format(degreeValue)

        val showDegreeTxt =degreeDf.plus("℃")

        val bgRect = Rect()
        yellowColorPaint.getTextBounds(showDegreeTxt,0,showDegreeTxt.length,bgRect)

        val rf = RectF(width/2f-20,txtTop-20-bgRect.height(),width/2f+bgRect.width()+20,txtTop+20)
        canvas?.drawRect(rf,yellowLightPaint) //度数边框
//        Timber.i(" onDraw degree  $   startX  $startX")
        if (degreeValue<37.5){
            yellowColorPaint.color = Color.parseColor("#A2CB79")
        }else if(degreeValue>=37.5 && degreeValue<=38){
            yellowColorPaint.color = Color.parseColor("#EF8741")
        }else if (degreeValue>38){
            yellowColorPaint.color = Color.parseColor("#EC4736")
        }
        canvas?.drawText(showDegreeTxt, width/2f, txtTop, yellowColorPaint) //度数显示
    }


    var downX :Float = 0.toFloat()
//    var anOffset :Float = 0.toFloat()
    override fun onTouchEvent(event: MotionEvent): Boolean {
        Timber.i("action onTouchEvent: " + event.action)
        if (event.x>=startX && event.x <= (rulerLength))
        when(event?.action){
            MotionEvent.ACTION_DOWN-> {
                downX = event.x
                Timber.i("onTouchEvent ACTION_DOWN downX    $downX")
            }

            MotionEvent.ACTION_MOVE -> {
//                //向右滑动
                Timber.i("onTouchEvent ACTION_MOVE    Math.abs(scrollX-downX) ${Math.abs(scrollX-downX)}  scaleUnit  $scaleUnit ")
                scrollX = event.x
                if (Math.abs(scrollX-downX)>=(scaleUnit/3)){
                    Timber.i("onTouchEvent ACTION_MOVE    invalidate()")
                    invalidate()
                }
            }
        }
        return super.onTouchEvent(event)
    }


    fun  getDegree():String?{
        return degreeDf
    }

}