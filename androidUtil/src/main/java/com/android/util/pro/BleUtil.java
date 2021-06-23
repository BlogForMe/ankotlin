package com.android.util.pro;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by zxx on 2016/7/19.
 */
public class BleUtil {

    private static BleUtil INSTANCE;

    private BleUtil() {
    }

    public static BleUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (BleUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BleUtil();
                }
            }
        }
        return INSTANCE;
    }

    //-----UUID ---
    /**
     * service-> uuid
     */
    public static UUID ELEC_UUID_SERVICE_DATA = UUID.fromString("0000FFF0-0000-1000-8000-00805f9b34fb");
    /**
     * character->write uuid
     */
    public static UUID ELEC_UUID_CHARACTER_WRITE = UUID.fromString("0000FFF2-0000-1000-8000-00805f9b34fb");
    /**
     * character->read uuid
     */
    public static UUID ELEC_UUID_CHARACTER_READ = UUID.fromString("0000FFF1-0000-1000-8000-00805f9b34fb");

    public static UUID ELEC_UUID_CLIENT_CHARACTER_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");


    //血氧

    public static UUID OX_UUID_SERVICE_DATA = UUID.fromString("0000FFB0-0000-1000-8000-00805f9b34fb"); // 力康

    /**
     * 血氧 SpO2 character->write uuid
     */
    public static UUID OX_UUID_CHARACTER_WRITE = UUID.fromString("0000FFB2-0000-1000-8000-00805f9b34fb");
    /**
     * 血氧 SpO2 character->read uuid
     */
    public static UUID OX_UUID_CHARACTER_READ = UUID.fromString("0000FFB1-0000-1000-8000-00805f9b34fb");

    public static UUID OX_UUID_CLIENT_CHARACTER_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

//    public boolean isGet(String name) {
//        return Arrays.asList(deviceNames).contains(name);
//    }

//    String[] deviceNames = {BRAND_XTY_YUYUELL, BRAND_TWJ_TIDA_01, BRAND_XYY_LK, BRAND_XYJ_BIOLAND, BRAND_XYJ_MAIBOBO, BRAND_XTY_YUYUELL_YE8600A};


//    public static ArrayMap<String, Integer> initDeviceType() {
//        ArrayMap<String, Integer> map = new ArrayMap<>();
//        map.put(BRAND_XTY_YUYUELL, TYPE_MODE_XTY);
//        map.put(BRAND_TWJ_TIDA_01, TYPE_MODE_TWJ);
//        map.put(BRAND_XYY_LK, TYPE_MODE_XYY);
//        map.put(BRAND_XYJ_BIOLAND, TYPE_MODE_XYJ);
//        map.put(BRAND_XTY_YUYUELL_YE8600A, TYPE_MODE_XYJ);
//        map.put(BRAND_XYJ_MAIBOBO, TYPE_MODE_XYJ);
//        return map;
//    }
//
//
//    public static ArrayMap<Integer, String> getNameKey() {
//        ArrayMap<Integer, String> map = new ArrayMap<>();
//        map.put(TYPE_MODE_XTY, BRAND_XTY_YUYUELL);
//        map.put(TYPE_MODE_TWJ, BRAND_TWJ_TIDA_01);
//        map.put(TYPE_MODE_XYY, BRAND_XYY_LK);
//        map.put(TYPE_MODE_XYJ, BRAND_XYJ_MAIBOBO);
//        return map;
//    }
//
//    public static ArrayMap<Integer, String> getAlias() {
//        ArrayMap<Integer, String> map = new ArrayMap<>();
//        map.put(TYPE_MODE_XTY, TYPE_MODE_XTY_ALIAS);
//        map.put(TYPE_MODE_TWJ, TYPE_MODE_TWJ_ALIAS);
//        map.put(TYPE_MODE_XYY, TYPE_MODE_XYY_ALIAS);
//        map.put(TYPE_MODE_XYJ, TYPE_MODE_XYJ_ALIAS);
//        return map;
//    }

    //    public static int  brand = 1 ;  //  区分品牌   爱奥乐血糖仪-1  倍儿康体温计- 2  体达-3  力康 4   爱奥乐血压 5   脉搏波血压 6
    public static final String BRAND_XYJ_BIOLAND = "Bioland-BPM"; //Bioland-BPM              爱奥乐血压计
    //    public static final String BRAND_XTY_YUYUELL = "Bioland-BGM"; //Bioland-BGM  44:A6:E5:1A:43:3E //爱奥乐血糖仪
    public static final String BRAND_XTY_YUYUELL = "Yuwell Glucose"; //Bioland-BGM  44:A6:E5:1A:43:3E //爱奥乐血糖仪
    public static final String BRAND_TWJ_TIDA_01 = "Bluetooth BP"; //Bluetooth BP  TD133
    public static final String BRAND_BENE_CHECK = "BeneCheck"; //百捷 BeneCheck TC-B DONGLE
    public static final String BRAND_XYY_LK = "PC-60NW-1"; // PC-60NW-1                      力康血氧仪
    public static final String BRAND_XYJ_MAIBOBO = "BP06"; //BP06D21801040195    maibobo血压计  名字不同
    public static final String BRAND_XTY_YUYUELL_YE8600A = "Yuwell BP-YE8600A";
    public static final String BRAND_XTY_YUYUELL_YE650A = "Yuwell BP-YE650A";
    public static final String BRAND_XTY_YUYUELL_YE680A = "Yuwell BP-YE680A";
    public static final String BRAND_ELEC_CARDIO = "CardioLink";
    public static final String BRAND_ELEC_LK = "PC80B"; //Bioland-BGM  44:A6:E5:1A:43:3E //爱奥乐血糖仪
    public static final String BRAND_GMP = "BLE-EMP-Ui"; //Bluetooth BP  TD133
    public static final String BRAND_YOULAN = "BRAND_YOULAN"; //Bluetooth BP  TD133
    public static final String BRAND_SCRAP = "R5S_"; //Bluetooth BP  TD133


    public static final String BRAND_FETAL_HEART = ""; //Bluetooth BP  TD133



    public static boolean  isBleUtil(ArrayList<String> paramCheck1, String ble) {
        for (String param : paramCheck1) {
            if (param.equalsIgnoreCase(ble)) {
                return true;
            }
        }
        return false;
    }

    //打印hex日志
    public static String bytes2hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;
            }
            sb.append(tmp).append(" ");
        }
        return sb.toString();
    }

    public static String bytes2hexComma(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;
            }
            sb.append(tmp).append(",");
        }
        return sb.toString();
    }

    public static String bytes2hex(byte b) {
        String tmp = null;
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;
            }
        return tmp;
    }


    public static int[] oxyArr = {90, 94}; //血氧比较

    public static final int TYPE_MODE_TWJ = 0x11; //体温计
    public static final int TYPE_MODE_XYY = 0x22; //血氧仪
    public static final int TYPE_MODE_XYJ = 0x33; //血压计
    public static final int TYPE_MODE_XTY = 0x44; //  血糖仪
    public static final int TYPE_MODE_BENE = 0x55; //百捷
    public static final int TYPE_MODE_ELEC = 0x66;  //心电
    public static final int TYPE_MODE_ZG = 0x77; //足感
    public static final int TYPE_MODE_PZ = 0x88; //拍照

}
