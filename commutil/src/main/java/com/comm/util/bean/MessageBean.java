package com.comm.util.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : John
 * @date : 2018/8/9
 */
public class MessageBean implements Parcelable {

    /**
     * content : 恭喜您注册成功。
     * reserved : {"serviceActionCode":"BLOOD_SUGAR_FOOT_APP_SYSTEM_MESSAGE_PATIENTS_LOGIN"}
     * title : 注册成功
     * type : 0
     */

    private int boxId;
    private String content;
    private ReservedBean reserved;
    private String title;
    private int type;
    private String time;
    private int patientCode;
    private int videoRecordId;
    private String functionName;
    private String unionUserId;
    private String doctorName;
    private String playUrl;
    private String videoId;
    private int businessType;
    private String topic;
    private String patientName;

    public String getPatientName() {
        return patientName;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getUnionUserId() {
        return unionUserId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public int getVideoRecordId() {
        return videoRecordId;
    }

    public int getPatientCode() {
        return patientCode;
    }

    public int getBoxId() {
        return boxId;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ReservedBean getReserved() {
        return reserved;
    }

    public void setReserved(ReservedBean reserved) {
        this.reserved = reserved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }


    public static class ReservedBean implements Parcelable {
        /**
         * serviceActionCode : BLOOD_SUGAR_FOOT_APP_SYSTEM_MESSAGE_PATIENTS_LOGIN
         */

        private String serviceActionCode;

        public String getServiceActionCode() {
            return serviceActionCode;
        }

        public void setServiceActionCode(String serviceActionCode) {
            this.serviceActionCode = serviceActionCode;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.serviceActionCode);
        }

        public ReservedBean() {
        }

        protected ReservedBean(Parcel in) {
            this.serviceActionCode = in.readString();
        }

        public static final Parcelable.Creator<ReservedBean> CREATOR = new Parcelable.Creator<ReservedBean>() {
            @Override
            public ReservedBean createFromParcel(Parcel source) {
                return new ReservedBean(source);
            }

            @Override
            public ReservedBean[] newArray(int size) {
                return new ReservedBean[size];
            }
        };
    }

    public MessageBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.boxId);
        dest.writeString(this.content);
        dest.writeParcelable(this.reserved, flags);
        dest.writeString(this.title);
        dest.writeInt(this.type);
        dest.writeString(this.time);
        dest.writeInt(this.patientCode);
        dest.writeInt(this.videoRecordId);
        dest.writeString(this.functionName);
        dest.writeString(this.unionUserId);
        dest.writeString(this.doctorName);
        dest.writeString(this.playUrl);
        dest.writeString(this.videoId);
        dest.writeInt(this.businessType);
        dest.writeString(this.topic);
        dest.writeString(this.patientName);
    }

    protected MessageBean(Parcel in) {
        this.boxId = in.readInt();
        this.content = in.readString();
        this.reserved = in.readParcelable(ReservedBean.class.getClassLoader());
        this.title = in.readString();
        this.type = in.readInt();
        this.time = in.readString();
        this.patientCode = in.readInt();
        this.videoRecordId = in.readInt();
        this.functionName = in.readString();
        this.unionUserId = in.readString();
        this.doctorName = in.readString();
        this.playUrl = in.readString();
        this.videoId = in.readString();
        this.businessType = in.readInt();
        this.topic = in.readString();
        this.patientName = in.readString();
    }

    public static final Creator<MessageBean> CREATOR = new Creator<MessageBean>() {
        @Override
        public MessageBean createFromParcel(Parcel source) {
            return new MessageBean(source);
        }

        @Override
        public MessageBean[] newArray(int size) {
            return new MessageBean[size];
        }
    };
}
