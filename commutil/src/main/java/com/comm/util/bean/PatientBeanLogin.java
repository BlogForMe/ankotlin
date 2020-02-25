package com.comm.util.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/20.
 */

public class PatientBeanLogin implements Serializable {

    /**
     * guardianRelation : 其他
     * patientMap : {"address":"的方式答复","age":31,"cardNo":"62302619860720982X","createTime":20180720175100,"emergencyContact":"时代复分","emergencyTelephone":"13242909064","exceptionFlag":"0","languageType":1,"mainIllness":"1","memberType":1,"mobile":"13242658978","motifColor":2,"patientCode":450,"patientName":"羊羊羊","sex":"1"}
     * roleList : [5]
     * sessionId : 69c82b2e6074415cb87254c3d2bf012dw
     * unionUserId : 31861
     * userName : 时代复分
     */

    private String guardianRelation;
    // patientMap绑定的患者
    private PatientData patientMap;
    private String sessionId;
    private String token;
    private int unionUserId;
    private String userName;
    private List<Integer> roleList;
    private List<PatientData> patientList;
    private String errorContent;

    public String getErrorContent() {
        return errorContent;
    }

    //    private String fillName;
    private String sex;
    // -1代表需要绑定的患者，0 没有需要绑定的患者,只是用于判断patientMap是否有值
    private String patientExist;

    public String getPatientExist() {
        return patientExist;
    }

//    public String getFillName() {
//        return fillName;
//    }
//
//    public void setFillName(String fillName) {
//        this.fillName = fillName;
//    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    private String loginUserName;

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public PatientData getPatientMap() {
        return patientMap;
    }

    public void setPatientMap(PatientData patientMap) {
        this.patientMap = patientMap;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUnionUserId() {
        return unionUserId;
    }

    public void setUnionUserId(int unionUserId) {
        this.unionUserId = unionUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }

    public List<PatientData> getPatientList() {
        return patientList;
    }
}
