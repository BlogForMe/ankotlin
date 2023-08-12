package com.kot.tool.glide.lifecycle;

//生命周期的被观察者
public interface Lifecycle {
    void addListener(LifeCycleListener listener);
    void removeListener(LifeCycleListener listener);
}
