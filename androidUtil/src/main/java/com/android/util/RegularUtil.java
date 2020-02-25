package com.android.util;

import java.util.regex.Pattern;

public class RegularUtil {

//    public static boolean isPatientName(String name) {
//        return Pattern.matches("^[\\u4e00-\\u9fa5a-zA-Z]+$", name);
//    }

    public static boolean isPatientName(String name) {
        return Pattern.matches("\\d+", name);
    }

//    public static void main(String[] args) {
//        System.out.println(isPatientName("测试123456"));
//    }


}
