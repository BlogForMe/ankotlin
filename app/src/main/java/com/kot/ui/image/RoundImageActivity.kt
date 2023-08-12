package com.kot.ui.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityRoundImage1Binding

class RoundImageActivity : AppCompatActivity() {
    //    val binding by lazy { ActivityRoundImageBinding.inflate(layoutInflater) }
    val binding by lazy { ActivityRoundImage1Binding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bitmap = BitmapFactory.decodeResource(
            resources, R.drawable.meitu110468869
        )
//        val recBitmap = BitmapFactory.decodeResource(
//            resources, R.drawable.meituimages1
//        )

//        binding.demoShaderBottomRoundImage.setImageBitmap(
//            roundBottomBitmapByShader(
//                bitmap,
//                resources.getDimension(R.dimen.round_bitmap_width).toInt(),
//                resources.getDimension(R.dimen.round_bitmap_height).toInt(),
//                resources.getDimension(R.dimen.round_bitmap_radius).toInt()
//            )
//        )
//        binding.demoShaderBottomRoundImage1.setImageBitmap(
//            roundBottomBitmapByShader(
//                bitmap,
//                resources.getDimension(R.dimen.round_bitmap_width).toInt(),
//                resources.getDimension(R.dimen.round_bitmap_height).toInt(),
//                resources.getDimension(R.dimen.round_bitmap_radius).toInt()
//            )
//        )


    }


    /**
     * 利用BitmapShader绘制圆角图片
     *
     * @param bitmap
     * 待处理图片
     * @param outWidth
     * 结果图片宽度，一般为控件的宽度
     * @param outHeight
     * 结果图片高度，一般为控件的高度
     * @param radius
     * 圆角半径大小
     * @return
     * 结果图片
     */
    private fun roundBitmapByShader(
        bitmap: Bitmap?,
        outWidth: Int,
        outHeight: Int,
        radius: Int
    ): Bitmap? {
        if (bitmap == null) {
            throw NullPointerException("Bitmap can't be null")
        }
        // 初始化缩放比
        val widthScale = outWidth * 1.0f / bitmap.width
        val heightScale = outHeight * 1.0f / bitmap.height
        val matrix = Matrix()
        matrix.setScale(widthScale, heightScale)

        // 初始化绘制纹理图
        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        // 根据控件大小对纹理图进行拉伸缩放处理
        bitmapShader.setLocalMatrix(matrix)

        // 初始化目标bitmap
        val targetBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888)

        // 初始化目标画布
        val targetCanvas = Canvas(targetBitmap)

        // 初始化画笔
        val paint = Paint()
        paint.isAntiAlias = true
        paint.shader = bitmapShader

        // 利用画笔将纹理图绘制到画布上面
        targetCanvas.drawRoundRect(
            RectF(0f, 0f, outWidth.toFloat(), outWidth.toFloat()),
            radius.toFloat(),
            radius.toFloat(),
            paint
        )
        return targetBitmap
    }

    /**
     * 利用BitmapShader绘制底部圆角图片
     *
     * @param bitmap
     * 待处理图片
     * @param outWidth
     * 结果图片宽度，一般为控件的宽度
     * @param outHeight
     * 结果图片高度，一般为控件的高度
     * @param radius
     * 圆角半径大小
     * @return
     * 结果图片
     */
    private fun roundBottomBitmapByShader(
        bitmap: Bitmap?,
        outWidth: Int,
        outHeight: Int,
        radius: Int
    ): Bitmap? {
        if (bitmap == null) {
            throw NullPointerException("Bitmap can't be null")
        }
        // 初始化缩放比
        val widthScale = outWidth * 1.0f / bitmap.width
        val heightScale = outHeight * 1.0f / bitmap.height
        val matrix = Matrix()
        matrix.setScale(widthScale, heightScale)

        // 初始化绘制纹理图
        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        // 根据控件大小对纹理图进行拉伸缩放处理
        bitmapShader.setLocalMatrix(matrix)

        // 初始化目标bitmap
        val targetBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888)

        // 初始化目标画布
        val targetCanvas = Canvas(targetBitmap)

        // 初始化画笔
        val paint = Paint()
        paint.isAntiAlias = true
        paint.shader = bitmapShader

        // 利用画笔绘制底部圆角
//        targetCanvas.drawRoundRect(
//            RectF(
//                0f,
//                (outHeight - 2 * radius).toFloat(), outWidth.toFloat(), outWidth.toFloat()
//            ), radius.toFloat(), radius.toFloat(), paint
//        )

        // 利用画笔绘制顶部上面直角部分
        targetCanvas.drawRect(
            RectF(
                0f, 0f, outWidth.toFloat(),
                (outHeight - radius).toFloat()
            ), paint
        )

        return targetBitmap
    }


}


//        binding.ivGirl1.setOnClickListener {
//            val languageSpanString1 = LanguageUtil.setLanguageSpanString(this,getString(R.string.duitnow_first_copy_account_no))
//            val languageSpanString2 = LanguageUtil.setLanguageSpanString(this,getString(R.string.duitnow_second_login_banking_app))
//            val languageSpanString3 = LanguageUtil.setLanguageSpanString(this,getString(R.string.duitnow_third_select_transfer_type))
//            val languageSpanString4 = LanguageUtil.setLanguageSpanString(this,getString(R.string.duitnow_fourth_select_touch_go))
//            val languageSpanString5 = LanguageUtil.setLanguageSpanString(this,getString(R.string.duitnow_fifth_verify_recipient_name))
//            val languageSpanString6 = LanguageUtil.setLanguageSpanString(this,getString(R.string.duitnow_bottom_transfer_service_introduction))
//            println(languageSpanString1)
//        }
