package com.comm.util.bean;

public class AppintBean {
    private String  doctorName;
    private String appointId;
    private String appointTime;
    private String doctorDisposeTime;
    private int appointType;
    private int status;

    public int getStatus() {
        return status;
    }

    public int getAppointType() {
        return appointType;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAppointId() {
        return appointId;
    }

    public void setAppointId(String appointId) {
        this.appointId = appointId;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public String getDoctorDisposeTime() {
        return doctorDisposeTime;
    }

    public void setDoctorDisposeTime(String doctorDisposeTime) {
        this.doctorDisposeTime = doctorDisposeTime;
    }
}
