package com.comm.util.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : John
 * @date : 2018/9/20
 */
public class UpdateBean implements Parcelable {

    /**
     * appType : 1
     * operate_way : 4
     * versionCode : 1
     * versionName : 1.0.0
     */

    private String appType;
    private String operate_way;
    private int versionCode;
    private String versionName;

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getOperate_way() {
        return operate_way;
    }

    public void setOperate_way(String operate_way) {
        this.operate_way = operate_way;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.appType);
        dest.writeString(this.operate_way);
        dest.writeInt(this.versionCode);
        dest.writeString(this.versionName);
    }

    public UpdateBean() {
    }

    protected UpdateBean(Parcel in) {
        this.appType = in.readString();
        this.operate_way = in.readString();
        this.versionCode = in.readInt();
        this.versionName = in.readString();
    }

    public static final Creator<UpdateBean> CREATOR = new Creator<UpdateBean>() {
        @Override
        public UpdateBean createFromParcel(Parcel source) {
            return new UpdateBean(source);
        }

        @Override
        public UpdateBean[] newArray(int size) {
            return new UpdateBean[size];
        }
    };
}
