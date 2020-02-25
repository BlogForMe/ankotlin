package com.comm.util.bean;

/**
 * @author : John
 * @date : 2018/8/27
 */
public class RecordCheck {


    /**
     * adviceId : 1717
     * boxId : 10000024
     * branchNo : 1
     * doctorId : 303
     * hisTime : 09:46
     * patientCode : 574
     * patientName : 周桓
     * remindStatus : 0
     * remoteCheckId : 4238
     * remoteCheckTime : 20180824094627
     * remoteCheckType : 1
     * sex : 0
     * taskStatus : 0
     */

    private int adviceId;
    private String boxId;
    private int branchNo;
    private int doctorId;
    private String hisTime;
    private int patientCode;
    private String patientName;
    private int remindStatus;
    private int remoteCheckId;
    private long remoteCheckTime;
    private String remoteCheckType;
    private String sex;
    private int taskStatus;
    private String checkTime;

    public String getCheckTime() {
        return checkTime;
    }

    public int getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(int adviceId) {
        this.adviceId = adviceId;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public int getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(int branchNo) {
        this.branchNo = branchNo;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getHisTime() {
        return hisTime;
    }

    public void setHisTime(String hisTime) {
        this.hisTime = hisTime;
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

    public int getRemindStatus() {
        return remindStatus;
    }

    public void setRemindStatus(int remindStatus) {
        this.remindStatus = remindStatus;
    }

    public int getRemoteCheckId() {
        return remoteCheckId;
    }

    public void setRemoteCheckId(int remoteCheckId) {
        this.remoteCheckId = remoteCheckId;
    }

    public long getRemoteCheckTime() {
        return remoteCheckTime;
    }

    public void setRemoteCheckTime(long remoteCheckTime) {
        this.remoteCheckTime = remoteCheckTime;
    }

    public String getRemoteCheckType() {
        return remoteCheckType;
    }

    public void setRemoteCheckType(String remoteCheckType) {
        this.remoteCheckType = remoteCheckType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTaskStatus() {
        return taskStatus;
    }
}
