package com.kot.tool.rx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.kot.R;
import com.kot.tool.rx.core.Emitter;
import com.kot.tool.rx.core.Observable;
import com.kot.tool.rx.core.ObservableOnSubscribe;
import com.kot.tool.rx.core.Observer;
import com.kot.tool.rx.core.scheduler.Schedulers;

public class WriteRxjavaActivity extends AppCompatActivity {

    private static final String TAG = "WriteRxjavaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_rxjava);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public void bt_write(View view) {

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(Emitter<Object> emitter) {
                Log.i(TAG, "subscribe: " + Thread.currentThread());
                emitter.onNext("aaaa");
//                emitter.onNext("bbb");
//                emitter.onNext("12312");
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observerOn(Schedulers.mainThread())


//                .flatMap(new Function<Object, ObservableSource<Object>>(){
//
//                    @Override
//                    public ObservableSource<Object> apply(Object o) {
//                        return Observable.create(new ObservableOnSubscribe<Object>() {
//                            @Override
//                            public void subscribe(Emitter<Object> emitter) {
//                                emitter.onNext("处理过后的 " + o);
//                            }
//                        });
//                    }
//                })
//
//                .map(new Function<Object, Object>() {
//                    @Override
//                    public Object apply(Object o) {
//                        Log.i(TAG, "apply: "+Thread.currentThread());
//                        return ("apply 后 1 " + o);
//                    }
//                })
//                .map(new Function<Object, Object>() {
//                    @Override
//                    public Object apply(Object o) {
//                        Log.i(TAG, "apply: " + Thread.currentThread());
//                        return ("apply 后 2 " + o);
//                    }
//                })

                .subscribe(new Observer() {
                    @Override
                    public void onNext(Object o) {
                        Log.i(TAG, "onNext: " + o + "    " + Thread.currentThread());
                    }

                    @Override
                    public void onSubscribe() {
                        Log.i(TAG, "onSubscribe: " + Thread.currentThread());

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