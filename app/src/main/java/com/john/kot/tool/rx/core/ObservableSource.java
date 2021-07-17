package com.john.kot.tool.rx.core;

/**
 * 抽象被观察者
 */
public interface ObservableSource<T> {
    //订阅功能 绑定Observable与Observer关联
    public void subscribe(Observer observer);
}
