package com.comm.util.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */

public class RemoteListBean {

    /**
     * checkCount : 2
     * checkList : [{"adviceId":1687,"boxId":"10000001","branchNo":7,"doctorId":307,"hisTime":"11:26","patientCode":641,"patientName":"7号组织的患者","remoteCheckId":4196,"remoteCheckTime":20180820112623,"remoteCheckType":"1","sex":"1","taskStatus":"0"},{"adviceId":1687,"boxId":"10000002","branchNo":7,"doctorId":307,"hisTime":"11:26","patientCode":641,"patientName":"7号组织的患者","remoteCheckId":4196,"remoteCheckTime":20180820112623,"remoteCheckType":"1","sex":"1","taskStatus":"0"}]
     * completeCount : 0
     * dttmList : ["今天","08-19","08-18","08-17","08-16","08-15","08-14"]
     * dttmYList : ["今天","2018-08-19","2018-08-18","2018-08-17","2018-08-16","2018-08-15","2018-08-14"]
     */

    private int checkCount;
    private int completeCount;
    private int processingCount;
    private List<CheckListBean> checkList;
    private List<String> dateList;
    private List<String> dateYList;

    public int getProcessingCount() {
        return processingCount;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public int getCompleteCount() {
        return completeCount;
    }

    public List<CheckListBean> getCheckList() {
        return checkList;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public List<String> getDateYList() {
        return dateYList;
    }

    public static class CheckListBean {
        /**
         * adviceId : 1687
         * boxId : 10000001
         * branchNo : 7
         * doctorId : 307
         * hisTime : 11:26
         * patientCode : 641
         * patientName : 7号组织的患者
         * remoteCheckId : 4196
         * remoteCheckTime : 20180820112623
         * remoteCheckType : 1
         * sex : 1
         * taskStatus : 0
         */

        private int adviceId;
        private String boxId;
        private int branchNo;
        private int doctorId;
        private String hisTime;
        private int patientCode;
        private String patientName;
        private int remoteCheckId;
        private long remoteCheckTime;
        private String remoteCheckType;
        private String sex;
        private String taskStatus;
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

        public String getTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(String taskStatus) {
            this.taskStatus = taskStatus;
        }
    }
}
