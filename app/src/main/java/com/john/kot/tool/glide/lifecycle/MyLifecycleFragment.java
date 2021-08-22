package com.john.kot.tool.glide.lifecycle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyLifecycleFragment  extends Fragment {
    FragmentLifeCycle fragmentLifeCycle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentLifeCycle = new FragmentLifeCycle();
    }

    public MyLifecycleFragment() {
    }

    public FragmentLifeCycle getFragmentLifeCycle() {
        return fragmentLifeCycle;
    }

    @Override
    public void onStart() {
        super.onStart();
        fragmentLifeCycle.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentLifeCycle.onDestroy();
    }
}
