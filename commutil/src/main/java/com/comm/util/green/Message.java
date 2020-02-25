package com.comm.util.green;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Date;

/**
 * Created by Administrator on 9/2/2017.
 */
@Entity
public class Message {

    //显示在屏幕上
    public final static int SCREEN_SHOW_TYPE_SHOW = 0X02;

    public final static int SCREEN_SHOW_TYPE_WHILE = 0X03;

    //消息在屏幕上播放完就不显示
    public final static int SCREEN_SHOW_TYPE_TIME = 0;

    @Id
    @Property(nameInDb = "REMIND_ID")
    private Long remindId;

    @Property
    private int recordId;

    @Property
    private int adviceId;

    @NotNull
    private int readStatus = 0;
    @Property
    private int patientId;
    @Property
    private String createTime = new Date(System.currentTimeMillis()).toString();

    @NotNull
    private int remindType;
    @NotNull
    private String remindContent;
    @NotNull
    private String boxId;

    //播放类型
    @NotNull
    private int messagePlayType;
//    0 不播放
//1 立即播放
//2 点击播放
//3 重复播放

    //播放次数
    @NotNull
    private int messagePlayCount = 1;

    //下一次播放间隔时间
    @NotNull
    private int messagePlayInterval = 0;

    @NotNull
    private int screenShowType;

    //消息在屏幕上显示时间 0，播放就不显示
    @NotNull
    private int screenShowTypeTime = SCREEN_SHOW_TYPE_TIME;

    // true>第一次播放
    @Transient
    private boolean mCheckFistPlay = true;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getDetails() {
        return details;
    }

    public void setDetails(int details) {
        this.details = details;
    }

    @Transient
    private int details = -1;

    @Transient
    private String functionName;
    @Transient
    private String kind;

    @Transient
    private String videoRecordId;

    @Transient
    private String patientName;

    @Transient
    private int sex;

    @Transient
    private int patientCode;


    public void setPlayTime() {
        this.playTime = System.currentTimeMillis();
//        Timber.tag(TAG_SPEAK).d("setPlayTime    playTime:" + dateToString(new Date(playTime),HHCmmCss));
    }

    public boolean checkPlayLongTime() {
        boolean cheeck = false;
        if (messagePlayType != 3 && playTime > 0) {
            long time = System.currentTimeMillis();
            cheeck = time - playTime > (1000 * 15);
//            if (cheeck) {
//            }
//            Timber.tag(TAG_SPEAK).d("checkPlayLongTime time:" + dateToString(new Date(time),HHCmmCss) + "    -->playTime:    " + dateToString(new Date(playTime),HHCmmCss) + " cheeck  time " + (time - playTime) + cheeck);
        }
        return cheeck;
    }

    @Transient
    private long playTime = 0;

    @Transient
    private int bindUserType;

    @Transient
    private String businessParameter;

    @Transient
    private int businessMsg; //订单消息为true

    @Transient
    private int type;

    @Transient
    private DoctorInfo doctorInfo;

    @Transient
    private boolean needConfirm;

    @Transient
    private boolean lastMessage;

    public boolean isLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(boolean lastMessage) {
        this.lastMessage = lastMessage;
    }

    public boolean isNeedConfirm() {
        return needConfirm;
    }

    public Message setNeedConfirm(boolean needConfirm) {
        this.needConfirm = needConfirm;
        return this;
    }

    public DoctorInfo getDoctorInfo() {
        return doctorInfo;
    }

    public Message setDoctorInfo(DoctorInfo doctorInfo) {
        this.doctorInfo = doctorInfo;
        return this;
    }

    public String getVideoRecordId() {
        return videoRecordId;
    }

    public Message setVideoRecordId(String videoRecordId) {
        this.videoRecordId = videoRecordId;
        return this;
    }

    public String getBusinessParameter() {
        return businessParameter;
    }

    public void setBusinessParameter(String businessParameter) {
        this.businessParameter = businessParameter;
    }

    public int getBusinessMsg() {
        return businessMsg;
    }

    public int getBindUserType() {
        return bindUserType;
    }

    public void setBindUserType(int bindUserType) {
        this.bindUserType = bindUserType;
    }


    public Message(int remindId, int recordId, int adviceId, int readStatus,
                   int patientId, String createTime, int remindType,
                   @NotNull String remindContent, @NotNull String boxId, int messagePlayTyp, int screenShowType, String functionName) {
        setRemindId(remindId);
        this.recordId = recordId;
        this.adviceId = adviceId;
        this.readStatus = readStatus;
        this.patientId = patientId;
        this.createTime = createTime;
        this.remindType = remindType;
        this.remindContent = remindContent;
        this.boxId = boxId;
        this.messagePlayType = messagePlayTyp;
        this.screenShowType = screenShowType;
        this.functionName = functionName;
    }

