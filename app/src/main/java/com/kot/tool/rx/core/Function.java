package com.kot.tool.rx.core;

/**
 * 事件变换
 * @param <T>
 * @param <R>
 */
public interface Function<T,R> {
    R apply(T t);
}
