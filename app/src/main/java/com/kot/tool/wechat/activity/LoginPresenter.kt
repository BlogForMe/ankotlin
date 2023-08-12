package com.kot.tool.wechat.activity

//class LoginPresenter : CBasePresenter<LoginConstract.View>() {
//
//    fun getImgScan() {
//        val request = RetrofitWeChatFactory.create(IApiStore::class.java)
//        request.get_access_token()
//            .flatMap { request.getTicket(it.access_token, 2) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<WeChatSecond> {
//                override fun onComplete() {
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                }
//
//                override fun onNext(t: WeChatSecond) {
//                    val noncestr = LoginNewActivity.getRandomString(8)
//                    val timeStamp =
//                        (System.currentTimeMillis() / 1000).toString()
//                    t.ticket?.let {
//                        val string1 = String.format(
//                            "appid=%s&noncestr=%s&sdk_ticket=%s&timestamp=%s",
//                            WeChatAppID,
//                            noncestr,
//                            it,
//                            timeStamp
//                        )
//                        val sha = EncryptUtils.getSHA(string1)
//
//                        mvpView.sign(noncestr, timeStamp, sha)
//                    }
//                }
//
//                override fun onError(e: Throwable) {
//                }
//
//            })
//    }
//}