    public Message(int remindId, int recordId, int adviceId, int readStatus,
                   int patientId, String createTime, int remindType,
                   @NotNull String remindContent, @NotNull String boxId, int messagePlayTyp, int screenShowType, String functionName, int bindUserType, String businessParameter) {
        setRemindId(remindId);
        this.recordId = recordId;
        this.adviceId = adviceId;
        this.readStatus = readStatus;
        this.patientId = patientId;
        this.createTime = createTime;
        this.remindType = remindType;
        this.remindContent = remindContent;
        this.boxId = boxId;
        this.messagePlayType = messagePlayTyp;
        this.screenShowType = screenShowType;
        this.functionName = functionName;
        this.bindUserType = bindUserType;
        this.businessParameter = businessParameter;
    }

    @Generated(hash = 1646908091)
    public Message(Long remindId, int recordId, int adviceId, int readStatus, int patientId, String createTime, int remindType,
                   @NotNull String remindContent, @NotNull String boxId, int messagePlayType, int messagePlayCount, int messagePlayInterval, int screenShowType,
                   int screenShowTypeTime) {
        this.remindId = remindId;
        this.recordId = recordId;
        this.adviceId = adviceId;
        this.readStatus = readStatus;
        this.patientId = patientId;
        this.createTime = createTime;
        this.remindType = remindType;
        this.remindContent = remindContent;
        this.boxId = boxId;
        this.messagePlayType = messagePlayType;
        this.messagePlayCount = messagePlayCount;
        this.messagePlayInterval = messagePlayInterval;
        this.screenShowType = screenShowType;
        this.screenShowTypeTime = screenShowTypeTime;
    }

    @Generated(hash = 637306882)
    public Message() {

    }

    public int getPatientCode() {
        return patientCode;
    }

    public Message setPatientCode(int patientCode) {
        this.patientCode = patientCode;
        return this;
    }

    public void setRemindId(int remindId) {
        this.remindId = new Long(remindId);
    }

    public Long getRemindId() {
        return this.remindId;
    }

    public void setRemindId(Long remindId) {
        this.remindId = remindId;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getAdviceId() {
        return this.adviceId;
    }

    public void setAdviceId(int adviceId) {
        this.adviceId = adviceId;
    }

    public int getReadStatus() {
        return this.readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public int getPatientId() {
        return this.patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getRemindType() {
        return this.remindType;
    }

    public void setRemindType(int remindType) {
        this.remindType = remindType;
    }

    public String getRemindContent() {
        return this.remindContent;
    }

    public Message setRemindContent(String remindContent) {
        this.remindContent = remindContent;
        return  this;
    }

    public String getBoxId() {
        return this.boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public int getMessagePlayType() {
        return this.messagePlayType;
    }

    public void setMessagePlayType(int messagePlayType) {
        this.messagePlayType = messagePlayType;
    }

    public int getScreenShowType() {
        return this.screenShowType;
    }

    public void setScreenShowType(int screenShowType) {
        this.screenShowType = screenShowType;
    }

    public int getMessagePlayCount() {
        return this.messagePlayCount;
    }

    public void setMessagePlayCount(int messagePlayCount) {
        this.messagePlayCount = messagePlayCount;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPatientName() {
        return patientName;
    }

    public Message setPatientName(String patientName) {
        this.patientName = patientName;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public Message setSex(int sex) {
        this.sex = sex;
        return this;
    }

    public void setBusinessMsg(int businessMsg) {
        this.businessMsg = businessMsg;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getKind() {
        return kind;
    }

    public int getMessagePlayInterval() {
        if (mCheckFistPlay && messagePlayCount > 1) {
            return 0;
        }
        return this.messagePlayInterval;
    }

    public void setMessagePlayInterval(int messagePlayInterval) {
        this.messagePlayInterval = messagePlayInterval;
    }

    public int getScreenShowTypeTime() {
        return this.screenShowTypeTime;
    }

    public void setScreenShowTypeTime(int screenShowTypeTime) {
        this.screenShowTypeTime = screenShowTypeTime;
    }

    public boolean checkShowScreen() {
        return screenShowType == SCREEN_SHOW_TYPE_SHOW || screenShowType == SCREEN_SHOW_TYPE_WHILE;
    }

    public void messagePlayCountMinusOne() {
        this.messagePlayCount--;
        mCheckFistPlay = false;
    }

    public boolean isCheckFistPlay() {
        return mCheckFistPlay;
    }

//    @Override
//    public String toString() {
//        return "Message{" +
//                "remindId=" + remindId +
//                ", recordId=" + recordId +
//                ", adviceId=" + adviceId +
//                ", readStatus=" + readStatus +
//                ", patientId=" + patientId +
//                ", createTime='" + createTime + '\'' +
//                ", remindType=" + remindType +
//                ", remindContent='" + remindContent + '\'' +
//                ", boxId='" + boxId + '\'' +
//                ", messagePlayType=" + messagePlayType +
//                ", messagePlayCount=" + messagePlayCount +
//                ", messagePlayInterval=" + messagePlayInterval +
//                ", screenShowType=" + screenShowType +
//                ", screenShowTypeTime=" + screenShowTypeTime +
//                ", mCheckFistPlay=" + mCheckFistPlay +
//                ", details=" + details +
//                ", functionName='" + functionName + '\'' +
//                ", playTime=" + playTime +
//                '}';
//    }
}
