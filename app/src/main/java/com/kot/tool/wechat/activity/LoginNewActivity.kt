package com.kot.tool.wechat.activity

//import android.graphics.BitmapFactory
//import android.os.Bundle
//import android.view.View
//import android.widget.ImageView
//import android.widget.Toast
//import com.android.util.base.CMvpActivity
//import com.google.gson.Gson
//import com.kot.IApiStore
//import com.kot.R
//import com.kot.tool.wechat.bean.WeChatSecond
//import com.kot.tool.wechat.bean.WeChatThird
//import com.kot.tool.wechat.bean.WeChatUserInfo
//import com.kot.tool.wechat.util.*
//import com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory
//import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
//import com.tencent.mm.opensdk.diffdev.OAuthErrCode
//import com.tencent.mm.opensdk.diffdev.OAuthListener
//import io.reactivex.Observable
//import io.reactivex.ObservableOnSubscribe
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.functions.Consumer
//import io.reactivex.schedulers.Schedulers
//import kotlinx.android.synthetic.main.activity_rx_java.*
//import okhttp3.*
//import timber.log.Timber
//import java.io.IOException
//import java.util.*
//
//class LoginNewActivity : CMvpActivity<LoginPresenter>(), OAuthListener, LoginConstract.View {
//    private var oauth: IDiffDevOAuth? = null
//    private var ivShow: ImageView? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        ivShow = findViewById(R.id.iv_show)
//        oauth = DiffDevOAuthFactory.getDiffDevOAuth()
//
//        findViewById<View>(R.id.bt_start).setOnClickListener {
//            wechatfirst() //在你所需要开启的地方开始调用就可以了
//        }
//
//
//        findViewById<View>(R.id.bt_re_start).setOnClickListener {
//            Timber.i("重复发起调用")
////            sign(mNoncestr, mtimeStamp, mSha)
////            Timber.i("data ${timeStamp2Date(1597212472777, yyyyMMDDHHmmss)}")
////            Timber.i("current ${System.currentTimeMillis()}")
////            Timber.i("now ${System.currentTimeMillis() - 1597230490223}")
////            Timber.i("compare ${convertSecondsToHMmSs((System.currentTimeMillis() - 1597212472777))}")
//
////            val response : BaseCount<WeChatSecond>? =null
////            var eee = response?.data?.errmsg
////            Timber.i("eee $eee response?.data  ${response?.data}")
//        }
//    }
//
//
//
//
//    override fun onDestroy() {
//        oauth!!.removeAllListeners()
//        oauth!!.detach()
//        super.onDestroy()
//    }
//
//    //第一步
//    private fun wechatfirst() {
//        val url: String = WeChatBaseUrl + WeChatLogin
//        Timber.i("第一步 $url")
////        val okHttpClient = OkHttpClient()
////        val request = Request.Builder().url(url).get().build()
////        okHttpClient.newCall(request).enqueue(object : Callback {
////            override fun onFailure(call: Call, e: IOException) {
////                Toast.makeText(this@LoginNewActivity, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show()
////            }
////
////            @Throws(IOException::class)
////            override fun onResponse(
////                call: Call,
////                response: Response
////            ) {
////                val result = response.body()!!.string()
////                val gson = Gson()
////                val resultdata =
////                    gson.fromJson(result, WeChatFirst::class.java)
////                val access_token = resultdata.access_token
////                access_token?.let { sdk_ticket(it) }
////            }
////        })
//
//        mPresenter.getImgScan()
//    }
//
//
//    //第二步
//    private fun sdk_ticket(access_token: String) {
//        val url: String =
//            WeChatBaseUrl + WeChatLoginSecond + "access_token=" + access_token + "&type=2"
//        Timber.i("第二步 $url")
//        val okHttpClient = OkHttpClient()
//        val request = Request.Builder().url(url).get().build()
//        okHttpClient.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                Toast.makeText(this@LoginNewActivity, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show()
//            }
//
//            @Throws(IOException::class)
//            override fun onResponse(
//                call: Call,
//                response: Response
//            ) {
//                val result = response.body!!.string()
//                val gson = Gson()
//                val resultdata =
//                    gson.fromJson(result, WeChatSecond::class.java)
//                val ticket = resultdata.ticket
//                val str = StringBuilder() // 定义变长字符串
//                val random = Random()
//                // 随机生成数字，并添加到字符串
////                for (int i = 0; i < 8; i++) {
////                    str.append(random.nextInt(10));
////                }
//                val noncestr = getRandomString(8)
//                val timeStamp =
//                    (System.currentTimeMillis() / 1000).toString()
//                val string1 = String.format(
//                    "appid=%s&noncestr=%s&sdk_ticket=%s&timestamp=%s",
//                    WeChatAppID,
//                    noncestr,
//                    ticket,
//                    timeStamp
//                )
//                Timber.i("第三步 $string1")
//                val sha = EncryptUtils.getSHA(string1)
//                sign(noncestr, timeStamp, sha) //签名生成
//            }
//        })
//    }
//
//
//    var mtimeStamp: String = "1597127548905"
//    var mSha: String? = "6665d835df363cc114fef47f787759ee10589fdc"
//    var mNoncestr: String = "noncestr0R6LWJ3HIK5SX2CO"
//
//    //第三步
//    override fun sign(noncestr: String, timeStamp: String, sha: String?) {
//        mtimeStamp = timeStamp
//        mSha = sha
//        mNoncestr = noncestr
//        oauth?.auth(WeChatAppID, "snsapi_userinfo", mNoncestr, mtimeStamp, mSha, this)
//    }
//
//    override fun onAuthGotQrcode(s: String?, bytes: ByteArray?) {
//        //bmp就是获取到的二维码图片
//        bytes?.let {
//            val bmp = BitmapFactory.decodeByteArray(it, 0, it.size)
//            ivShow?.setImageBitmap(bmp)
//        }
//    }
//
//    override fun onQrcodeScanned() {
//        Timber.i("onQrcodeScanned")
//    }
//
//    //第四步
//    override fun onAuthFinish(
//        oAuthErrCode: OAuthErrCode?,
//        authCode: String?
//    ) {
//        Timber.i("authCode  " + authCode)
////        if (authCode == null) return
////        val url: String = WeChatBaseUrl+WeChatLoginThird + authCode + "&grant_type=authorization_code"
////        Timber.i("第四步 $url")
////        val okHttpClient = OkHttpClient()
////        val request = Request.Builder().url(url).get().build()
////        okHttpClient.newCall(request).enqueue(object : Callback {
////            override fun onFailure(call: Call, e: IOException) {
////                Toast.makeText(this@LoginNewActivity, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show()
////            }
////
////            @Throws(IOException::class)
////            override fun onResponse(
////                call: Call,
////                response: Response
////            ) {
////                val result = response.body()!!.string()
////                val gson = Gson()
////                val resultdata =
////                    gson.fromJson(result, WeChatThird::class.java)
////                val openid = resultdata.openid
////                val access_token = resultdata.access_token
////                Timber.i("unionid ${resultdata?.unionid}")
//////                access_token?.let { userinfo(openid, it) }
////            }
////        })
//    }
//
//    //第五步
//    private fun userinfo(openid: String, access_token: String) {
//        val url: String = WeChatBaseUrl + WeChatLoginFourth + access_token + "&openid=" + openid
//        Timber.i("第五步 $url")
//        val okHttpClient = OkHttpClient()
//        val request = Request.Builder().url(url).get().build()
//        okHttpClient.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                Toast.makeText(this@LoginNewActivity, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show()
//            }
//
//            @Throws(IOException::class)
//            override fun onResponse(
//                call: Call,
//                response: Response
//            ) {
//                //微信平台返回的登录者信息
//                val result = response.body!!.string()
//                Timber.i("result $result")
//                val gson = Gson()
//                val resultdata =
//                    gson.fromJson(result, WeChatUserInfo::class.java)
//                val nickname = resultdata.nickname
//                val headimgurl = resultdata.headimgurl
//                val unionid = resultdata.unionid
//                val openid = resultdata.openid
//
//
//
////                Intent intent = new Intent(LoginNewActivity.this, MainActivity.class);
////                intent.putExtra("nickname", "" + nickname);
////                intent.putExtra("headimgurl", "" + headimgurl);
////                startActivity(intent);
////                LoginNewActivity.this.finish();
//            }
//        })
//    }
//
//    companion object {
//        private const val TIME_FORMAT = "yyyyMMddHHmmss"
//        fun getRandomString(length: Int): String {
//            val str =
//                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
//            val random = Random()
//            val sb = StringBuffer()
//            for (i in 0 until length) {
//                val number = random.nextInt(62)
//                sb.append(str[number])
//            }
//            return sb.toString()
//        }
//    }
//
//    override fun createPresenter(): LoginPresenter {
//        return LoginPresenter()
//    }
//
//    override fun setLayoutId(): Int {
//        return R.layout.activity_scan_login
//    }
//
//
//    fun convertSecondsToHMmSs(millis: Long): String? {
//        val seconds = millis / 1000 % 60
//        val minutes = millis / (1000 * 60) % 60
//        val hours = millis / (1000 * 60 * 60)
//        val b = java.lang.StringBuilder()
//        b.append(if (hours == 0L) "00" else if (hours < 10) "0$hours" else hours.toString())
//        b.append(":")
//        b.append(if (minutes == 0L) "00" else if (minutes < 10) "0$minutes" else minutes.toString())
//        b.append(":")
//        b.append(if (seconds == 0L) "00" else if (seconds < 10) "0$seconds" else seconds.toString())
//        return b.toString()
//    }
//
//}