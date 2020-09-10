package com.john.kot.tool.wechat.Activity

import com.android.util.base.BaseView

interface LoginConstract {
    interface  View : BaseView{
         fun sign(noncestr: String, timeStamp: String, sha: String?)

    }

    interface Presenter {

    }

}