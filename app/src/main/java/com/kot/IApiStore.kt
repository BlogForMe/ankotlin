package com.kot

import com.kot.tool.wechat.util.WeChatLogin
import com.kot.tool.wechat.util.WeChatLoginSecond
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface IApiStore {

    @GET(WeChatLogin)
    fun get_access_token(): Observable<com.kot.tool.wechat.bean.WeChatFirst>

    @FormUrlEncoded
    @POST(WeChatLoginSecond)
    fun getTicket(
        @Field("access_token") access_token: String,
        @Field("type") type: Int
    ): Observable<com.kot.tool.wechat.bean.WeChatSecond>


}