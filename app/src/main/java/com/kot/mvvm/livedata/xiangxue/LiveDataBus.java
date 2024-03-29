package com.kot.mvvm.livedata.xiangxue;

import java.util.Map;

import android.util.ArrayMap;

public class LiveDataBus {
    private final Map<String, BusMutableLiveData<Object>> mBus;

    private LiveDataBus() {
        mBus = new ArrayMap<>();
    }

    private static abstract class SingleHolder {
        private static final LiveDataBus DATA_BUS = new LiveDataBus();
    }

    public static LiveDataBus get() {
        return SingleHolder.DATA_BUS;
    }

    public <T> BusMutableLiveData<T> getChannel(String target, Class<T> type) {
        if (!mBus.containsKey(target)) {
            mBus.put(target, new BusMutableLiveData<>());
        }
        return (BusMutableLiveData<T>) mBus.get(target);
    }

    public BusMutableLiveData<Object> getChannel(String target) {
        return getChannel(target, Object.class);
    }
}
