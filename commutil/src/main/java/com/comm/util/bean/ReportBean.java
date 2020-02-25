package com.comm.util.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/6.
 */

public class ReportBean {

    /**
     * age : 31
     * allReceivers : 健康管家周,里李,
     * allReceiversId : 297,295,
     * branchNo : 18
     * mobile : 15623495868
     * patientCode : 11394
     * patientName : 阿测
     * readCount : 15
     * readStatusList : [{"doctorName":"监护管家","readStatus":"0","receiver":189,"sendTime":20180614093306,"sender":1,"upContentId":1,"upId":1},{"doctorName":"健康管家","readStatus":"0","receiver":188,"sendTime":20180619112226,"sender":1,"upContentId":3,"upId":3},{"doctorName":"监护管家","readStatus":"0","receiver":189,"sendTime":20180621143247,"sender":1,"upContentId":4,"upId":4},{"doctorName":"周剑锋","readStatus":"0","receiver":1,"sendTime":20180627112154,"sender":1,"upContentId":5,"upId":5},{"doctorName":"测试医生","readStatus":"0","receiver":173,"sendTime":20180627112154,"sender":1,"upContentId":5,"upId":6},{"doctorName":"健康主任","readStatus":"0","receiver":187,"sendTime":20180627112154,"sender":1,"upContentId":5,"upId":7},{"doctorName":"测试医生","readStatus":"0","receiver":173,"sendTime":20180627120144,"sender":1,"upContentId":11,"upId":23},{"doctorName":"健康主任","readStatus":"0","receiver":187,"sendTime":20180627120144,"sender":1,"upContentId":11,"upId":24},{"doctorName":"测试医生","readStatus":"0","receiver":173,"sendTime":20180627143357,"sender":1,"upContentId":13,"upId":27},{"doctorName":"健康主任","readStatus":"0","receiver":187,"sendTime":20180627143357,"sender":1,"upContentId":13,"upId":28},{"doctorName":"测试医生","readStatus":"0","receiver":173,"sendTime":20180627144118,"sender":1,"upContentId":14,"upId":29},{"doctorName":"健康主任","readStatus":"0","receiver":187,"sendTime":20180627144118,"sender":1,"upContentId":14,"upId":30},{"doctorName":"健康管家","readStatus":"0","receiver":188,"sendTime":20180627144738,"sender":1,"upContentId":15,"upId":31},{"doctorName":"监护管家","readStatus":"0","receiver":189,"sendTime":20180627144738,"sender":1,"upContentId":15,"upId":32},{"doctorName":"健康管家","readStatus":"0","receiver":188,"sendTime":20180627150009,"sender":1,"upContentId":16,"upId":33}]
     * sex : 1
     * unreadCount : 0
     * upContent : 你好
     * upContentId : 56
     * upDoctor : 296
     * upDoctorName : 监护管家周
     * upId : 90
     * upTime : 20180912155741
     */

    private int upType;
    private int age;
    private String allReceivers;
    private String allReceiversId;
    private int branchNo;
    private String mobile;
    private int patientCode;
    private String patientName;
    private int readCount;
    private String sex;
    private int unreadCount;
    private String upContent;
    private int upContentId;
    private int upDoctor;
    private String upDoctorName;
    private int upId;
    private String upTime;
    private List<ReadStatusListBean> readStatusList;
    private String upData;
    private String dataType;
    private String dataCheckDttm;
    private int replyStatus;

    public int getReplyStatus() {
        return replyStatus;
    }

    public String getDataCheckDttm() {
        return dataCheckDttm;
    }

    public String getDataType() {
        return dataType;
    }

    public int getUpType() {
        return upType;
    }

    public String getUpData() {
        return upData;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAllReceivers() {
        return allReceivers;
    }

    public void setAllReceivers(String allReceivers) {
        this.allReceivers = allReceivers;
    }

    public String getAllReceiversId() {
        return allReceiversId;
    }

    public void setAllReceiversId(String allReceiversId) {
        this.allReceiversId = allReceiversId;
    }

    public int getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(int branchNo) {
        this.branchNo = branchNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getUpContent() {
        return upContent;
    }

    public void setUpContent(String upContent) {
        this.upContent = upContent;
    }

    public int getUpContentId() {
        return upContentId;
    }

    public void setUpContentId(int upContentId) {
        this.upContentId = upContentId;
    }

    public int getUpDoctor() {
        return upDoctor;
    }

    public void setUpDoctor(int upDoctor) {
        this.upDoctor = upDoctor;
    }

    public String getUpDoctorName() {
        return upDoctorName;
    }

    public void setUpDoctorName(String upDoctorName) {
        this.upDoctorName = upDoctorName;
    }

    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public String getUpTime() {
        return upTime;
    }


    public List<ReadStatusListBean> getReadStatusList() {
        return readStatusList;
    }

    public void setReadStatusList(List<ReadStatusListBean> readStatusList) {
        this.readStatusList = readStatusList;
    }

    public static class ReadStatusListBean {
        /**
         * doctorName : 监护管家
         * readStatus : 0
         * receiver : 189
         * sendTime : 20180614093306
         * sender : 1
         * upContentId : 1
         * upId : 1
         */

        private String doctorName;
        private String readStatus;
        private int receiver;
        private long sendTime;
        private int sender;
        private int upContentId;
        private int upId;

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getReadStatus() {
            return readStatus;
        }

        public void setReadStatus(String readStatus) {
            this.readStatus = readStatus;
        }

        public int getReceiver() {
            return receiver;
        }

        public void setReceiver(int receiver) {
            this.receiver = receiver;
        }

        public long getSendTime() {
            return sendTime;
        }

        public void setSendTime(long sendTime) {
            this.sendTime = sendTime;
        }

        public int getSender() {
            return sender;
        }

        public void setSender(int sender) {
            this.sender = sender;
        }

        public int getUpContentId() {
            return upContentId;
        }

        public void setUpContentId(int upContentId) {
            this.upContentId = upContentId;
        }

        public int getUpId() {
            return upId;
        }

        public void setUpId(int upId) {
            this.upId = upId;
        }
    }
}
