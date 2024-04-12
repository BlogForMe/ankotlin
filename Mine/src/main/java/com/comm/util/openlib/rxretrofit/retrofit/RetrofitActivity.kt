package com.comm.util.openlib.rxretrofit.retrofit

import android.os.Bundle
import android.text.TextUtils
import android.util.ArrayMap
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.comm.util.R
import com.comm.util.databinding.ActivityRetrofitBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

class RetrofitActivity : AppCompatActivity() {
    var TAG = "RetrofitActivity"
    var stringBuilder: StringBuilder? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findViewById<View>(R.id.bt_search).setOnClickListener { v: View? ->
            retrofitRequest()
        }
        binding.btGetTypicode.setOnClickListener { v: View? ->
            RetrofitFactory.create(
                IApiStores::class.java
            ).getArticle(2).enqueue(
                object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>,
                    ) {
                        Log.i(TAG, "onResponse: ${response.body()}")
                    }

                    override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {}
                })
        }

        val formBody = FormBody.Builder()
            .add("userId", "1")
            .add("title", "article 2")
            .add("body", "body article")
            .build()

        binding.addArticle.setOnClickListener {
            RetrofitFactory.create(
                IApiStores::class.java
            ).addArticle(formBody).enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>,
                ) {
                    Log.i(TAG, "onResponse: ${response.body()}")
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }

            })
        }
    }

    private fun retrofitRequest() {
        val iApiStores = RetrofitFactory.create(IApiStores::class.java)
        val sharedListCall = iApiStores.getSharedList(2, 1)
        sharedListCall.enqueue(object : Callback<List<SharedListBean?>> {
            override fun onResponse(
                call: Call<List<SharedListBean?>>,
                response: Response<List<SharedListBean?>>,
            ) {
                val body = response.body()!!
                Log.i(TAG, "onResponse: $body")
            }

            override fun onFailure(call: Call<List<SharedListBean?>>, t: Throwable) {}
        })
    }

    fun okHttpRequest() {
        val okHttpClient = OkHttpClient()
        val formBody = FormBody.Builder()
            .add("city", "长沙")
            .add("key", "13cb58f5884f9749287abbead9c658f2")
            .build()
        val request = Request.Builder()
            .url("http://restapi.amap.com/v3/weather/weatherInfo")
            .post(formBody)
            .build()
        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {}

            @Throws(IOException::class)
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val res = response.body()!!.string()
                Log.i(TAG, "onResponse: $res")
            }
        })
    }

    private fun sendRxJava(txt: String) {
        val arrayMap = ArrayMap<String, Any>()
        arrayMap["city"] = "长沙"
        arrayMap["key"] = "13cb58f5884f9749287abbead9c658f2"
        arrayMap["content"] = txt
        val iApiStores = RetrofitFactory.create(IApiStores::class.java)
        iApiStores.getTTs(arrayMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { responseBody ->
                val rs = responseBody.string()
                Timber.i("rs    $rs")
                if (!TextUtils.isEmpty(rs)) {
                    val jsonObject = JSONObject(rs)
                    val wavfile = jsonObject.getString("wavfile")
                    val result = jsonObject.getString("result")
                    Timber.i("result    $result")
                    stringBuilder!!.append(result)
                        .append(",")
                }
            }
    }
}
