package com.kot.tool.glide.lifecycle

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.john.kot.R
import com.john.kot.databinding.ActivityGlideBinding

class GlideActivity : AppCompatActivity() {
    private lateinit var icLink: View
    val TAG = "GlideActivity"
    val AC_CODE_SCHEME = "tngdwallet://client/dl/ACDecode?codeValue="
    val binding by viewBinding(ActivityGlideBinding::inflate)

    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_glide)

//        MyLifecycleFragment fragment = new MyLifecycleFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction();

        var uri = Uri.parse("tngdwallet://client/dl/another/webview?url=https://www.baidu.com")
        binding.btInput.setOnClickListener {
            val code = "acCodfe"
            val uri = Uri.parse(AC_CODE_SCHEME + code)

            val acParam = uri.getQueryParameter("codeValue")
            Log.i("GlideActivity", "testInterceptTrue: $acParam")

            var pathList: List<String> = uri.pathSegments
            pathList.forEach { Log.i(TAG, "onCreate: $it") }
        }

        icLink = findViewById(R.id.ic_link)
        icLink.visibility = View.VISIBLE
    }


    override fun onResume() {
        super.onResume()
        textView = findViewById(R.id.tv_thread)
//        Handler().post { Log.i("GlideActivity", "onResume: " + textView.getWidth()) }
    }

    override fun onPause() {
        super.onPause()

//
//        new Thread(()->{
//            viewById.setText("刷新完成");
//        }).start();
    }
}