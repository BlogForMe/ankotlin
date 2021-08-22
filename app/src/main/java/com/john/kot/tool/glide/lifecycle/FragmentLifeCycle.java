package com.john.kot.tool.glide.lifecycle;

import java.util.ArrayList;
import java.util.List;

public class FragmentLifeCycle implements  Lifecycle{
    private List<LifeCycleListener> lifeCycleListeners = new ArrayList<>();

    @Override
    public void addListener(LifeCycleListener listener) {
        lifeCycleListeners.add(listener);
    }

    @Override
    public void removeListener(LifeCycleListener listener) {
        lifeCycleListeners.remove(listener);
    }

    public void onStart(){
        for (LifeCycleListener listener:lifeCycleListeners){
            listener.onStart();
        }
    }

    public void onDestroy(){
        for (LifeCycleListener listener:lifeCycleListeners){
            listener.onDestroy();
        }
    }
}
