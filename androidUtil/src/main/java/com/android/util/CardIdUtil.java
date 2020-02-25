package com.android.util;

import android.text.TextUtils;

public class CardIdUtil {

    /**
     * 1 是男
     *
     * @param value
     * @return
     */
    public static String checkCardNoSex(String value) {
        if (value==null) {
            return "";
        }
        value = value.trim();
        if (value == null || (value.length() != 15 && value.length() != 18)) {
            return "1";
        }
        if (value.length() == 15 || value.length() == 18) {
            String lastValue = value.substring(value.length() - 2, value.length() - 1);
            if (value.length() == 15)
                lastValue = value.substring(value.length() - 1, value.length());
            int sex;
            if (lastValue.trim().toLowerCase().equals("x") || lastValue.trim().toLowerCase().equals("e")) {
                return "1";
            } else {
                sex = Integer.parseInt(lastValue) % 2;
                return sex == 0 ? "0" : "1";
            }
        } else {
            return "1";
        }
    }

    public static void main(String[] args) {
        System.out.println(checkCardNoSex("110101199003074135"));
    }
}
