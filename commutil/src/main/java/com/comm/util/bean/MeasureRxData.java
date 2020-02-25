package com.comm.util.bean;

import java.util.LinkedList;

/**
 * @author : John
 * @date : 2018/7/31
 */
public class MeasureRxData {
    LinkedList<MultipleCheck> multipleCheckList;
    private String dateTime;
    private String doctorName;
    private ReplyMapBean replyMap;
    private String doctorUnionUserId;

    public String getDoctorUnionUserId() {
        return doctorUnionUserId;
    }

    public void setDoctorUnionUserId(String doctorUnionUserId) {
        this.doctorUnionUserId = doctorUnionUserId;
    }

    public LinkedList<MultipleCheck> getMultipleCheckList() {
        return multipleCheckList;
    }

    public void setMultipleCheckList(LinkedList<MultipleCheck> multipleCheckList) {
        this.multipleCheckList = multipleCheckList;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public ReplyMapBean getReplyMap() {
        return replyMap;
    }

    public void setReplyMap(ReplyMapBean replyMap) {
        this.replyMap = replyMap;
    }
}
