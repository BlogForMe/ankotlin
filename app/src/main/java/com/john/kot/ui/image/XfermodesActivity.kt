package com.john.kot.ui.image

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class XfermodesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SampleXfermodeView(this))
//        setContentView(R.layout.activity_xfermode_view)
    }

    private class SampleXfermodeView(context: Context?) : View(context) {
        private val mSrcB: Bitmap
        private val mDstB: Bitmap
        private val mBG // background checker-board pattern
                : Shader

        private val modeIndex = 0 // 模式
        override fun onDraw(canvas: Canvas) {
            canvas.drawColor(Color.WHITE)
            val labelP = Paint(Paint.ANTI_ALIAS_FLAG)
            labelP.textAlign = Paint.Align.CENTER
            val paint = Paint()
            paint.isFilterBitmap = false
            canvas.translate(15F, 35F)
            var x = 0f
            var y = 0f
            for (modeIndex in sModes.indices) {
                // draw the border
                paint.style = Paint.Style.STROKE
                paint.shader = null
                canvas.drawRect(
                    x - 0.5f, y - 0.5f,
                    x + W + 0.5f, y + H + 0.5f, paint
                )
                // draw the checker-board pattern
                paint.style = Paint.Style.FILL
                paint.shader = mBG
                canvas.drawRect(x, y, x + W, y + H, paint)
                // draw the src/dst example into our offscreen bitmap
                val sc: Int = canvas.saveLayer(
                    x, y, x + W, y + H, null,
                )
                canvas.translate(x, y)
                canvas.drawBitmap(mDstB, 0f, 0f, paint)
                paint.xfermode = sModes[modeIndex]
                canvas.drawBitmap(mSrcB, 0f, 0f, paint)
                paint.xfermode = null // 我猜否则下次循环会用到
                canvas.restoreToCount(sc)
                // draw the label
                canvas.drawText(
                    sLabels[modeIndex],
                    x + W / 2, y - labelP.getTextSize() / 2, labelP
                )
                x += W + 10
                // wrap around when we've drawn enough for one row
                if ((modeIndex % ROW_MAX) == ROW_MAX - 1) {
                    x = 0f
                    y += H + 30
                }
            }
        }

        companion object {
            private val W = 200
            private val H = 200
            private val ROW_MAX = 4 // number of samples per row
            private val sModes: Array<Xfermode> = arrayOf<Xfermode>(
                PorterDuffXfermode(PorterDuff.Mode.CLEAR),
                PorterDuffXfermode(PorterDuff.Mode.SRC),
                PorterDuffXfermode(PorterDuff.Mode.DST),
                PorterDuffXfermode(PorterDuff.Mode.SRC_OVER),
                PorterDuffXfermode(PorterDuff.Mode.DST_OVER),
                PorterDuffXfermode(PorterDuff.Mode.SRC_IN),
                PorterDuffXfermode(PorterDuff.Mode.DST_IN),
                PorterDuffXfermode(PorterDuff.Mode.SRC_OUT),
                PorterDuffXfermode(PorterDuff.Mode.DST_OUT),
                PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP),
                PorterDuffXfermode(PorterDuff.Mode.DST_ATOP),
                PorterDuffXfermode(PorterDuff.Mode.XOR),
                PorterDuffXfermode(PorterDuff.Mode.DARKEN),
                PorterDuffXfermode(PorterDuff.Mode.LIGHTEN),
                PorterDuffXfermode(PorterDuff.Mode.MULTIPLY),
                PorterDuffXfermode(PorterDuff.Mode.SCREEN)
            )
            private val sLabels = arrayOf(
                "Clear", "Src", "Dst", "SrcOver",
                "DstOver", "SrcIn", "DstIn", "SrcOut",
                "DstOut", "SrcATop", "DstATop", "Xor",
                "Darken", "Lighten", "Multiply", "Screen"
            )
        }

        init {
            mSrcB = makeSrc(W, H)
            mDstB = makeDst(W, H)
            // make a ckeckerboard pattern
            val bm: Bitmap = Bitmap.createBitmap(
                intArrayOf(
                    -0x1, -0x333334,
                    -0x333334, -0x1
                ), 2, 2,
                Bitmap.Config.RGB_565
            )
            mBG = BitmapShader(
                bm,
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT
            )
            val m = Matrix()
            m.setScale(6f, 6f)
            mBG.setLocalMatrix(m)
        }
    }

    companion object {
        // create a bitmap with a circle, used for the "dst" image
        fun makeDst(w: Int, h: Int): Bitmap {
            val bm: Bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            val c = Canvas(bm)
            val p = Paint(Paint.ANTI_ALIAS_FLAG)
            p.color = -0x33bc
            c.drawOval(RectF(0f, 0f, w * 3f / 4, h * 3f / 4), p)
            return bm
        }

        // create a bitmap with a rect, used for the "src" image
        fun makeSrc(w: Int, h: Int): Bitmap {
            val bm: Bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            val c = Canvas(bm)
            val p = Paint(Paint.ANTI_ALIAS_FLAG)
            p.color = -0x995501
            c.drawRect(w / 3f, h / 3f, w * 19f / 20, h * 19f / 20, p)
            return bm
        }
    }
}