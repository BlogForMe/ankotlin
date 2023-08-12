package com.kot.tool.rx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.IApiStore
import com.john.kot.R
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class RxJavaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)


//        bt_rx.setOnClickListener {
//            Observable.interval(1,TimeUnit.SECONDS)
//                .subscribe{
//                    getData()
//                }
//        }
    }


    var cacheData = null
    private fun getData() {
        var localObserver = Observable.create(ObservableOnSubscribe<String> { emitter ->
            cacheData?.let {
                emitter.onNext(it)
            }
            emitter.onComplete()
        }).subscribeOn(Schedulers.io())

        var remoteDataObservable: Observable<String>? =
            com.kot.tool.wechat.activity.RetrofitWeChatFactory.create(IApiStore::class.java)
                .get_access_token()
                .subscribeOn(Schedulers.io())
                .map {
                    System.currentTimeMillis().toString()
                }


        // 使用contact操作符将两个事件串联起来，当上述的onComplete执行过后，就会开始进行网络请求
        Observable.concat(localObserver, remoteDataObservable)
            .observeOn(
                AndroidSchedulers.mainThread(),
                true
            ) // 这里delayError设为true，防止onNext在下游还没消费完，就被onComplete结束掉了
            .throttleFirst(5,TimeUnit.SECONDS)
            .subscribe(
                Consumer {
                    Timber.i("输出 $it")
                }
                ,
                Consumer { throwable: Throwable? -> }
            )
    }


}