package com.kot.tool.rx.core;

/**
 * 绑定发射器 被观察者和发射器建立关联
 * @param <T>
 */
public interface ObservableOnSubscribe<T> {
    void subscribe(Emitter<T> emitter);
}
