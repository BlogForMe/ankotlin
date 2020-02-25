package com.android.util.pro;

public interface ARouterManager {

   String[] COMPONENTS={
            "com.casanube.medical.AppContext",
           "com.casanube.ble.BleApplication"
    };


    String BOX_MAIN = "/box/MainActivity";
    String BOX_VIDEO = "/box/VideoActivity";
    String BOX_CONTENTHEALTH = "/box/ContentHealthActivity";
    String BOX_CLASS_ROOM = "/box/ClassRoomActivity";
    String BOX_WEB= "/box/WebActivity";

    String BOX_AGREE01= "/box/Agree01Activity";
    String BOX_AGREE02= "/box/Agree02Activity";
    String BOX_TAIAN= "/box/AgreeTaiAnActivity";
    String BOX_AGE_PICKER= "/box/AgePickerActivity";
    String BOX_AGREE_PHONE= "/box/AgreePhoneActivity";
    String BOX_AGREE_CODE= "/box/AgreeCodeActivity";
    String BOX_LOADING= "/box/LoadingActivity";
    String BOX_PERSON_INFO_CON= "/box/PersonInfoConActivity";
    String BOX_HEP_HOME ="/box/HelpHomeActivity";
    String BOX_HEP_DETAIL ="/box/BoxHelpDetailActivity";

    String BLE_HISTORY = "/per/CheckHistoryActivity";
    String BLE_HISTORY_WEB = "/per/HistoryWebActivity";


    String BLE_CHECK = "/ble/BleCheckActivity";
    String BLE_BENECHECK = "/ble/BeneCheckActivity";
    String BLE_GMP = "/ble/GmpCheckActivity";
    String BLE_TEMP = "/ble/TempActivity";
    String BLE_PRESS = "/ble/BloodPressActivity";
    String BLE_SUGAR = "/ble/BloodSugerActivity";
    String BLE_ELEC = "/ble/ElectrocarActivity";
    String BLE_OXYGEN = "/ble/BloodOxygenActivity";
    String BLE_ELEC_WUWEI = "/ble/WuMainActivity";
    String BLE_BODY_FAT = "/ble/BodyFatActivity";
    String BLE_FETAL = "/ble/FetalHeartActivity";
    String INPUT_TEMP="/ble/TempInputActivity";


    String INFO_SERVICE_CONFIRM="/info/ServiceConfirmActivity";
    String INFO_PAY_PRO="/info/PayProActivity";





}
