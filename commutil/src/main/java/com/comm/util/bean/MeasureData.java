package com.comm.util.bean;

import java.util.List;

/**
 * @author : John
 * @date : 2018/7/21
 */
public class MeasureData {


    /**
     * BloodGlucoseDataList : [{"checkDate":20180722,"checkTime":20180722205931,"dataValue":39.3,"hisTime":"20:59:31","mealStatus":"BLOOD_GLUCOSE_AM","measureItemId":30,"patientCode":449,"patientName":"仿周","planId":20180722170000,"serialId":4154},{"checkDate":20180722,"checkTime":20180722210019,"dataValue":39.3,"hisTime":"21:00:19","mealStatus":"BLOOD_GLUCOSE_BM","measureItemId":29,"patientCode":449,"patientName":"仿周","planId":20180722070000,"serialId":4155}]
     * BloodOxygenDataList : [{"checkDate":20180722,"checkTime":20180722210046,"hisTime":"21:00:46","measureItemId":41,"patientCode":449,"patientName":"仿周","perfusionIndex":"7.3","planId":20180722170000,"pulseRate":"86","saturation":"97","serialId":7},{"checkDate":20180722,"checkTime":20180722210912,"hisTime":"21:09:12","measureItemId":40,"patientCode":449,"patientName":"仿周","perfusionIndex":"6.7","planId":20180722113000,"pulseRate":"86","saturation":"97","serialId":8},{"checkDate":20180722,"checkTime":20180722211516,"hisTime":"21:15:16","measureItemId":39,"patientCode":449,"patientName":"仿周","perfusionIndex":"16.4","planId":20180722070000,"pulseRate":"87","saturation":"96","serialId":9}]
     * BloodPhotoDataList : [{"checkDate":20180722,"checkTime":20180722211944,"hisTime":"21:19:44","measureItemId":65,"patientCode":449,"patientName":"仿周","pictureLeftInstep":"500664a69b4b4840bc886113154b1e38","pictureLeftSole":"27a6613ef6a74311a90cf4031c959cdc","pictureRightInstep":"41fe3b520e2e452795bd09319bb3a412","picureRightSole":"800cff4e9b3d40e8bb84a18ada077cd0","planId":20180722170000,"serialId":9},{"checkDate":20180722,"checkTime":20180722211946,"hisTime":"21:19:46","measureItemId":64,"patientCode":449,"patientName":"仿周","pictureLeftInstep":"500664a69b4b4840bc886113154b1e38","pictureLeftSole":"27a6613ef6a74311a90cf4031c959cdc","pictureRightInstep":"41fe3b520e2e452795bd09319bb3a412","picureRightSole":"800cff4e9b3d40e8bb84a18ada077cd0","planId":20180722113000,"serialId":10}]
     * BloodPressureDataList : [{"checkDate":20180722,"checkTime":20180722211704,"hisTime":"21:17:04","jumpValue":80,"measureItemId":24,"patientCode":449,"patientName":"仿周","planId":20180722170000,"pressureHighValue":119,"pressureLowValue":80,"serialId":3378},{"checkDate":20180722,"checkTime":20180722211706,"hisTime":"21:17:06","jumpValue":80,"measureItemId":23,"patientCode":449,"patientName":"仿周","planId":20180722113000,"pressureHighValue":119,"pressureLowValue":80,"serialId":3379}]
     * FootFeelingDataList : [{"checkDate":20180722,"checkTime":20180722203906,"footFeelingLeft1":"Normal","footFeelingLeft10":"Slip","footFeelingLeft11":"Normal","footFeelingLeft12":"Normal","footFeelingLeft2":"Slip","footFeelingLeft3":"Normal","footFeelingLeft4":"Normal","footFeelingLeft5":"Slip","footFeelingLeft6":"Normal","footFeelingLeft7":"Normal","footFeelingLeft8":"Slip","footFeelingLeft9":"Slip","footFeelingRight1":"Normal","footFeelingRight10":"Normal","footFeelingRight11":"Normal","footFeelingRight12":"Slip","footFeelingRight2":"Slip","footFeelingRight3":"Slip","footFeelingRight4":"Normal","footFeelingRight5":"Normal","footFeelingRight6":"Normal","footFeelingRight7":"Slip","footFeelingRight8":"Slip","footFeelingRight9":"Normal","hisTime":"20:39:06","leftLoss":"7、8、9、10","leftNormal":"1、2、3、4、5、6","leftRecession":"11,12","measureItemId":101,"patientCode":449,"patientName":"仿周","planId":20180722170000,"rightLoss":"7、8、9、10","rightNormal":"1、2、3、4、5、6","rightRecession":"11,12","serialId":9},{"checkDate":20180722,"checkTime":20180722203908,"footFeelingLeft1":"Normal","footFeelingLeft10":"Slip","footFeelingLeft11":"Normal","footFeelingLeft12":"Normal","footFeelingLeft2":"Slip","footFeelingLeft3":"Normal","footFeelingLeft4":"Normal","footFeelingLeft5":"Slip","footFeelingLeft6":"Normal","footFeelingLeft7":"Normal","footFeelingLeft8":"Slip","footFeelingLeft9":"Slip","footFeelingRight1":"Normal","footFeelingRight10":"Normal","footFeelingRight11":"Normal","footFeelingRight12":"Slip","footFeelingRight2":"Slip","footFeelingRight3":"Slip","footFeelingRight4":"Normal","footFeelingRight5":"Normal","footFeelingRight6":"Normal","footFeelingRight7":"Slip","footFeelingRight8":"Slip","footFeelingRight9":"Normal","hisTime":"20:39:08","leftLoss":"7、8、9、10","leftNormal":"1、2、3、4、5、6","leftRecession":"11,12","measureItemId":128,"patientCode":449,"patientName":"仿周","planId":20180722170000,"rightLoss":"7、8、9、10","rightNormal":"1、2、3、4、5、6","rightRecession":"11,12","serialId":10}]
     * TemperatureDataList : [{"checkDate":20180722,"checkTime":20180722194311,"hisTime":"19:43:11","measureItemId":50,"patientCode":449,"patientName":"仿周","planId":20180722170000,"serialId":8,"temperatureForehead":36.5,"temperatureLeftFoot":36.4,"temperatureRightFoot":36.6,"temperatureTorso":36.5},{"checkDate":20180722,"checkTime":20180722194413,"hisTime":"19:44:13","measureItemId":49,"patientCode":449,"patientName":"仿周","planId":20180722113000,"serialId":9,"temperatureForehead":36.5,"temperatureLeftFoot":36.4,"temperatureRightFoot":36.6,"temperatureTorso":36.5}]
     * dateTime : 2018.07.22
     */

