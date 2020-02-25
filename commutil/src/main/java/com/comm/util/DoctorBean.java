package com.comm.util;

import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */

public class DoctorBean {

    /**
     * doctorMap : {"branchName":"爱达康第一医院","branchNo":6,"department":"ddsf","doctorId":270,"doctorName":"Mr.Yang","email":"sdfs@qq.com","expertArea":"sdfsdfsdf","jobTitle":"sdfsf","mobile":"13242909064","pic":"c50bf800e06d4dc5a4f0cc5058d6f098","registerDate":20180801180753,"remark":"sdfsdfsdf","userCode":"yang"}
     * isDoctor : 0
     * sessionId : 44c0a8b5b6e6405d8b68d3d569b87f13d
     * isLogin : -1
     */

    private DoctorMapBean doctorMap;
    private String isDoctor;
    private String sessionId;
    private String token;
    private String unionUserId;
    private String isLogin;
    private DoctorTeam doctorTeam;
    private List<String> roleList;

    public List<String> getRoleList() {
        return roleList;
    }

    public DoctorTeam getDoctorTeam() {
        return doctorTeam;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public String getUnionUserId() {
        return unionUserId;
    }

    public String getToken() {
        return token;
    }

    public DoctorMapBean getDoctorMap() {
        return doctorMap;
    }

    public void setDoctorMap(DoctorMapBean doctorMap) {
        this.doctorMap = doctorMap;
    }

    public String getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(String isDoctor) {
        this.isDoctor = isDoctor;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public static class DoctorMapBean {
        /**
         * branchName : 爱达康第一医院
         * branchNo : 6
         * department : ddsf
         * doctorId : 270
         * doctorName : Mr.Yang
         * email : sdfs@qq.com
         * expertArea : sdfsdfsdf
         * jobTitle : sdfsf
         * mobile : 13242909064
         * pic : c50bf800e06d4dc5a4f0cc5058d6f098
         * registerDate : 20180801180753
         * remark : sdfsdfsdf
         * userCode : yang
         */

        private String branchName;
        private int branchNo;
        private String department;
        private int doctorId;
        private String doctorName;
        private String email;
        private String expertArea;
        private String jobTitle;
        private String mobile;
        private String pic;
        private long registerDate;
        private String remark;
        private String userCode;
        private String teamName;

        public String getTeamName() {
            return teamName;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public int getBranchNo() {
            return branchNo;
        }

        public void setBranchNo(int branchNo) {
            this.branchNo = branchNo;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getExpertArea() {
            return expertArea;
        }

        public void setExpertArea(String expertArea) {
            this.expertArea = expertArea;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public long getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(long registerDate) {
            this.registerDate = registerDate;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }
    }
}
