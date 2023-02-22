package com.comm.util.link

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.comm.util.R
import com.comm.util.databinding.ActivityTestDeepLinkBinding

class TestDeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_deep_link)
        val biding = ActivityTestDeepLinkBinding.inflate(layoutInflater)
        val html = "有问题：<a href='http://www.baidu.com'>百度一下</a>"
        biding.btDeeplink.setLinkTextColor(Color.BLUE)
//        biding.btDeeplink.movementMethod = LinkMovementMethod.getInstance()
//        biding.btDeeplink.text = Html.fromHtml(html,FROM_HTML_MODE_LEGACY)

        val ss: String? = null
        TestNull().testnull(ss)
    }
}