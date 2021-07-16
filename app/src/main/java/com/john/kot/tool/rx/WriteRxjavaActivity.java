package com.john.kot.tool.rx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.john.kot.R;
import com.john.kot.tool.rx.core.Emitter;
import com.john.kot.tool.rx.core.Function;
import com.john.kot.tool.rx.core.Observable;
import com.john.kot.tool.rx.core.ObservableOnSubscribe;
import com.john.kot.tool.rx.core.Observer;

public class WriteRxjavaActivity extends AppCompatActivity {

    private static final String TAG = "WriteRxjavaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_rxjava);
    }

    public void bt_write(View view) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(Emitter<Object> emitter) {
                Log.i(TAG, "subscribe: ");
                emitter.onNext("aaaa");
                emitter.onNext("bbb");
                emitter.onNext("12312");
                emitter.onComplete();
            }
        })
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) {
                        return ("apply 后 1 " + o);
                    }
                })
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) {
                        return ("apply 后 2 " + o);
                    }
                })

                .subscribe(new Observer() {
                    @Override
                    public void onNext(Object o) {
                        Log.i(TAG, "onNext: " + o);
                    }

                    @Override
                    public void onSubscribe() {
                        Log.i(TAG, "onSubscribe: ");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ");
                    }
                });
    }


}