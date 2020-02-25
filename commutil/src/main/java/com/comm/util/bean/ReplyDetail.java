package com.comm.util.bean;

public class ReplyDetail {
    private int replyStatus;
    private String replyDttm;
    private String doctorName;
    private String replyDetail;

    public void setReplyDetail(String replyDetail) {
        this.replyDetail = replyDetail;
    }

    public String getReplyDetail() {
        return replyDetail;
    }

    public void setReplyStatus(int replyStatus) {
        this.replyStatus = replyStatus;
    }

    public void setReplyDttm(String replyDttm) {
        this.replyDttm = replyDttm;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getReplyStatus() {
        return replyStatus;
    }

    public String getReplyDttm() {
        return replyDttm;
    }

    public String getDoctorName() {
        return doctorName;
    }
}
