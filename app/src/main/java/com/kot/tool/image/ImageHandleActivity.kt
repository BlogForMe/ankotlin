package com.kot.tool.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R


/**
 * handle image
 */
class ImageHandleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_handle)

//        bt_mirror_flip.setOnClickListener {
//            mirrorFlip()
//        }
    }
    //镜面翻转
    fun mirrorFlip(){
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.img_mirror_origin)

        //绘制矩阵  Matrix主要用于对平面进行平移(Translate)，缩放(Scale)，旋转(Rotate)以及斜切(Skew)操作。
        val matrix = Matrix()
        val w: Int = bitmap.width
        val h: Int = bitmap.height

        matrix.setScale(-1f,1f) //水平翻转
//        matrix.setScale(1f,-1f) //垂直翻转
        val reversePic = Bitmap.createBitmap(bitmap,0,0,w,h,matrix,true)
//        iv_origin_target.setImageBitmap(reversePic)
    }
}
