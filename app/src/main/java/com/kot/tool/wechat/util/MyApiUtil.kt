package com.kot.tool.wechat.util


//微信登录AppID
//const val WeChatAppID = "wx2841108fec4a7b2b"
//
////微信登录AppSecret
//const val WeChatAppSecret = "9e3fce5337699f81a72872e5e8fd7d9f"

//微信登录AppID
const val WeChatAppID = "wxfae652f72622727b"

//微信登录AppSecret
const val WeChatAppSecret = "1cd498be3a446798ed9795a80bc445c8"


//https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html
//微信登录-First
const val WeChatLogin =
    "cgi-bin/token?grant_type=client_credential&appid=${WeChatAppID}&secret=${WeChatAppSecret}"

//微信登录-Second
const val WeChatLoginSecond = "cgi-bin/ticket/getticket"

//微信登录-Third
const val WeChatLoginThird =
    "sns/oauth2/access_token?appid=${WeChatAppID}&secret=${WeChatAppSecret}&code="

//微信登录-Fourth
const val WeChatLoginFourth = "sns/userinfo?access_token="

const val WeChatBaseUrl = "https://api.weixin.qq.com/"

