package com.android.util.pro;


/**
 * @author : John
 * @date : 2018/7/15
 */
public class Constant {

    public final static int MQ_PPORT = 6667;
    public static final String PARAMS_IS_INPUT = "PARAMS_IS_INPUT"; //温度控制


    //体温
    public static final String ITEM_TEMP = "TEMPERATURE";
    //足感
    public static final String ITEM_FOOT_FEEL = "FOOT_FEELING";
    //足部照片
    public static final String ITEM_FOOT_PHOTO = "FOOT_PHOTO";
    //血糖
    public static final String ITEM_BLOOD_SUGER = "BLOOD_GLUCOSE";
    //血氧
    public static final String ITEM_BLOOD_OXYGEN = "BLOOD_OXYGEN";
    //血压
    public static final String ITEM_BLOOD_PRESS = "BLOOD_PRESSURE";
    public static final String ITEM_REMOTE_CHECK = "REMOTE_CHECK";


    public static final String ITEM_ROUTINE_URINE = "ROUTINE_URINE"; //尿常规检测
    public static final String ITEM_ECG_CHECK = "ECG"; //心电
    public static final String ITEM_WEIGHT_CHECK = "WEIGHT";      //体重检测
    public static final String ITEM_URIC_ACID_CHECK = "URIC_ACID";    //尿酸检测
    public static final String ITEM_CHOLESTEROL_CHECK = "CHOLESTEROL";    //胆固醇检测
    public static final String ITEM_TAKE_MEDICINE_CHECK = "TAKE_MEDICINE"; //吃药
    public static final String ITEM_DIET_PLAN = "DIET_PLAN";    //饮食
    public static final String ITEM_MOVEMENT_PLAN = "MOVEMENT_PLAN"; //运动
    public static final String ITEM_OTHER = "OTHER";         //其它


    //所有的回复
    public static final String ITEM_MEASURE_ALL = "MEASURE_ALL";


    public static final String COMMON_PATH = "csn_hospital_APIServer/RestService/Call";

    // roleList  1 医生  2 家属  3 患者  5 监护人  6  护理


    //   dev cs  患者 18099998888  护理 13922221111
    //   监护管家周: 13155554444 , 健康管家周 :  13122223333  , 健康主任周 :  13188885555   监护人 18955556666   家属没有


    //游客模式 后台没有定义,roleList为空
    public final static int ROLE_TOURIST = -6;

    public final static int ROLE_DOCTOR = 1;
    public final static int ROLE_PATIENT = 3;




    public final static int ROLE_GUARDIAN = 5;

    public final static int ROLE_NURSE = 6;
    public final static int ROLE_FAMILY = 2;

    /**
     * 对话框
     */
    // 温习提示 -1
    public final static int ROLE_SYSTEM_MSG = -1;


    public final static String DOCTOR_LEVEL = "doctor_level";

    public final static String DOCTOR_ONE = "nurse";
    public final static String DOCTOR_SECOND = "doctor";
    public final static String DOCTOR_THIRD = "leader";



    /**
     * t1  150* 150
     * t2   350* 350
     * t3   550* 550
     */
    public static String IMAGE_URL = "https://cs.casanubeserver.com/casanube-file-service/casanube/file/t1/"; //图片下载
//    public static String IMAGE_URL = BuildConfig.API_HOST + "/casanube-file-service/casanube/file/"; //图片下载


    public static final int MEASURE_RESULT_DELAY = 0X666;
    public static final int BLUE_CONNECT_DELAY = 0X125;


    public static boolean SWITCH_BUTTON = false;


    public static final String FOOT_LEFT = "FOOT_LEFT";
    public static final String FOOT_RIGHT = "FOOT_RIGHT";

    public static final String WEB_FROM = "WEB_FROM";



    public static final String ACTION_KEY_CROLE = "C_Role";
    public static final String ACTION_KEY_ROOM_NAME = "ecHANEL";


    public static final int BASE_VALUE_PERMISSION = 0X0001;
    public static final int PERMISSION_REQ_ID_RECORD_AUDIO = BASE_VALUE_PERMISSION + 1;
    public static final int PERMISSION_REQ_ID_CAMERA = BASE_VALUE_PERMISSION + 2;
    public static final int PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE = BASE_VALUE_PERMISSION + 3;


    public final static String APP_ID = "60b3cba44af84714b86ea4b3a9f28e8d";


    public final  static int LIMIT = 15; //个数

    public static final int AUTH_FAILED = 12580;

    public static final String PARAM_CHECK_1 = "PARAM_CHECK_ONE";
    public static final String PARAM_CHECK_2= "PARAM_CHECK_TWO";
    public static final String PARAM_CHECK_3= "PARAM_CHECK_THREE";

    public static final String PARRAM_URL = "url";
    public static final String PARRAM_TITLE = "title";


    public static final String ACTIVITY_STRANGE = "AbnormalRemindDetail";
    public static final String ACTIVITY_EMERGENCY = "RemindEMERGENCY";
    public static final String ACTIVITY_RESULT_CHECK = "RESULT_CHECK";



