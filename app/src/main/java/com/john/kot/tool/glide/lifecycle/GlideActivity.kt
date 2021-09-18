package com.john.kot.tool.glide.lifecycle

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_glide.*
import retrofit2.http.Url

class GlideActivity : AppCompatActivity() {
    val TAG = "GlideActivity"
    val AC_CODE_SCHEME = "tngdwallet://client/dl/ACDecode?codeValue="

    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

//        MyLifecycleFragment fragment = new MyLifecycleFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction();

        var uri = Uri.parse("tngdwallet://client/dl/another/webview?url=https://www.baidu.com")
        bt_input.setOnClickListener {
//            val code = "acCodfe"
//            val uri = Uri.parse(AC_CODE_SCHEME + code)
//
//            val acParam = uri.getQueryParameter("codeValue")
//            Log.i("GlideActivity", "testInterceptTrue: $acParam")

            var pathList:List<String> = uri.pathSegments
            pathList.forEach { Log.i(TAG, "onCreate: $it") }
        }
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