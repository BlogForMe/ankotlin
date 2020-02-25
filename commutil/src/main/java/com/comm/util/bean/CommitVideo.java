package com.comm.util.bean;

/**
 * @author : John
 * @date : 2018/8/31
 */
public class CommitVideo {

    /**
     * count : 1
     * dataList : [{"businessId":"4339","connectionStatus":"1","connectionStatus_":"已接通","createTime":"20180831172931","doctorName":"周医生","endTime":"20180831172942","id":"1561","initiateBy":"303","patientName":"周桓","receiveBy":"574","remoteCheckId":"4339","startTime":"20180831172931","time":"0分11秒"}]
     * dataType : list
     * meta : {"describe":"操作成功","statusCode":"0"}
     */

    private String businessId;
    private String connectionStatus;
    private String connectionStatus_;
    private String createTime;
    private String doctorName;
    private String endTime;
    private String id;
    private String initiateBy;
    private String patientName;
    private String receiveBy;
    private String remoteCheckId;
    private String startTime;
    private String time;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public String getConnectionStatus_() {
        return connectionStatus_;
    }

    public void setConnectionStatus_(String connectionStatus_) {
        this.connectionStatus_ = connectionStatus_;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitiateBy() {
        return initiateBy;
    }

    public void setInitiateBy(String initiateBy) {
        this.initiateBy = initiateBy;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(String receiveBy) {
        this.receiveBy = receiveBy;
    }

    public String getRemoteCheckId() {
        return remoteCheckId;
    }

    public void setRemoteCheckId(String remoteCheckId) {
        this.remoteCheckId = remoteCheckId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
