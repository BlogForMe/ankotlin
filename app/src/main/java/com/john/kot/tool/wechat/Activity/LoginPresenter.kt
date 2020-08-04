package com.john.kot.tool.wechat.Activity

import com.android.util.base.CBasePresenter
import com.john.kot.IApiStore
import com.john.kot.tool.wechat.bean.WeChatFirst
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter : CBasePresenter<LoginConstract.View>() {

    fun getImgScan(){
        RetrofitWeChatFactory.create(IApiStore::class.java).verificationCode()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<WeChatFirst>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: WeChatFirst) {
                }

                override fun onError(e: Throwable) {
                }

            })


    }
}