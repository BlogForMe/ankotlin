package com.comm.util.rx;

import android.text.TextUtils;

import com.comm.util.BuildConfig;
import com.comm.util.ToastUtil;
import com.comm.util.bean.BaseCount;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;
import timber.log.Timber;

import static android.text.TextUtils.isEmpty;

/**
 * @author : John
 * @date : 2018/7/28
 */
public abstract class DefaultObserver<T> extends DisposableObserver<T> {


    @Override
    public void onNext(T response) {
        if (parseData(response)) {
            onSuccess(response);
            onFinish();
        }
    }

    @Override
    public void onError(Throwable e) {

        Timber.i("onError " + e.getMessage());
        if (e instanceof HttpException) {     //   HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {   //   连接错误
            onException(ExceptionReason.CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {   //  连接超时
            onException(ExceptionReason.CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //  解析错误
            onException(ExceptionReason.PARSE_ERROR);
        }/* else if (e instanceof ServerResponseException) {
            onFail(e.getMessage());
        }*/ else {
            onException(ExceptionReason.UNKNOWN_ERROR);
        }
        onFinish();
        Timber.e("异常" + e.getMessage());
    }

    @Override
    public void onComplete() {
    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    public abstract void onSuccess(T response);

    /**
     * 服务器返回数据，但响应码不为200
     */
    public void onFail(String message) {
        ToastUtil.showBiggerText(message);
    }

    public void onFinish() {
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtil.showBiggerText("当前智能终端网络已断开，请检查网络或联系客服：0755-8672 4350");
                break;

            case CONNECT_TIMEOUT:
                ToastUtil.showBiggerText("解析数据失败");
                break;

            case BAD_NETWORK:
                ToastUtil.showBiggerText("网络问题");
                break;

            case PARSE_ERROR:
                ToastUtil.showBiggerText("解析数据失败");
                break;

            case UNKNOWN_ERROR:
            default:
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }


    private boolean parseData(T t) {
        if (t instanceof BaseCount) {
            BaseCount bs = (BaseCount) t;
            if (bs.getMeta().getStatusCode() == 0) {
                return true;
            } else if (bs.getMeta().getStatusCode() == -1) {
                if (/*BuildConfig.DEBUG && */!isEmpty(bs.getMeta().getDescribe())) {
                    ToastUtil.showBiggerText(bs.getMeta().getDescribe());
                } else {
                    ToastUtil.showBiggerText("操作异常，请联系客服处理");
                }
            }
        }
        return false;
    }
}
