package com.comm.util;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by A on 2018/3/10.
 * http://blog.csdn.net/jm_beizi/article/details/51775849
 */


public class NumberArithmeticUtils {

    /**
     * 对double 类型的浮点数进行加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {

        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
        return b1.add(b2);
    }

    /**
     * 对double 类型的浮点数进行减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double subtract(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 对double 类型的浮点数进行乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double multiply(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 对double 类型的浮点数进行除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double divide(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 保留两位小数
     * <p>
     * //     * @param bd
     *
     * @return
     */
//    public static String forMatPrice(BigDecimal bd) {
//        DecimalFormat df = new DecimalFormat("0.00");
//        return df.format(bd);
//    }
    public static String forMatPrice(String ss) {
        if (TextUtils.isEmpty(ss)) {
            return "";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(new BigDecimal(ss));
    }

    public static String forMatPrice(double d) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }

    public static String freeOrMoney(String money) {
        if (TextUtils.isEmpty(money)) {
            return "";
        }        double bd = new BigDecimal(money).doubleValue();
        if (0.0 == bd) {
            return "免费";
        } else {
            return "¥" + forMatPrice(money);
        }
    }

}