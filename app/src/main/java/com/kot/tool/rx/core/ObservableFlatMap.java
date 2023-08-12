package com.kot.tool.rx.core;


public class ObservableFlatMap<T, U> extends AbstractObservableWithUpStream<T, U> {

     Function<T, ObservableSource<U>> function;

    public ObservableFlatMap(ObservableSource<T> source, Function<T, ObservableSource<U>> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer observer) {         // source上层Observable,
        source.subscribe(new MergeObserver(observer, function)); //传入的observer一直都是是下层的observer
    }

    /**
     * 持有下游的引用
     *
     * @param <T>
     * @param <U>
     */
    static final class MergeObserver<T, U> implements Observer<T> {

        protected final Observer<U> downStream; //下游的观察者
        final Function<T, ObservableSource<U>> mapper;

        // 参数downStream就是下游的observer

        public MergeObserver(Observer<U> downStream, Function<T, ObservableSource<U>> mapper) {
            this.downStream = downStream;
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            ObservableSource<U> observable = mapper.apply(t);//数据变换， 如何变由用户实现
            observable.subscribe(new Observer<U>() {

                @Override
                public void onNext(U u) {
                    downStream.onNext(u);
                }

                @Override
                public void onSubscribe() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
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


}
