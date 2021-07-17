package com.john.kot.tool.rx.core;


import com.john.kot.tool.rx.core.scheduler.Scheduler;

import timber.log.Timber;

/**
 * 把绑定和发消息分离出来 留给子类实现
 */
public abstract class Observable<T> implements ObservableSource {
    @Override
    public void subscribe(Observer observer) {
        // 把这个功能留给各种不同的Observable处理
        //比如有背压等 map , flatmap...
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    //创建具体的被观察者
    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
        return new ObservableCreate<>(source);
    }


    public <R> ObservableMap<T, R> map(Function<T, R> function) {
        return new ObservableMap(this, function);
    }

    public <R> ObservableFlatMap<T, R> flatMap(Function<T, ObservableSource<R>> function) {

        return new ObservableFlatMap(this, function);
    }

    public <R> ObservableSubscribeOn<T> subscribeOn(Scheduler scheduler) {

        return new ObservableSubscribeOn<>(this, scheduler);
    }

    public <R> ObservableObserveOn<T> observerOn(Scheduler scheduler) {

        return new ObservableObserveOn<>(this, scheduler);
    }

//    //创建具体的被观察者
//    public static  <T> Observable<T> create(ObservableOnSubscribe<T> source){
//        ObservableCreate<T> tObservableCreate = new ObservableCreate<>(source);
//
//        Timber.i("tObservableCreate " + tObservableCreate.hashCode()); // 验证当前对象
//        return tObservableCreate;
//    }
//
//
//    public <R>  ObservableMap<T, R> map(Function<T,R> function){
//        ObservableMap observableMap = new ObservableMap(this, function);
//
//        Timber.i("ObservableMap " + observableMap.hashCode());
//        return observableMap ;
//    }

}
