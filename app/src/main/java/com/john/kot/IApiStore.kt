package com.john.kot

import com.john.kot.tool.wechat.bean.WeChatFirst
import com.john.kot.tool.wechat.bean.WeChatSecond
import com.john.kot.tool.wechat.util.WeChatLogin
import com.john.kot.tool.wechat.util.WeChatLoginSecond
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface IApiStore {

    @GET(WeChatLogin)
    fun get_access_token(): Observable<WeChatFirst>

    @FormUrlEncoded
    @POST(WeChatLoginSecond)
    fun getTicket(
        @Field("access_token") access_token: String,
        @Field("type") type: Int
    ):Observable<WeChatSecond>


}