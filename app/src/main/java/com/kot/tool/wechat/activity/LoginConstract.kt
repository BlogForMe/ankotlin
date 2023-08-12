package com.kot.tool.wechat.activity

import com.android.util.base.BaseView

interface LoginConstract {
    interface  View : BaseView{
         fun sign(noncestr: String, timeStamp: String, sha: String?)

    }

    interface Presenter {

    }

}