    private String dateTime;
    private ReplyMapBean replyMap;
    private String doctorName;
    private String doctorUnionUserId;

    public String getDoctorUnionUserId() {
        return doctorUnionUserId;
    }

    public void setDoctorUnionUserId(String doctorUnionUserId) {
        this.doctorUnionUserId = doctorUnionUserId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public ReplyMapBean getReplyMap() {
        return replyMap;
    }

    private List<BloodGlucoseDataListBean> BloodGlucoseDataList;
    private List<BloodOxygenDataListBean> BloodOxygenDataList;
    private List<BloodPhotoDataListBean> BloodPhotoDataList;
    private List<BloodPressureDataListBean> BloodPressureDataList;
    private List<FootFeelingDataListBean> FootFeelingDataList;
    private List<TemperatureDataListBean> TemperatureDataList;


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<BloodGlucoseDataListBean> getBloodGlucoseDataList() {
        return BloodGlucoseDataList;
    }

    public void setBloodGlucoseDataList(List<BloodGlucoseDataListBean> BloodGlucoseDataList) {
        this.BloodGlucoseDataList = BloodGlucoseDataList;
    }

    public List<BloodOxygenDataListBean> getBloodOxygenDataList() {
        return BloodOxygenDataList;
    }

    public void setBloodOxygenDataList(List<BloodOxygenDataListBean> BloodOxygenDataList) {
        this.BloodOxygenDataList = BloodOxygenDataList;
    }

    public List<BloodPhotoDataListBean> getBloodPhotoDataList() {
        return BloodPhotoDataList;
    }

    public void setBloodPhotoDataList(List<BloodPhotoDataListBean> BloodPhotoDataList) {
        this.BloodPhotoDataList = BloodPhotoDataList;
    }

    public List<BloodPressureDataListBean> getBloodPressureDataList() {
        return BloodPressureDataList;
    }

    public void setBloodPressureDataList(List<BloodPressureDataListBean> BloodPressureDataList) {
        this.BloodPressureDataList = BloodPressureDataList;
    }

    public List<FootFeelingDataListBean> getFootFeelingDataList() {
        return FootFeelingDataList;
    }

    public void setFootFeelingDataList(List<FootFeelingDataListBean> FootFeelingDataList) {
        this.FootFeelingDataList = FootFeelingDataList;
    }

    public List<TemperatureDataListBean> getTemperatureDataList() {
        return TemperatureDataList;
    }

    public void setTemperatureDataList(List<TemperatureDataListBean> TemperatureDataList) {
        this.TemperatureDataList = TemperatureDataList;
    }

    public static class BloodGlucoseDataListBean extends ReplyDetail {
        /**
         * checkDate : 20180722
         * checkTime : 20180722205931
         * dataValue : 39.3
         * hisTime : 20:59:31
         * mealStatus : BLOOD_GLUCOSE_AM
         * measureItemId : 30
         * patientCode : 449
         * patientName : 仿周
         * planId : 20180722170000
         * serialId : 4154
         * {"repey":{}}
         */

        private int checkDate;
        private String checkTime;
        private double dataValue;
        private String hisTime;
        private String mealStatus;
        private int measureItemId;
        private int patientCode;
        private String patientName;
        private long planId;
        private int serialId;
        private String timeInterval;

        public String getTimeInterval() {
            return timeInterval;
        }

        public int getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(int checkDate) {
            this.checkDate = checkDate;
        }

        public String getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(String checkTime) {
            this.checkTime = checkTime;
        }

        public double getDataValue() {
            return dataValue;
        }

        public void setDataValue(double dataValue) {
            this.dataValue = dataValue;
        }

        public String getHisTime() {
            return hisTime;
        }

        public void setHisTime(String hisTime) {
            this.hisTime = hisTime;
        }

        public String getMealStatus() {
            return mealStatus;
        }

        public void setMealStatus(String mealStatus) {
            this.mealStatus = mealStatus;
        }

        public int getMeasureItemId() {
            return measureItemId;
        }

        public void setMeasureItemId(int measureItemId) {
            this.measureItemId = measureItemId;
        }

        public int getPatientCode() {
            return patientCode;
        }

        public void setPatientCode(int patientCode) {
            this.patientCode = patientCode;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public long getPlanId() {
            return planId;
        }

        public void setPlanId(long planId) {
            this.planId = planId;
        }

        public int getSerialId() {
            return serialId;
        }

        public void setSerialId(int serialId) {
            this.serialId = serialId;
        }
    }

    public static class BloodOxygenDataListBean extends ReplyDetail {
        /**
         * checkDate : 20180722
         * checkTime : 20180722210046
         * hisTime : 21:00:46
         * measureItemId : 41
         * patientCode : 449
         * patientName : 仿周
         * perfusionIndex : 7.3
         * planId : 20180722170000
         * pulseRate : 86
         * saturation : 97
         * serialId : 7
         */

        private int checkDate;
        private String checkTime;
        private String hisTime;
        private int measureItemId;
        private int patientCode;
        private String patientName;
        private double perfusionIndex;
        private long planId;
        private int pulseRate;
        private int saturation;
        private int serialId;


        public int getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(int checkDate) {
            this.checkDate = checkDate;
        }

        public String getCheckTime() {
            return checkTime;
        }


        public String getHisTime() {
            return hisTime;
        }

        public void setHisTime(String hisTime) {
            this.hisTime = hisTime;
        }

        public int getMeasureItemId() {
            return measureItemId;
        }

        public void setMeasureItemId(int measureItemId) {
            this.measureItemId = measureItemId;
        }

        public int getPatientCode() {
            return patientCode;
        }

        public void setPatientCode(int patientCode) {
            this.patientCode = patientCode;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public double getPerfusionIndex() {
            return perfusionIndex;
        }

        public void setPerfusionIndex(double perfusionIndex) {
            this.perfusionIndex = perfusionIndex;
        }

        public long getPlanId() {
            return planId;
        }

        public void setPlanId(long planId) {
            this.planId = planId;
        }

        public int getPulseRate() {
            return pulseRate;
        }

        public void setPulseRate(int pulseRate) {
            this.pulseRate = pulseRate;
        }

        public int getSaturation() {
            return saturation;
        }

        public void setSaturation(int saturation) {
            this.saturation = saturation;
        }

        public int getSerialId() {
            return serialId;
        }

        public void setSerialId(int serialId) {
            this.serialId = serialId;
        }
    }

    public static class BloodPhotoDataListBean extends ReplyDetail {
        /**
         * checkDate : 20180722
         * checkTime : 20180722211944
         * hisTime : 21:19:44
         * measureItemId : 65
         * patientCode : 449
         * patientName : 仿周
         * pictureLeftInstep : 500664a69b4b4840bc886113154b1e38
         * pictureLeftSole : 27a6613ef6a74311a90cf4031c959cdc
         * pictureRightInstep : 41fe3b520e2e452795bd09319bb3a412
         * picureRightSole : 800cff4e9b3d40e8bb84a18ada077cd0
         * planId : 20180722170000
         * serialId : 9
         */

        private int checkDate;
        private String checkTime;
        private String hisTime;
        private int measureItemId;
        private int patientCode;
        private String patientName;
        private String pictureLeftInstep;
        private String pictureLeftSole;
        private String pictureRightInstep;
        private String picureRightSole;
        private long planId;
        private int serialId;

        public int getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(int checkDate) {
            this.checkDate = checkDate;
        }

        public String getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(String checkTime) {
            this.checkTime = checkTime;
        }

        public String getHisTime() {
            return hisTime;
        }

        public void setHisTime(String hisTime) {
            this.hisTime = hisTime;
        }

        public int getMeasureItemId() {
            return measureItemId;
        }

        public void setMeasureItemId(int measureItemId) {
            this.measureItemId = measureItemId;
        }

        public int getPatientCode() {
            return patientCode;
        }

        public void setPatientCode(int patientCode) {
            this.patientCode = patientCode;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getPictureLeftInstep() {
            return pictureLeftInstep;
        }

        public void setPictureLeftInstep(String pictureLeftInstep) {
            this.pictureLeftInstep = pictureLeftInstep;
        }

        public String getPictureLeftSole() {
            return pictureLeftSole;
        }

        public void setPictureLeftSole(String pictureLeftSole) {
            this.pictureLeftSole = pictureLeftSole;
        }

        public String getPictureRightInstep() {
            return pictureRightInstep;
        }

        public void setPictureRightInstep(String pictureRightInstep) {
            this.pictureRightInstep = pictureRightInstep;
        }

        public String getPicureRightSole() {
            return picureRightSole;
        }

        public void setPicureRightSole(String picureRightSole) {
            this.picureRightSole = picureRightSole;
        }

        public long getPlanId() {
            return planId;
        }

        public void setPlanId(long planId) {
            this.planId = planId;
        }

        public int getSerialId() {
            return serialId;
        }

        public void setSerialId(int serialId) {
            this.serialId = serialId;
        }
    }

    public static class BloodPressureDataListBean extends ReplyDetail {
        /**
         * checkDate : 20180722
         * checkTime : 20180722211704
         * hisTime : 21:17:04
         * jumpValue : 80.0
         * measureItemId : 24
         * patientCode : 449
         * patientName : 仿周
         * planId : 20180722170000
         * pressureHighValue : 119.0
         * pressureLowValue : 80.0
         * serialId : 3378
         */

        private int checkDate;
        private String checkTime;
        private String hisTime;
        private double jumpValue;
        private int measureItemId;
        private int patientCode;
        private String patientName;
        private long planId;
        private double pressureHighValue;
        private double pressureLowValue;
        private int serialId;


        public int getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(int checkDate) {
            this.checkDate = checkDate;
        }

        public String getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(String checkTime) {
            this.checkTime = checkTime;
        }

        public String getHisTime() {
            return hisTime;
        }

        public void setHisTime(String hisTime) {
            this.hisTime = hisTime;
        }

        public double getJumpValue() {
            return jumpValue;
        }

        public void setJumpValue(double jumpValue) {
            this.jumpValue = jumpValue;
        }

        public int getMeasureItemId() {
            return measureItemId;
        }

        public void setMeasureItemId(int measureItemId) {
            this.measureItemId = measureItemId;
        }

        public int getPatientCode() {
            return patientCode;
        }

        public void setPatientCode(int patientCode) {
            this.patientCode = patientCode;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public long getPlanId() {
            return planId;
        }

        public void setPlanId(long planId) {
            this.planId = planId;
        }

        public double getPressureHighValue() {
            return pressureHighValue;
        }

        public void setPressureHighValue(double pressureHighValue) {
            this.pressureHighValue = pressureHighValue;
        }

        public double getPressureLowValue() {
            return pressureLowValue;
        }

        public void setPressureLowValue(double pressureLowValue) {
            this.pressureLowValue = pressureLowValue;
        }

        public int getSerialId() {
            return serialId;
        }

        public void setSerialId(int serialId) {
            this.serialId = serialId;
        }
    }


    public static class TemperatureDataListBean extends ReplyDetail {
        /**
         * checkDate : 20180722
         * checkTime : 20180722194311
         * hisTime : 19:43:11
         * measureItemId : 50
         * patientCode : 449
         * patientName : 仿周
         * planId : 20180722170000
         * serialId : 8
         * temperatureForehead : 36.5
         * temperatureLeftFoot : 36.4
         * temperatureRightFoot : 36.6
         * temperatureTorso : 36.5
         */

        private int checkDate;
        private String checkTime;
        private String hisTime;
        private int measureItemId;
        private int patientCode;
        private String patientName;
        private long planId;
        private int serialId;
        private double temperatureForehead;
        private double temperatureLeftFoot;
        private double temperatureRightFoot;
        private double temperatureTorso;


        public int getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(int checkDate) {
            this.checkDate = checkDate;
        }

        public String getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(String checkTime) {
            this.checkTime = checkTime;
        }

        public String getHisTime() {
            return hisTime;
        }

        public void setHisTime(String hisTime) {
            this.hisTime = hisTime;
        }

        public int getMeasureItemId() {
            return measureItemId;
        }

        public void setMeasureItemId(int measureItemId) {
            this.measureItemId = measureItemId;
        }

        public int getPatientCode() {
            return patientCode;
        }

        public void setPatientCode(int patientCode) {
            this.patientCode = patientCode;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public long getPlanId() {
            return planId;
        }

        public void setPlanId(long planId) {
            this.planId = planId;
        }

        public int getSerialId() {
            return serialId;
        }

        public void setSerialId(int serialId) {
            this.serialId = serialId;
        }

        public double getTemperatureForehead() {
            return temperatureForehead;
        }

        public void setTemperatureForehead(double temperatureForehead) {
            this.temperatureForehead = temperatureForehead;
        }

        public double getTemperatureLeftFoot() {
            return temperatureLeftFoot;
        }

        public void setTemperatureLeftFoot(double temperatureLeftFoot) {
            this.temperatureLeftFoot = temperatureLeftFoot;
        }

        public double getTemperatureRightFoot() {
            return temperatureRightFoot;
        }

        public void setTemperatureRightFoot(double temperatureRightFoot) {
            this.temperatureRightFoot = temperatureRightFoot;
        }

        public double getTemperatureTorso() {
            return temperatureTorso;
        }

        public void setTemperatureTorso(double temperatureTorso) {
            this.temperatureTorso = temperatureTorso;
        }
    }
}
