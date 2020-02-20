package com.john.kot.sdk

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_glide_use_listener.*
import timber.log.Timber

class GlideUseListenerActivity : AppCompatActivity() {
    val imgSt ="https://dev.casanubeserver.com/csn_hospital_APIServer/Qrcode/getQrcode?patientCode=12333"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_use_listener)

        bt_glide_loadfailed.setOnClickListener {
            Glide.with(this).load(imgSt)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .listener(object :RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Timber.e("onLoadFailed")
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Timber.e("onResourceReady")
                        return false
                    }

                })
                .into(iv_scan_tai)
        }
    }
}

