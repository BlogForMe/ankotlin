package com.kot.view


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.kot.R
import timber.log.Timber
import java.lang.ref.WeakReference
import java.text.DecimalFormat


/**
 * 背景图片的温度计
 * 如何控制背景图的大小
 */
class TermRoundImgView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var scaleUnit: Float = 0.0f
    private val srcPaint: Paint
    private val innnerPaint: Paint
    private val innerRadius = 35f

    private val txtTitlePaint: Paint
    private val linePaint: Paint
    private val txtPaint: Paint
    private val yellowColorPaint: Paint
    private val yellowLightPaint: Paint
    val startX = 22f+166
    var scrollX = startX + 875/8 *2

    init {
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
            color = Color.parseColor("#EF8741");
            textSize = 55f
        }

        yellowLightPaint = Paint().apply {
            color = Color.parseColor("#FCF0D1");
        }


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val txtTop = 60f

        val bitmapWeak = WeakReference<Bitmap>(
            BitmapFactory.decodeResource(
                context.resources,
                R.mipmap.bg_temprature
            )
        )

        val ruleTop = 100f
        var rulerBitmap = bitmapWeak.get()
        rulerBitmap?.let { canvas?.drawBitmap(it,0f,ruleTop,Paint()) }
//        Timber.i("bitmap width ${rulerBitmap?.width}  height ${rulerBitmap?.height}")
        val imgHeight = rulerBitmap?.height!!.toFloat()
//       val medleRect = RectF(0f,0f,rulerBitmap.width.toFloat(),20f);
        //中线
        val waterHeight  = 15
        val topF =(ruleTop+imgHeight/2)-waterHeight/2;
        val bottomF = waterHeight/2+(ruleTop+imgHeight/2);
        val middleRect =  RectF(45f,topF,rulerBitmap.width.toFloat()-10,bottomF)
        canvas?.drawRoundRect(middleRect,10f,10f,linePaint)

        val yellowRect =  RectF(45f,topF,scrollX,bottomF)
        canvas?.drawRect(yellowRect,yellowColorPaint)

        Timber.i("rulerBitmap?.width    ${rulerBitmap.width}")
//        var tempScale = (rulerBitmap?.width.toFloat() - 30f - 42f) / (2 * 9) //刻度线长度
        var tempScale = 870f / (2 * 8) //刻度线长度

        scaleUnit = tempScale /5; //0.1对应的长度

        val longHScale = 20

        //刻度
        for(i in 0..16){
            if ((i+1)%2==0){
                canvas?.drawLine(startX+tempScale*i,topF-5,startX+tempScale*i,topF,linePaint)
                canvas?.drawLine(startX+tempScale*i,bottomF,startX+tempScale*i,bottomF+5,linePaint)
            }

            val drawTxt = (34+i/2).toString()
            val txtRect = Rect()
            txtPaint.getTextBounds(drawTxt,0,drawTxt.length,txtRect)
            //底部长线
            if (i%4==0){
                canvas?.drawLine(startX+tempScale*i,bottomF,startX+tempScale*i,bottomF+longHScale,linePaint)

                canvas?.drawText(drawTxt,startX+tempScale*i - txtRect.width()/2,bottomF+longHScale+txtRect.height(),txtPaint)
            }

            //头部长线
            if ((i+2)%4==0){
                canvas?.drawLine(startX+tempScale*i,topF-longHScale,startX+tempScale*i,topF,linePaint)
                canvas?.drawText(drawTxt,startX+tempScale*i-txtRect.width()/2,topF-longHScale,txtPaint)
            }
        }

        val centerY = (topF + longHScale/2)
        val srcRadius: Float = (innerRadius + 8)
//        Timber.i("scrollX   $scrollX   centerY  $centerY")
        canvas?.drawCircle(scrollX, centerY, srcRadius, srcPaint);
        canvas?.drawCircle(scrollX, centerY, innerRadius, innnerPaint);

        var rectCircleFirstX = (scrollX-innerRadius + 10) //第一个圆柱坐标
        for (i in 0..2) {
            val rectF = RectF(rectCircleFirstX+(10*i), centerY-20f, rectCircleFirstX+10f+(10*i), centerY+20);
            rectCircleFirstX = (rectCircleFirstX + 10);
            canvas?.drawRoundRect(rectF, 10f, 10f, srcPaint)
        }
        Timber.i("onDraw scrollX   $scrollX")

        val df =DecimalFormat("#0.0")
        val degree=df.format((scrollX - startX) / (scaleUnit*10) + 34)


        val showDegreeTxt =degree.plus("℃")

        val bgRect = Rect()
        yellowColorPaint.getTextBounds(showDegreeTxt,0,showDegreeTxt.length,bgRect)

        val rf = RectF(300f-20,txtTop-20-bgRect.height(),300f+bgRect.width()+20,txtTop+20)
        canvas?.drawRect(rf,yellowLightPaint)

        Timber.i(" onDraw degree  $degree   startX  $startX")
        canvas?.drawText(showDegreeTxt, 300f, txtTop, yellowColorPaint)


    }


    var downX :Float = 0.toFloat()
    //    var anOffset :Float = 0.toFloat()
    override fun onTouchEvent(event: MotionEvent): Boolean {
        Timber.i("action onTouchEvent: " + event.action)

        when(event?.action){
            MotionEvent.ACTION_DOWN-> {
                downX = event.x
                Timber.i("onTouchEvent ACTION_DOWN downX    $downX")
            }

            MotionEvent.ACTION_MOVE -> {
//                anOffset = scrollX - downX
//                //向右滑动
//                Timber.i("onTouchEvent ACTION_MOVE    scrollX   $scrollX    downX   $downX")

                Timber.i("onTouchEvent ACTION_MOVE    Math.abs(scrollX-downX) ${Math.abs(scrollX-downX)}  scaleUnit  $scaleUnit ")
                scrollX = event.x
                if (Math.abs(scrollX-downX)>=scaleUnit){
                    Timber.i("onTouchEvent ACTION_MOVE    invalidate()")
                    invalidate()
                }

            }
        }

        return super.onTouchEvent(event)
    }

}