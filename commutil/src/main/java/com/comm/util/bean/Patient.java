package com.comm.util.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

import static com.comm.util.pro.Constant.BIND_USER_TYPE_PERSONAL;
import static com.comm.util.pro.Constant.MEMBER_TYPE_HOSPITAL;

/**
 * Created by Administrator on 11/20/2017.
 */
@Entity
public class Patient implements Serializable /* ,Cloneable*/{

    private static final long serialVersionUID = 7526472295622776147L;  // unique id

    @Id
    @Property(nameInDb = "_ID")
    private Long patientId;

    @Transient
    private String fistName;
    @Transient
    private String lastName;


    private int sex;

    private int boxType;

    private int patientCode;

    private String boxId;

    private String token;

    private String gatewayMac;


    private int languageType ;


    private int motifColor = 1;


    private boolean checkCurrent = false;


    private String patientName;


    private String branchName;


    private int branchNo;


    private int memberType = MEMBER_TYPE_HOSPITAL;


    private int bindUserType = BIND_USER_TYPE_PERSONAL;

    //机构下的个人
    private int branchPerson;

    private String alias;
    private int waitingAgreementConfirmStatus;  //-1未确定；0已确定
    private int age;
    private String mobile;
    private int height;
    private int ifAthletes;

    public Patient(Long patientId, String fistName, String lastName, int sex,
                   int boxType, int patientCode, String boxId, String token,
                   String gatewayMac, int languageType) {
        this.patientId = patientId;
        this.fistName = fistName;
        this.lastName = lastName;
        this.sex = sex;
        this.boxType = boxType;
        this.patientCode = patientCode;
        this.boxId = boxId;
        this.token = token;
        this.gatewayMac = gatewayMac;
        this.languageType = languageType;
    }






    @Generated(hash = 1655646460)
    public Patient() {
    }






    @Generated(hash = 1465575665)
    public Patient(Long patientId, int sex, int boxType, int patientCode, String boxId,
            String token, String gatewayMac, int languageType, int motifColor,
            boolean checkCurrent, String patientName, String branchName, int branchNo,
            int memberType, int bindUserType, int branchPerson, String alias,
            int waitingAgreementConfirmStatus, int age, String mobile, int height,
            int ifAthletes) {
        this.patientId = patientId;
        this.sex = sex;
        this.boxType = boxType;
        this.patientCode = patientCode;
        this.boxId = boxId;
        this.token = token;
        this.gatewayMac = gatewayMac;
        this.languageType = languageType;
        this.motifColor = motifColor;
        this.checkCurrent = checkCurrent;
        this.patientName = patientName;
        this.branchName = branchName;
        this.branchNo = branchNo;
        this.memberType = memberType;
        this.bindUserType = bindUserType;
        this.branchPerson = branchPerson;
        this.alias = alias;
        this.waitingAgreementConfirmStatus = waitingAgreementConfirmStatus;
        this.age = age;
        this.mobile = mobile;
        this.height = height;
        this.ifAthletes = ifAthletes;
    }



    public int getBranchPerson() {
        return branchPerson;
    }

    public void setBranchPerson(int branchPerson) {
        this.branchPerson = branchPerson;
    }

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFistName() {
        return this.fistName;
    }


    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getBoxType() {
        return this.boxType;
    }

    public void setBoxType(int boxType) {
        this.boxType = boxType;
    }

    public int getPatientCode() {
        return this.patientCode;
    }

    public void setPatientCode(int patientCode) {
        this.patientCode = patientCode;
    }

    public String getBoxId() {
        return this.boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGatewayMac() {
        return this.gatewayMac;
    }

    public void setGatewayMac(String gatewayMac) {
        this.gatewayMac = gatewayMac;
    }

    public int getlanguageType() {
        return this.languageType;
    }

    public void setlanguageType(int languageType) {
        this.languageType = languageType;
    }

    public int getMotifColor() {
        if (this.motifColor == 0) return 1;
        return this.motifColor;
    }

    public void setMotifColor(int motifColor) {
        this.motifColor = motifColor;
    }


    public boolean getCheckCurrent() {
        return this.checkCurrent;
    }


    public void setCheckCurrent(boolean checkCurrent) {
        this.checkCurrent = checkCurrent;
    }


    public String getPatientName() {
        return this.patientName;
    }


    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


    public int getMemberType() {
        return this.memberType;
    }


    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }


    public boolean isPersonl() {
        return this.bindUserType == BIND_USER_TYPE_PERSONAL;
    }


    public int getBindUserType() {
        return bindUserType;
    }

    public void setBindUserType(int bindUserType) {
        this.bindUserType = bindUserType;
    }

    public boolean isCheckCurrent() {
        return checkCurrent;
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

    public String getAlias() {
        return alias;
    }


    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getAge() {
        return age;
    }

    public Patient setAge(int age) {
        this.age = age;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Patient setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }


    public int getWaitingAgreementConfirmStatus() {
        return this.waitingAgreementConfirmStatus;
    }


    public void setWaitingAgreementConfirmStatus(int waitingAgreementConfirmStatus) {
        this.waitingAgreementConfirmStatus = waitingAgreementConfirmStatus;
    }





    public int getLanguageType() {
        return this.languageType;
    }



    public void setLanguageType(int languageType) {
        this.languageType = languageType;
    }






    public int getHeight() {
        return this.height;
    }






    public void setHeight(int height) {
        this.height = height;
    }






    public int getIfAthletes() {
        return this.ifAthletes;
    }






    public void setIfAthletes(int ifAthletes) {
        this.ifAthletes = ifAthletes;
    }

}
