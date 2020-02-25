package com.comm.util.rx;

import com.comm.util.AppUtil;
import com.comm.util.pro.Constant;
import com.comm.util.pro.SharedPreferencesUtils;

import java.io.IOException;

import main.CertificationEntrance;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

import static android.text.TextUtils.isEmpty;
import static com.comm.util.pro.Constant.SHARE_TOKEN_KEY;

public class CommParamsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request requestPre = chain.request();
        Request.Builder builder = requestPre.newBuilder()
                .addHeader("operate_way", "0");
        String mSessionId = (String) SharedPreferencesUtils.getParam(AppUtil.getApp(), SHARE_TOKEN_KEY, "");
//        Timber.i("mSessionId    " + mSessionId);
//        if (!isEmpty(mSessionId)) {
//            requestPre.url().newBuilder().addQueryParameter("token", CertificationEntrance.generateDynamicTokenToApp(mSessionId));
//        }
        String s = AppUtil.getApp().getPackageName();
        if (s != null)
            builder.addHeader("version", s);
        String boxId = (String) SharedPreferencesUtils.getParam(AppUtil.getApp(), Constant.SHARE_BOXID, "");

        if (boxId != null) {
            builder.addHeader("box_id", boxId);
        }
        return chain.proceed(builder.build());
    }
}