    public static final String PARRAM_RESULT = "param_result";
    public static final String SHARE_BOXID = "param_boxId";



    public final static String SHARE_TOKEN_KEY = "shareToken";

    public final static String NAV_HOME = "首页";
    public final static String NAV_PRE_PAGE = "返回";



    public final static String WHICH_PEO_CODE = "WHICH_PERSON"; //个人
    public final static int BIND_USER_TYPE_PERSONAL = 1; //个人
    public final static int BIND_USER_TYPE_ORG = 2;     //机构


    //bindUserType   1个人  2 机构
    // 是机构    取 memberType
    //  1:"医院" ,
    //2:"物业",
    //3:"药店",
    //4:"社区服务中心",
    //5:"养老院"

    public final static int MEMBER_TYPE_HOSPITAL = 6;
    public final static int MEMBER_TYPE_PROPERTY = 2;
    public final static int MEMBER_TYPE_PHARMACY = 3;
    public final static int MEMBER_TYPE_COMMUNITY = 4;
    public final static int MEMBER_TYPE_NURSING = 5;




    /**
     * 1	血压仪
     * 10	胆固醇
     * 2	血糖仪
     * 3	爱康箱
     * 4	一键报警器
     * 5	血糖足套装
     * 6	血氧仪
     * 7	体温计
     * 8	心电仪
     * 9	尿酸仪
     */
    public final static int DEVICE_TYPE_BLOOD_PRESS = 1;
    public final static int DEVICE_TYPE_BLOOD_GLU = 2;
    public final static int DEVICE_TYPE_BOX= 3;
    public final static int DEVICE_TYPE_BLOOD_OXY = 6;
    public final static int DEVICE_TYPE_TEMP = 7;
    public final static int DEVICE_TYPE_ELEC = 8;
    public final static int DEVICE_TYPE_ACID = 9;
    public final static int DEVICE_TYPE_CHOL = 10;
    public final static int DEVICE_TYPE_URINE = 16; //尿常规
    public final static int DEVICE_TYPE_EL_WU = 17; //
    public final static int DEVICE_TYPE_BODY_FOT = 18; // 体脂秤
    public final static int DEVICE_TYPE_BABY_HEART = 15; // 胎心仪　
    public final static int DEVICE_TYPE_SCRAP = 19; // 胎心仪　

    /**
     * "bloodPressure", "1",
     *    "bloodGlucose", "2",
     *    "temperature", "7",
     *    "bloodOxygen", "6",
     *    "uricAcid", "9",
     *    "cholesterol", "12",
     *    "footFeeling", "13",
     *    "footPhoto", "14",
     *    "routineUrine", "16",
     *    "babySound", "15");
     *
     *
     *    "bloodGlucose", "血糖",
     *    "temperature", "体温",
     *    "bloodOxygen", "血氧",
     *    "uricAcid", "尿酸",
     *    "cholesterol", "总胆固醇",
     *    "footFeeling", "足感",
     *    "footPhoto", "足部拍照",
     *    "routineUrine", "尿常规",
     *    "babySound", "胎心仪");
     */

    public final static int MESSAGE_EVENT_SWITCH_PERSON_HAD = 100; //有人
    public final static int MESSAGE_EVENT_SWITCH_PERSON_REG = 102; //
    public final static int MESSAGE_EVENT_WARD_OPEN_CAMERA = 103; //查房


    /**
     * 医护箱控制测量显示变量
     */
    public static final String FILE_VIDEO = "FILE_VIDEO";
    public static final String KEY_VIDEO = "KEY_VIDEO";
    public static final String KEY_AUDIO_MUTE_BEGIN = "audio.mute.begin"; //播放时间
    public static final String KEY_AUDIO_MUTE_END = "audio.mute.end";
    public static final String INFORMATION_URL = "information.url";
    public static final String SPEANK_ADDR_SOUTHERN_FUJIAN_DIALECT = "speaker.addr.southernFujianDialect"; //闽南语url
    public static final String ORDER_ENABLE = "order.enable";               //#产品订购功能开关
    public static final String INFORMATION_DISABLE = "information.disable"; //资讯禁用
    public static final String MEASUURE_DISABLE_BLOODPRESSURE = "measure.disable.bloodPressure";
    public static final String MEASUURE_DISABLE_BLOODPGLUCOSE = "measure.disable.bloodGlucose";
    public static final String MEASUURE_DISABLE_BLOODOXYGEN = "measure.disable.bloodOxygen";
    public static final String MEASUURE_DISABLE_TEMPERATURE = "measure.disable.temperature";
    public static final String MEASUURE_DISABLE_URIC = "measure.disable.uric";
    public static final String MEASUURE_DISABLE_TC = "measure.disable.tc";
    public static final String MEASUURE_DISABLE_ECG = "measure.disable.ecg";
    public static final String MEASUURE_DISABLE_URINE = "measure.disable.urine"; //尿常规
    public static final String MEASUURE_DISABLE_12ECG = "measure.disable.12ecg";
    public static final String MEASUURE_DISABLE_REGISTRY = "registry.self.disable"; //自助注册


}
