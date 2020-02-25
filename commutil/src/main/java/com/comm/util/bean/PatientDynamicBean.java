package com.comm.util.bean;

public class PatientDynamicBean {


    /**
     * checkStatus : 1
     * diabeticFootClass : 一级
     * doctorName : 监护管家周
     * glucoseData : 33.4000
     * jumpValue : 42.0000
     * mainIllness : 3
     * mainIllness_ : 糖尿病足
     * patientCode : 11390
     * patientName : 周互
     * pressureHighValue : 58.0000
     * pressureLowValue : 42.0000
     */

    private String checkStatus;
    private String diabeticFootClass;
    private String doctorName;
    private String glucoseData;
    private String jumpValue;
    private String mainIllness;
    private String mainIllness_;
    private int patientCode;
    private String patientName;
    private String pressureHighValue;
    private String pressureLowValue;
    private Integer unionUserId;
    private String mobile;

    MeasureData.BloodGlucoseDataListBean bloodGlucoseData;
    MeasureData.BloodOxygenDataListBean bloodOxygenData;
    MeasureData.BloodPhotoDataListBean bloodPhotoData;
    MeasureData.BloodPressureDataListBean bloodPressureData;
    MeasureData.TemperatureDataListBean temperatureData;
    FootFeelingDataListBean footFeelingData;
    private AppointData appointData;
    private CheckAbnormalData checkAbnormalData;

    public AppointData getAppointData() {
        return appointData;
    }

    public class CheckAbnormalData {
        private String boxId;
        private int branchNo;
        private String content;
        private String createDate;

        public String getBoxId() {
            return boxId;
        }

        public int getBranchNo() {
            return branchNo;
        }

        public String getContent() {
            return content;
        }

        public String getCreateDate() {
            return createDate;
        }
    }


    public class AppointData {
        private int appointType;
        private String doctorName;
        private String planTime;

        public int getAppointType() {
            return appointType;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public String getPlanTime() {
            return planTime;
        }
    }

    public CheckAbnormalData getCheckAbnormalData() {
        return checkAbnormalData;
    }

    public MeasureData.TemperatureDataListBean getTemperatureData() {
        return temperatureData;
    }

    public Integer getUnionUserId() {
        return unionUserId;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getDiabeticFootClass() {
        return diabeticFootClass;
    }

    public void setDiabeticFootClass(String diabeticFootClass) {
        this.diabeticFootClass = diabeticFootClass;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getGlucoseData() {
        return glucoseData;
    }

    public void setGlucoseData(String glucoseData) {
        this.glucoseData = glucoseData;
    }

    public String getJumpValue() {
        return jumpValue;
    }

    public void setJumpValue(String jumpValue) {
        this.jumpValue = jumpValue;
    }

    public String getMainIllness() {
        return mainIllness;
    }

    public void setMainIllness(String mainIllness) {
        this.mainIllness = mainIllness;
    }

    public String getMainIllness_() {
        return mainIllness_;
    }

    public void setMainIllness_(String mainIllness_) {
        this.mainIllness_ = mainIllness_;
    }


    public int getPatientCode() {
        return patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPressureHighValue() {
        return pressureHighValue;
    }

    public void setPressureHighValue(String pressureHighValue) {
        this.pressureHighValue = pressureHighValue;
    }

    public String getPressureLowValue() {
        return pressureLowValue;
    }

    public void setPressureLowValue(String pressureLowValue) {
        this.pressureLowValue = pressureLowValue;
    }

    public MeasureData.BloodGlucoseDataListBean getBloodGlucoseData() {
        return bloodGlucoseData;
    }

    public void setBloodGlucoseData(MeasureData.BloodGlucoseDataListBean bloodGlucoseData) {
        this.bloodGlucoseData = bloodGlucoseData;
    }

    public MeasureData.BloodOxygenDataListBean getBloodOxygenData() {
        return bloodOxygenData;
    }

    public void setBloodOxygenData(MeasureData.BloodOxygenDataListBean bloodOxygenData) {
        this.bloodOxygenData = bloodOxygenData;
    }

    public MeasureData.BloodPhotoDataListBean getBloodPhotoData() {
        return bloodPhotoData;
    }

    public void setBloodPhotoData(MeasureData.BloodPhotoDataListBean bloodPhotoData) {
        this.bloodPhotoData = bloodPhotoData;
    }

    public MeasureData.BloodPressureDataListBean getBloodPressureData() {
        return bloodPressureData;
    }

    public void setBloodPressureData(MeasureData.BloodPressureDataListBean bloodPressureData) {
        this.bloodPressureData = bloodPressureData;
    }

    public FootFeelingDataListBean getFootFeelingData() {
        return footFeelingData;
    }

    public void setFootFeelingData(FootFeelingDataListBean footFeelingData) {
        this.footFeelingData = footFeelingData;
    }
}
