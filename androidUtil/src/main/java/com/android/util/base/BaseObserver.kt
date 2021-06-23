package com.android.util.base

import androidx.lifecycle.MutableLiveData
import com.android.util.bean.BaseCount
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class BaseObserver<T :BaseCount<*>>(
        private val liveData: MutableLiveData<T>) : Observer<T> {

    override fun onComplete() {
    }


    override fun onNext(response: T) {
        liveData.value = response
    }

    override fun onError(e: Throwable) {

    }

    override fun onSubscribe(d: Disposable) {
    }

}