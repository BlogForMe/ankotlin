package com.kot.tool.rx.core.scheduler;

public abstract class Scheduler {
    public  abstract  Worker createWorker();

    public interface  Worker{
        void schedule(Runnable runnable);
    }
}
