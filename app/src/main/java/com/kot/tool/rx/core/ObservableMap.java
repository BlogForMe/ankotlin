package com.kot.tool.rx.core;


public class ObservableMap<T, U> extends AbstractObservableWithUpStream<T, U> {

    final Function<T, U> function;

    public ObservableMap(ObservableSource source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer observer) {         // source上层Observable,
        source.subscribe(new MapObserver(observer, function)); //传入的observer一直都是是下层的observer
    }

    /**
     * 持有下游的引用
     *
     * @param <T>
     * @param <U>
     */
    static final class MapObserver<T, U> implements Observer<T> {

        protected final Observer<U> downStream; //下游的观察者
        final Function<T, U> mapper;

        // 参数downStream就是下游的observer
        public MapObserver(Observer<U> downStream, Function<T, U> mapper) {
            this.downStream = downStream;
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            U apply = mapper.apply(t); //数据变换， 如何变由用户实现
            downStream.onNext(apply); //持有下游的observer,向下游传递数据
        }

        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
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
