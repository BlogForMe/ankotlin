package com.kot.tool.rx.core;

import com.kot.tool.rx.core.scheduler.Scheduler;

public class ObservableSubscribeOn<T> extends  AbstractObservableWithUpStream<T,T>{
    final Scheduler scheduler;

    public ObservableSubscribeOn(ObservableSource<T> source,Scheduler scheduler) {
        super(source);
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
        Scheduler.Worker worker = scheduler.createWorker();
        worker.schedule(new SubscribeTask(new SubscribeObserver<>(observer)));
    }

    class SubscribeObserver<T> implements  Observer<T>{
        final Observer<T> downStream;

        public SubscribeObserver(Observer<T> downStream) {
            this.downStream = downStream;
        }

        @Override
        public void onNext(T t) {
            downStream.onNext(t);
        }

        @Override
        public void onSubscribe() {
        }

        @Override
        public void onError(Throwable e) {
            downStream.onError(e);
        }

        @Override
        public void onComplete() {
            downStream.onComplete();
        }
    }

    final class SubscribeTask implements Runnable{
         final SubscribeObserver<T> parent;

        public SubscribeTask(SubscribeObserver<T> parent) {
            this.parent = parent;
        }

        @Override
        public void run() {
            source.subscribe(parent);
        }
    }

}
