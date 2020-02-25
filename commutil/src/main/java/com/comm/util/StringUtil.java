package com.comm.util;

import java.math.BigDecimal;
import java.util.List;

import static android.text.TextUtils.isEmpty;
import static com.comm.util.pro.StringUtil.RESULT_HIGH;
import static com.comm.util.pro.StringUtil.RESULT_LOW;
import static com.comm.util.pro.StringUtil.RESULT_NORMAL;

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


    public static String getRemoteTxt(int rmStates) {
        String txt = "";
        switch (rmStates) {
            case 0:
                txt = "未开始";
                break;
            case 1:
                txt = "问卷准备";
                break;
            case 2:
                txt = "检查进行中";
                break;
            case 3:
                txt = "报告编辑";
                break;
            case 4:
                txt = "检查完毕";
                break;
            case 5:
                txt = "已取消";
                break;
        }
        return txt;
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

    public String getDateRange(String mealStatus, Double dataValue, int timeInterval) {
        String conclusion = "";
        if ("BLOOD_GLUCOSE_AM".equals(mealStatus) || "SLEEP_AM".equals(mealStatus)) {
            if (dataValue <= 3.9) {
                conclusion = "rel_low";
            } else if (dataValue <= 7.0 && dataValue > 3.9) {
                conclusion = "normal";
            } else if (dataValue > 7.0 && dataValue <= 8.4) {
                conclusion = "rel_high";
            } else if (dataValue > 8.4) {
                conclusion = "very_high";
            }
        }
        return conclusion;
    }

    /**
     * 和两个数比较
     *
     * @param dataValue
     * @param array
     * @return
     */
    public static String twoDoubleRange(Double dataValue, double[] array) {
        String conclusion = "";
        if (dataValue < array[0]) {
            conclusion = RESULT_LOW;
        } else if (dataValue >= array[0] && dataValue < array[1]) {
            conclusion = RESULT_NORMAL;
        } else if (dataValue > array[1]) {
            conclusion = RESULT_HIGH;
        }
        return conclusion;
    }

    public static String getTwoIntRange(int dataValue, int[] array) {
        String conclusion = "";
        if (dataValue < array[0]) {
            conclusion = RESULT_LOW;
        } else if (dataValue >= array[0] && dataValue < array[1]) {
            conclusion = RESULT_NORMAL;
        } else if (dataValue > array[1]) {
            conclusion = RESULT_HIGH;
        }
        return conclusion;
    }

    public static String getCheckDateConclusion(String mealStatus, Double dataValue, int timeInterval) {
        String conclusion = "";
        if ("BLOOD_GLUCOSE_AM".equals(mealStatus) || "SLEEP_AM".equals(mealStatus)) {
            if (dataValue <= 3.9) {
                conclusion = "rel_low";
            } else if (dataValue <= 7.0 && dataValue > 3.9) {
                conclusion = "normal";
            } else if (dataValue > 7.0 && dataValue <= 8.4) {
                conclusion = "rel_high";
            } else if (dataValue > 8.4) {
                conclusion = "very_high";
            }
        } else {
            if (timeInterval == 1) {
                if (dataValue <= 3.9) {
                    conclusion = "rel_low";
                } else if (dataValue <= 9.4 && dataValue > 3.9) {
                    conclusion = "normal";
                } else if (dataValue > 9.4 && dataValue <= 11.1) {
                    conclusion = "rel_high";
                } else if (dataValue > 11.1) {
                    conclusion = "very_high";
                }
            } else if (timeInterval == 2) {
                if (dataValue <= 3.9) {
                    conclusion = "rel_low";
                } else if (dataValue <= 7.8 && dataValue > 3.9) {
                    conclusion = "normal";
                } else if (dataValue > 7.8 && dataValue <= 11.1) {
                    conclusion = "rel_high";
                } else if (dataValue > 11.1) {
                    conclusion = "very_high";
                }
            }
        }
        return conclusion;
    }


    public static boolean isListEmpty(List<?> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }


}
