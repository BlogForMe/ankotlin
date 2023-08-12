package com.kot.tool.rx.core;

import java.util.ArrayDeque;
import java.util.Deque;

import com.kot.tool.rx.core.scheduler.Scheduler;

public class ObservableObserveOn<T> extends AbstractObservableWithUpStream<T, T> {

    final Scheduler scheduler;

    public ObservableObserveOn(ObservableSource source, Scheduler scheduler) {
        super(source);
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
        Scheduler.Worker worker = scheduler.createWorker();
        source.subscribe(new ObserveOnObserver(observer, worker));
    }


    static final class ObserveOnObserver<T> implements Observer<T>, Runnable {
        final Observer<T> downStream;
        final Scheduler.Worker worker;
        final Deque<T> queue;

        volatile boolean done;
        volatile Throwable error;
        volatile boolean over;

        public ObserveOnObserver(Observer<T> downStream, Scheduler.Worker worker) {
            this.downStream = downStream;
            this.worker = worker;
            this.queue = new ArrayDeque<>();
        }

        @Override
        public void onNext(T t) {
            queue.offer(t); //把事件加入队列,off不会抛出异常,只会返回false
            schedule();
        }

        private void schedule() {
            worker.schedule(this);
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

        @Override
        public void run() {
            drainNormal();
        }

        //从队列中排放事件并处理
        private void drainNormal() {
            final Deque<T> q = queue;
            final Observer<T> a = downStream;
            while (true) {
                boolean d = done;
                T t = q.poll(); // 取出数据，没有数据的时候不会抛异常，返回null
                boolean empty = t == null;
                if (checkTerminated(d, empty, a)) {
                    return;
                }
                if (empty) {
                    break;
                }
                a.onNext(t);
            }
        }
        // 判断执行终止
        private boolean checkTerminated(boolean d, boolean empty, Observer<T> a) {
            if (over) {
                queue.clear();
                return true;
            }
            if (d) {
                Throwable e = error;
                if (e != null) {
                    over = true;
                    a.onError(error);
                    return true;
                } else if (empty) {
                    over = true;
                    a.onComplete();
                    return true;
                }
            }
            return false;
        }
    }
}
