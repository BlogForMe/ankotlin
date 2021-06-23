package com.android.util;

import android.content.Context;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by A on 2018/2/1.
 */

public class ToastUtil {

    public static Context mContext;

    public static void register(Context context) {
        mContext = context.getApplicationContext();
    }

    public static void check() {
        if (mContext == null) {
            throw new NullPointerException(" Must initial call ToastUtils.register(Context context) in your  +\n" +
                    "                            <?  +\n" +
                    "                            extends Application class>");
        }
    }

//    public static void showShort(String message) {
//        check();
//        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
//    }

    public static void showBiggerText(String message){
        check();
        Toast toast = Toast.makeText(mContext,message,Toast.LENGTH_LONG);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView tostTV= (TextView) toastLayout.getChildAt(0);
        tostTV.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        toast.show();
    }
    public static void showShort(String message){
        check();
        Toast toast = Toast.makeText(mContext,message,Toast.LENGTH_SHORT);
        toast.show();
    }

}
