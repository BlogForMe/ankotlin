package com.john.kot.tool.rx.core;


/**
 *  发射器发送消息，发给观察者
 *
 *  给用户发消息用的接口
 * @param <T>
 */
public interface Emitter<T> {
    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}
