package com.john.kot.tool.wechat.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.john.kot.R;
import com.john.kot.tool.wechat.bean.WeChatFirst;
import com.john.kot.tool.wechat.bean.WeChatSecond;
import com.john.kot.tool.wechat.bean.WeChatThird;
import com.john.kot.tool.wechat.bean.WeChatUserInfo;
import com.john.kot.tool.wechat.util.EncryptUtils;
import com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

import java.io.IOException;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

import static com.john.kot.tool.wechat.util.MyApiUtilKt.WeChatAppID;
import static com.john.kot.tool.wechat.util.MyApiUtilKt.WeChatLogin;
import static com.john.kot.tool.wechat.util.MyApiUtilKt.WeChatLoginFourth;
import static com.john.kot.tool.wechat.util.MyApiUtilKt.WeChatLoginSecond;
import static com.john.kot.tool.wechat.util.MyApiUtilKt.WeChatLoginThird;

public class LoginNewActivity extends AppCompatActivity implements OAuthListener {

    private IDiffDevOAuth oauth;
    private static final String TIME_FORMAT = "yyyyMMddHHmmss";
    private ImageView ivShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_login);

        ivShow=findViewById(R.id.iv_show);

        oauth = DiffDevOAuthFactory.getDiffDevOAuth();


        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wechatfirst();  //在你所需要开启的地方开始调用就可以了
            }
        });
    }

    @Override
    protected void onDestroy() {
        oauth.removeAllListeners();
        oauth.detach();
        super.onDestroy();
    }

    //第一步
    private void wechatfirst() {
        String url = WeChatLogin;
        Timber.i("第一步 " + url);

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Toast.makeText(LoginNewActivity.this, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                WeChatFirst resultdata = gson.fromJson(result, WeChatFirst.class);
                String access_token = resultdata.getAccess_token();
                if (access_token != null) {
                    sdk_ticket(access_token);
                }

            }
        });

    }

    //第二步
    private void sdk_ticket(String access_token) {
        String url = WeChatLoginSecond + "access_token=" + access_token + "&type=2";
        Timber.i("第二步 " + url);

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(LoginNewActivity.this, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                WeChatSecond resultdata = gson.fromJson(result, WeChatSecond.class);
                String ticket = resultdata.getTicket();

                StringBuilder str = new StringBuilder();// 定义变长字符串
                Random random = new Random();
                // 随机生成数字，并添加到字符串
//                for (int i = 0; i < 8; i++) {
//                    str.append(random.nextInt(10));
//                }
                String noncestr = getRandomString(8);
//                String timeStamp = new SimpleDateFormat(TIME_FORMAT).format(new Date());
                String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);

                String string1 = String.format("appid=%s&noncestr=%s&sdk_ticket=%s&timestamp=%s", WeChatAppID,noncestr, ticket, timeStamp);

                Timber.i("第三步 " + string1);
                String sha = EncryptUtils.getSHA(string1);
                sign(noncestr, timeStamp, sha); //签名生成


            }
        });
    }

    //第三步
    private void sign(String noncestr, String timeStamp, String sha) {
        oauth.auth(WeChatAppID, "snsapi_userinfo", noncestr, timeStamp, sha, this);

    }

    @Override
    public void onAuthGotQrcode(String s, byte[] bytes) {
        //bmp就是获取到的二维码图片
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        ivShow.setImageBitmap(bmp);
    }

    @Override
    public void onQrcodeScanned() {
        Timber.i("onQrcodeScanned");
    }

    //第四步
    @Override
    public void onAuthFinish(OAuthErrCode oAuthErrCode, String authCode) {
        if (authCode == null) return;
        String url = WeChatLoginThird + authCode + "&grant_type=authorization_code";
        Timber.i("第四步 " + url);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Toast.makeText(LoginNewActivity.this, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                WeChatThird resultdata = gson.fromJson(result, WeChatThird.class);
                String openid = resultdata.getOpenid();
                String access_token = resultdata.getAccess_token();
                if (access_token != null) {
                    userinfo(openid, access_token);
                }
            }
        });
    }

    //第五步
    private void userinfo(String openid, String access_token) {
        String url = WeChatLoginFourth + access_token + "&openid=" + openid;
        Timber.i("第五步 " + url);

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Toast.makeText(LoginNewActivity.this, "网络请求失败，请检查网络", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //微信平台返回的登录者信息
                String result = response.body().string();
                Timber.i("result "+result);
                Gson gson = new Gson();
                WeChatUserInfo resultdata = gson.fromJson(result, WeChatUserInfo.class);
                String nickname = resultdata.getNickname();
                String headimgurl = resultdata.getHeadimgurl();
                String unionid = resultdata.getUnionid();
                String openid = resultdata.getOpenid();

//                Intent intent = new Intent(LoginNewActivity.this, MainActivity.class);
//                intent.putExtra("nickname", "" + nickname);
//                intent.putExtra("headimgurl", "" + headimgurl);
//                startActivity(intent);
//                LoginNewActivity.this.finish();
            }
        });
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
