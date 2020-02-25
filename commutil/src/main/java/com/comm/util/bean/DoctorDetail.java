package com.comm.util.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : John
 * @date : 2018/9/11
 */
public class DoctorDetail extends EntityWrapper implements Parcelable {
    /**
     * doctorId : 295
     * doctorName : 里李
     * initial : L
     * jobTitle :
     * patientCount : 0
     * userCode : qwehjk
     */

    private int doctorId;
    private String doctorName;
    private String jobTitle;
    private int patientCount;
    private String userCode;
    private int defaultStatus;

    public int getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(int defaultStatus) {
        this.defaultStatus = defaultStatus;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.doctorId);
        dest.writeString(this.doctorName);
        dest.writeString(this.jobTitle);
        dest.writeInt(this.patientCount);
        dest.writeString(this.userCode);
        dest.writeInt(this.defaultStatus);
    }

    public DoctorDetail() {
    }

    protected DoctorDetail(Parcel in) {
        super(in);
        this.doctorId = in.readInt();
        this.doctorName = in.readString();
        this.jobTitle = in.readString();
        this.patientCount = in.readInt();
        this.userCode = in.readString();
        this.defaultStatus = in.readInt();
    }

    public static final Creator<DoctorDetail> CREATOR = new Creator<DoctorDetail>() {
        @Override
        public DoctorDetail createFromParcel(Parcel source) {
            return new DoctorDetail(source);
        }

        @Override
        public DoctorDetail[] newArray(int size) {
            return new DoctorDetail[size];
        }
    };
}
