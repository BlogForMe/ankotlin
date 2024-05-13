package com.kot.compose.server

import android.util.Log
import androidx.lifecycle.ViewModel
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.IOException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST
import java.security.cert.CertificateException
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


fun main() {
    PoemBookmarksReadViewModel().addArticle()
}

const val API_URL = "https://api.github.com"


class PoemBookmarksReadViewModel : ViewModel() {


    fun getArticle() {
        Retrofit.Builder().baseUrl(jsonplaceURL).client(createUnsafeOkHttpClient()).build()
            .create(IApiStores::class.java).getArticle(2)
            ?.enqueue(
                object : Callback<ResponseBody?> {
                    override fun onResponse(
                        call: Call<ResponseBody?>,
                        response: Response<ResponseBody?>,
                    ) {
                        val body = response.body()?.string()

//            Log.i("PoemBookmarksReadViewModel", "onResponse: $body")
                        println(body)
                    }

                    override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                        println(t)
                    }
                },
            )
    }


    fun addArticle() {

        val formBody = FormBody.Builder()
            .add("userId", "1")
            .add("title", "article 2")
            .add("body", "body article")
            .build()
        Retrofit.Builder().client(createUnsafeOkHttpClient()).baseUrl(jsonplaceURL).build()
            .create(IApiStores::class.java)
            .addArticle(formBody)
            ?.enqueue(
                object : Callback<ResponseBody?> {
                    override fun onResponse(
                        call: Call<ResponseBody?>,
                        response: Response<ResponseBody?>,
                    ) {
                        val body = response.body()?.string()

//            Log.i("PoemBookmarksReadViewModel", "onResponse: $body")
                    }

                    override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    }
                },
            )
    }

    fun createUnsafeOkHttpClient(): OkHttpClient {
        try {
            // Trust all certificates
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                    return arrayOf()
                }
            })

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())
            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { _: String?, _: SSLSession? -> true }
            return builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }


    fun getList() {
        Retrofit.Builder().client(createUnsafeOkHttpClient()).baseUrl(myServerURL)
            .build()
            .create(IApiStores::class.java).getList()
            ?.enqueue(
                object : Callback<ResponseBody?> {
                    override fun onResponse(
                        call: Call<ResponseBody?>,
                        response: Response<ResponseBody?>,
                    ) {
                        val body = response.body()?.string()

                        Log.i("getList", "onResponse: $body")
                    }

                    override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    }
                },
            )
    }


    fun getDetail() {
//        Retrofit.Builder().baseUrl(myServerURL)
//            .client(createUnsafeOkHttpClient()).build()
//            .create(IApiStores::class.java).getDetail()
//            ?.enqueue(
//                object : Callback<ResponseBody?> {
//                    override fun onResponse(
//                        call: Call<ResponseBody?>,
//                        response: Response<ResponseBody?>,
//                    ) {
//                        val body = response.body()?.string()
//
//                        Log.i("getDetail", "onResponse: $body")
//                    }
//
//                    override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
//                        Log.i("getDetail", "onFailure: $t ")
//                    }
//                },
//            )

        val request: Request = Request.Builder()
            .url("http://172.34.83.1:8080/poi/detail/1")
            .build()

        createUnsafeOkHttpClient().newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                println(e)
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    // Successful request
                    println("Response: ${response.body?.string()}")
                } else {
                    // Request failed
                    println("Request failed: ${response.code}")
                }
            }
        })
    }


}


interface IApiStores {

    @GET("posts/{articleId}")
    fun getArticle(@retrofit2.http.Path("articleId") it: Int): Call<ResponseBody?>?


    @POST("posts")
    fun addArticle(@retrofit2.http.Body requestBody: RequestBody?): Call<ResponseBody?>?

    @GET("posts/list")
    fun getList(): Call<ResponseBody?>?


    @GET("poi/detail/1")
    fun getDetail(): Call<ResponseBody?>?


}

val jsonplaceURL = "https://jsonplaceholder.typicoe.com/"
val myServerURL = "https://172.34.83.1:8080/"
