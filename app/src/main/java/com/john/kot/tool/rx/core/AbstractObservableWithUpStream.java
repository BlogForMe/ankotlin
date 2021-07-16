package com.john.kot.tool.rx.core;

//装饰器类
public abstract class AbstractObservableWithUpStream<T,U> extends Observable {
    protected final ObservableSource source; //上游被观察者

    public AbstractObservableWithUpStream(ObservableSource source) {
        this.source = source;
    }
}
