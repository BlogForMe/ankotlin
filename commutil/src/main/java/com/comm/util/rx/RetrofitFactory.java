package com.comm.util.rx;


import com.comm.util.AppUtil;
import com.comm.util.BuildConfig;
import com.comm.util.SharedPrefsUtils;
import com.comm.util.pro.Constant;
import com.comm.util.pro.SharedPreferencesUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import main.CertificationEntrance;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static android.text.TextUtils.isEmpty;
import static com.comm.util.SharedPrefsUtils.CONFIG_USER;
import static com.comm.util.SharedPrefsUtils.CONSTANT_URL;
import static com.comm.util.SharedPrefsUtils.DEFAULT_URL;
import static com.comm.util.SharedPrefsUtils.INFORMATION_URL;
import static com.comm.util.SharedPrefsUtils.KEY_HOST;
import static com.comm.util.SharedPrefsUtils.SPEANK_ADDR_SOUTHERN_FUJIAN_DIALECT;
import static com.comm.util.pro.Constant.SHARE_TOKEN_KEY;


/**
 * Created by jon on 3/25/18.
 */

public class RetrofitFactory {


    private static long CONNECT_TIMEOUT = 60L;
    private static long READ_TIMEOUT = 40L;
    private static long WRITE_TIMEOUT = 40L;
    //设缓存有效期为1天
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    public static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置
    //(假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)
    public static final String CACHE_CONTROL_NETWORK = "Cache-Control: public, max-age=10";
    // 避免出现 HTTP 403 Forbidden，参考：http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser
    private static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
    private static volatile OkHttpClient mOkHttpClient;

    public static String CONFIG_URL = "https://registry.casanubeserver.com/";
    public static String MINAN_URL = "http://125.77.202.194:9396/";

    /**
     * 获取OkHttpClient实例
     *
     * @return
     */
    private static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitFactory.class) {
//                Cache cache = new Cache(new File(App.getAppContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 100);
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    //设置Debug Log模式
                    builder.addInterceptor(loggingInterceptor);
                }
                mOkHttpClient = builder
                        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                        .addInterceptor(new CommParamsInterceptor())
                        .build();
            }
        }
        return mOkHttpClient;
    }

    public static String getUrl() {
        SharedPrefsUtils spUtil = new SharedPrefsUtils(CONFIG_USER);
        String baseUrl = (spUtil.getString(KEY_HOST, DEFAULT_URL));
//        if (BuildConfig.DEBUG){
//            return  DEV_URL;
//        }
        return baseUrl;
    }


    /**
     * 咨询模块
     *
     * @return
     */
    public static String getInfoUrl() {
        SharedPrefsUtils spUtil = new SharedPrefsUtils(CONFIG_USER);
        String baseUrl = (spUtil.getString(INFORMATION_URL, DEFAULT_URL) + CONSTANT_URL);
        return baseUrl;

    }

    /**
     * 咨询Web页面
     *
     * @return
     */
    public static String getInfoWeb() {
        SharedPrefsUtils spUtil = new SharedPrefsUtils(CONFIG_USER);
        String baseUrl = spUtil.getString(INFORMATION_URL, DEFAULT_URL);
        return baseUrl;
    }


    public static String getMinanUrl() {
        SharedPrefsUtils spUtil = new SharedPrefsUtils(CONFIG_USER);
        String baseUrl = spUtil.getString(SPEANK_ADDR_SOUTHERN_FUJIAN_DIALECT, MINAN_URL);
        return baseUrl;
    }

    /**
     * 获取Service
     * 血糖足是不用 COMMON_PATH，放在地址里面
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> clazz) {
        String baseUrl = (getUrl() + CONSTANT_URL);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl) //geturl其他地方用
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(clazz);
    }

    /**
     * 咨询使用
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T createNew(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl((getInfoUrl()))
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(clazz);
    }

    public static <T> T createMinan(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getMinanUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(clazz);
    }


//    public static <T> T configRetrofitService(Class<T> clazz) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(CONFIG_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(getOkHttpClient())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
//        return retrofit.create(clazz);
//    }


}
