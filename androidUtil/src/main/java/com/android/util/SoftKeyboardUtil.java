package com.android.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * 作者：戴维尼老爷爷
 * 链接：https://juejin.im/post/58d8ccb45c497d005702dae6
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 第二个方法的 List<View> viewList 参数是什么， viewList 中需要放的是当前界面所有触发软键盘弹出的控件。
 * 比如一个登陆界面， 有一个账号输入框和一个密码输入框， 需要隐藏键盘的时候，
 * 就将两个输入框对象放在 viewList 中， 作为参数传到 hideSoftKeyboard 方法中即可。
 */

public class SoftKeyboardUtil {
    /**
     * 隐藏软键盘(只适用于Activity，不适用于Fragment)
     */
    public static void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 隐藏软键盘(可用于Activity，Fragment)
     */
    public static void hideSoftKeyboard(Context context, List<View> viewList) {
        if (viewList == null) return;

        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        for (View v : viewList) {
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
