package com.kot.tool.rx.core;

//装饰器类
public abstract class AbstractObservableWithUpStream<T,U> extends Observable<T> {
    protected final ObservableSource source; //上游被观察者

    public AbstractObservableWithUpStream(ObservableSource source) {
        this.source = source;
//        Timber.i("source "  +source.hashCode()); //验证当前对象是否是上一级Observable
    }
}
