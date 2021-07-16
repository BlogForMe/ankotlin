package com.john.kot.tool.rx.core;

/**
 * 具体的被观察者
 */
public class ObservableCreate<T> extends Observable<T> {

    ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        observer.onSubscribe(); //订阅成功，回调给观察者
        //创建发射器
        CreateEmitter createEmitter = new CreateEmitter(observer); //发射器和观察者建立关联
        source.subscribe(createEmitter); //发射器与被观察者建立关联
    }


    static final class CreateEmitter<T> implements Emitter<T> {
        final Observer<T> observer;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable e) {
            observer.onError(e);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }
}
