package com.comm.util.bean;

/**
 * @author : John
 * @date : 2018/8/9
 */
public class ChatDataBean {
    /**
     * doctorId : 1
     * name : 周剑锋
     * unionUserId : 2
     * userType : 医生
     */

    private String doctorId;
    private String name;
    private String unionUserId;
    private int userType;
    private String chatContent;
    private int readCount;
    private String recentlyDttm;
    private String diabeticFootClass;
    private String patientCode;
    private String time;
    private String patientName;
    private String doctorName;
    private int businessType;
    private String level;


    public String getLevel() {
        return level;
    }

    public int getBusinessType() {
        return businessType;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTime() {
        return time;
    }

    public String getPatientName() {
        return patientName;
    }

    //群聊
    private String chatGroupCode;

    public String getChatGroupCode() {
        return chatGroupCode;
    }

    public String getDiabeticFootClass() {
        return diabeticFootClass;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public void setRecentlyDttm(String recentlyDttm) {
        this.recentlyDttm = recentlyDttm;
    }

    public String getChatContent() {
        return chatContent;
    }

    public int getReadCount() {
        return readCount;
    }

    public String getRecentlyDttm() {
        return recentlyDttm;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnionUserId() {
        return unionUserId;
    }

    public void setUnionUserId(String unionUserId) {
        this.unionUserId = unionUserId;
    }

    public Integer getUserType() {
        return userType;
    }
}