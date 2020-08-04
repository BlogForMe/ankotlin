package com.john.kot

import com.john.kot.tool.wechat.bean.WeChatFirst
import com.john.kot.tool.wechat.util.WeChatLogin
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET

interface IApiStore {

    @GET(WeChatLogin)
    fun verificationCode(): Observable<WeChatFirst>
}