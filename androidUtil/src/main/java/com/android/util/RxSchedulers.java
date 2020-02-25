package com.android.util;

/**
 * Created by jon on 3/25/18.
 */

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 通用的Rx线程转换类
 * https://github.com/amitshekhariitbhu/RxJava2-Android-Samples/blob/60231d1c1609f711f1537becc187fc6ae2894922/app/src/main/java/com/rxjava2/android/samples/ui/compose/RxSchedulers.java
 * 参考:http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0819/3327.html
 */
public class RxSchedulers {


    static final ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return (upstream).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };


    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }

//    public static <T> ObservableSource<BaseCount<SingleBean>> static FF(){
//           flatMap(new Function<BaseCount<SingleBean>, ObservableSource<BaseCount<SingleBean>>>() {
//
//            @Override
//            public ObservableSource<BaseCount<SingleBean>> apply(BaseCount<SingleBean> singleBeanBaseCount) throws Exception {
//                if (singleBeanBaseCount.getMeta().getStatusCode()!=0){
//                    return Observable.error(new Exception());
//                }
//                return  Observable.just(singleBeanBaseCount);
//            }
//        })
//    }
}
