package com.john.kot.tool.rx.core;


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

    protected abstract void subscribeActual(Observer observer);

    //创建具体的被观察者
    public static  <T> Observable<T> create(ObservableOnSubscribe<T> source){
        return new ObservableCreate<>(source);
    }


    public <R>  ObservableMap<T, R> map(Function<T,R> function){
        return  new ObservableMap(this,function);
    }

}
