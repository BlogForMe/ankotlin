package com.comm.util.bean;

/**
 * @author : John
 * @date : 2018/8/27
 */
public class ArchHealPlan {


    /**
     * adviceId : 1717
     * adviceType : 3
     * amount : 0
     * countDown : 0
     * createDate : 20180824
     * creator : admin
     * doctorCode : 303
     * doctorName : 周医生
     * dttmType : 1
     * endDate : 20180824
     * patientCode : 574
     * remark :
     * sendNow : 0
     * startDate : 20180824
     * status : 1
     * time : 94627
     * timeUnit :
     * weeksSeveral : 5
     */

    private int adviceId;
    private int adviceType;
    private int amount;
    private int countDown;
    private int createDate;
    private String creator;
    private int doctorCode;
    private String doctorName;
    private int dttmType;
    private String endDate;
    private int patientCode;
    private String remark;
    private int sendNow;
    private String startDate;
    private String status;
    private String time;
    private String timeUnit;
    private int weeksSeveral;
    private String adviceTarget;
    private String timing;
    private String hisTime;
    private String checkTimes;

    public String getHisTime() {
        return hisTime;
    }

    public String getTiming() {
        return timing;
    }

    public String getAdviceTarget() {
        return adviceTarget;
    }

    public int getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(int adviceId) {
        this.adviceId = adviceId;
    }

    public int getAdviceType() {
        return adviceType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public int getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(int doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getDttmType() {
        return dttmType;
    }

    public void setDttmType(int dttmType) {
        this.dttmType = dttmType;
    }

    public String getEndDate() {
        return endDate;
    }


    public int getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(int patientCode) {
        this.patientCode = patientCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSendNow() {
        return sendNow;
    }

    public void setSendNow(int sendNow) {
        this.sendNow = sendNow;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getWeeksSeveral() {
        return weeksSeveral;
    }

    public void setWeeksSeveral(int weeksSeveral) {
        this.weeksSeveral = weeksSeveral;
    }
    public String getCheckTimes() {
        return checkTimes;
    }

    public void setCheckTimes(String checkTimes) {
        this.checkTimes = checkTimes;
    }
}
