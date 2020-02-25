package com.comm.util.bean;

/**
 * @author : John
 * @date : 2018/8/2
 */
public class ReplyMapBean {
    /**
     * createDttm : 2018-08-02 11:00:16
     * doctorId : 243
     * doctorName : zhou
     * patientCode : 518
     * replyDetail : 该吃吃该睡睡该睡睡
     * replyId : 9
     */

    private String createDttm;
    private int doctorId;
    private String doctorName;
    private int patientCode;
    private String replyDetail;
    private int replyId;

    public String getCreateDttm() {
        return createDttm;
    }

    public void setCreateDttm(String createDttm) {
        this.createDttm = createDttm;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(int patientCode) {
        this.patientCode = patientCode;
    }

    public String getReplyDetail() {
        return replyDetail;
    }

    public void setReplyDetail(String replyDetail) {
        this.replyDetail = replyDetail;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }
}
