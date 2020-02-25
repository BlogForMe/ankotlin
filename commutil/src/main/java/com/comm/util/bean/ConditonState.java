package com.comm.util.bean;

import java.util.ArrayList;

/**
 * @author : John
 * @date : 2018/8/5
 */
public class ConditonState {

    /**
     * dttm : ["2018-08-04","2018-08-03","今天"]
     * patientList : [{"checkDttm":20180805152123,"checkStatus":0,"patientCode":11360,"patientName":"11"},{"checkDttm":20180805150946,"checkStatus":0,"patientCode":11366,"patientName":"周桓"}]
     * replyCount : 0
     */

    private int replyCount;
    private ArrayList<String> dateList;
    private ArrayList<String> dateYList;
    private ArrayList<PatientListBean> patientList;

    public int getReplyCount() {
        return replyCount;
    }


    public ArrayList<PatientListBean> getPatientList() {
        return patientList;
    }

    public ArrayList<String> getDateList() {
        return dateList;
    }

    public ArrayList<String> getDateYList() {
        return dateYList;
    }

    public static class PatientListBean {
        /**
         * checkDttm : 20180805152123
         * checkStatus : 0
         * patientCode : 11360
         * patientName : 11
         */

        private String checkDttm;
        private String checkStatus;
        private int patientCode;
        private String date;
        private String patientName;
        private String hs;
        private int replyStatus;

        public String getCheckStatus() {
            return checkStatus;
        }

        public int getReplyStatus() {
            return replyStatus;
        }

        public String getHs() {
            return hs;
        }

        public String getCheckDttm() {
            return checkDttm;
        }

        public String getDate() {
            return date;
        }

        public int getPatientCode() {
            return patientCode;
        }

        public String getPatientName() {
            return patientName;
        }

    }
}
