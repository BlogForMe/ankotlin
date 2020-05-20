package com.android.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /* public static void main(String[] args) {
         System.out.println(getPatientTitleName("周互", 1));
         System.out.println(getPatientTitleName("000022", 1));
         System.out.println(getPatientSpeak("周互", 1));
         System.out.println(getPatientSpeak("000022", 1));

     }
 */
    public static String PatternEdit = "[\\u4e00-\\u9fa5]+"; //匹配汉字
    public static String PattrenInteger = "^[1-9]\\d*|0$";//匹配整数

    public static String getPatientTitleName(String patientName, int sex) {
        if (!RegularUtil.isPatientName(patientName)) {
            return patientName;
        }
        return sex == 1 ? "叔叔" : "阿姨";
    }

    public static String getPatientSpeak(String patientName, int sex) {
        String sexTxt = sex == 1 ? "叔叔" : "阿姨";
        if (!RegularUtil.isPatientName(patientName)) {
            return patientName + sexTxt;
        }
        return sexTxt;
    }

    /**
     * 判断字符是否是汉字
     * <p>
     * https://blog.csdn.net/qq_28585471/article/details/76056625
     *
     * @param c 字符
     * @return 是否是汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

        // if(c>255){
        // return true;
        // }

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }


    public static float floatOne(float fl) {
        BigDecimal bd = new BigDecimal(fl);
        BigDecimal nf = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
        return nf.floatValue();
    }


    /**
     * 保留两位小数
     *
     * @param value
     * @return
     */
    public static double decimalTwoPlace(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        double f2 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f2;
    }

    /**
     * 保留1位小数
     *
     * @param value
     * @return
     */
    public static double decimalOnePlace(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        double f2 = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f2;
    }

    /**
     * 取整
     *
     * @param value
     * @return
     */
    public static int doubleToInt(double value) {
        int dti = new BigDecimal(2.7875).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        return dti;
    }


    public static boolean isListEmpty(List<?> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }


    /**
     * 中文转码
     * @param url
     * @param chartSet
     * @return
     */
    public static String encodeChinese(String url, String chartSet) {
        try {
            Matcher matcher = Pattern.compile("[^\\x00-\\xff]").matcher(url);//双字节,包括中文和中文符号[^\x00-\xff]  中文[\u4e00-\u9fa5]
            while (matcher.find()) {
                String tmp = matcher.group();
                url = url.replaceAll(tmp, java.net.URLEncoder.encode(tmp, chartSet));
            }
        } catch (UnsupportedEncodingException e) {
        }
        return url;
    }


}
