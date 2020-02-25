package com.comm.util.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : John
 * @date : 2018/11/6
 */
public class FootFeelingDataListBean extends ReplyDetail implements Parcelable {
    /**
     * checkDate : 20180722
     * checkTime : 20180722203906
     * footFeelingLeft1 : Normal
     * footFeelingLeft10 : Slip
     * footFeelingLeft11 : Normal
     * footFeelingLeft12 : Normal
     * footFeelingLeft2 : Slip
     * footFeelingLeft3 : Normal
     * footFeelingLeft4 : Normal
     * footFeelingLeft5 : Slip
     * footFeelingLeft6 : Normal
     * footFeelingLeft7 : Normal
     * footFeelingLeft8 : Slip
     * footFeelingLeft9 : Slip
     * footFeelingRight1 : Normal
     * footFeelingRight10 : Normal
     * footFeelingRight11 : Normal
     * footFeelingRight12 : Slip
     * footFeelingRight2 : Slip
     * footFeelingRight3 : Slip
     * footFeelingRight4 : Normal
     * footFeelingRight5 : Normal
     * footFeelingRight6 : Normal
     * footFeelingRight7 : Slip
     * footFeelingRight8 : Slip
     * footFeelingRight9 : Normal
     * hisTime : 20:39:06
     * leftLoss : 7、8、9、10
     * leftNormal : 1、2、3、4、5、6
     * leftRecession : 11,12
     * measureItemId : 101
     * patientCode : 449
     * patientName : 仿周
     * planId : 20180722170000
     * rightLoss : 7、8、9、10
     * rightNormal : 1、2、3、4、5、6
     * rightRecession : 11,12
     * serialId : 9
     */


    private int checkDate;
    private String checkTime;
    private String footFeelingLeft1;
    private String footFeelingLeft10;
    private String footFeelingLeft11;
    private String footFeelingLeft12;
    private String footFeelingLeft2;
    private String footFeelingLeft3;
    private String footFeelingLeft4;
    private String footFeelingLeft5;
    private String footFeelingLeft6;
    private String footFeelingLeft7;
    private String footFeelingLeft8;
    private String footFeelingLeft9;
    private String footFeelingRight1;
    private String footFeelingRight10;
    private String footFeelingRight11;
    private String footFeelingRight12;
    private String footFeelingRight2;
    private String footFeelingRight3;
    private String footFeelingRight4;
    private String footFeelingRight5;
    private String footFeelingRight6;
    private String footFeelingRight7;
    private String footFeelingRight8;
    private String footFeelingRight9;
    private String hisTime;
    private String leftLoss;
    private String leftNormal;
    private String leftRecession;
    private int measureItemId;
    private int patientCode;
    private String patientName;
    private long planId;
    private String rightLoss;
    private String rightNormal;
    private String rightRecession;
    private int serialId;
//    private String replyDetail;
    /**
     * 0无跳过，1跳过左脚，2跳过右脚，3全部跳过
     */
    private int skipFootFeeling;

    public int getSkipFootFeeling() {
        return skipFootFeeling;
    }

//    public void setReplyDetail(String replyDetail) {
//        this.replyDetail = replyDetail;
//    }
//
//    public String getReplyDetail() {
//        return replyDetail;
//    }

    public int getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(int checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getFootFeelingLeft1() {
        return footFeelingLeft1;
    }

    public void setFootFeelingLeft1(String footFeelingLeft1) {
        this.footFeelingLeft1 = footFeelingLeft1;
    }

    public String getFootFeelingLeft10() {
        return footFeelingLeft10;
    }

    public void setFootFeelingLeft10(String footFeelingLeft10) {
        this.footFeelingLeft10 = footFeelingLeft10;
    }

    public String getFootFeelingLeft11() {
        return footFeelingLeft11;
    }

    public void setFootFeelingLeft11(String footFeelingLeft11) {
        this.footFeelingLeft11 = footFeelingLeft11;
    }

    public String getFootFeelingLeft12() {
        return footFeelingLeft12;
    }

    public void setFootFeelingLeft12(String footFeelingLeft12) {
        this.footFeelingLeft12 = footFeelingLeft12;
    }

    public String getFootFeelingLeft2() {
        return footFeelingLeft2;
    }

    public void setFootFeelingLeft2(String footFeelingLeft2) {
        this.footFeelingLeft2 = footFeelingLeft2;
    }

    public String getFootFeelingLeft3() {
        return footFeelingLeft3;
    }

    public void setFootFeelingLeft3(String footFeelingLeft3) {
        this.footFeelingLeft3 = footFeelingLeft3;
    }

    public String getFootFeelingLeft4() {
        return footFeelingLeft4;
    }

    public void setFootFeelingLeft4(String footFeelingLeft4) {
        this.footFeelingLeft4 = footFeelingLeft4;
    }

    public String getFootFeelingLeft5() {
        return footFeelingLeft5;
    }

    public void setFootFeelingLeft5(String footFeelingLeft5) {
        this.footFeelingLeft5 = footFeelingLeft5;
    }

    public String getFootFeelingLeft6() {
        return footFeelingLeft6;
    }

    public void setFootFeelingLeft6(String footFeelingLeft6) {
        this.footFeelingLeft6 = footFeelingLeft6;
    }

    public String getFootFeelingLeft7() {
        return footFeelingLeft7;
    }

    public void setFootFeelingLeft7(String footFeelingLeft7) {
        this.footFeelingLeft7 = footFeelingLeft7;
    }

    public String getFootFeelingLeft8() {
        return footFeelingLeft8;
    }

    public void setFootFeelingLeft8(String footFeelingLeft8) {
        this.footFeelingLeft8 = footFeelingLeft8;
    }

    public String getFootFeelingLeft9() {
        return footFeelingLeft9;
    }

    public void setFootFeelingLeft9(String footFeelingLeft9) {
        this.footFeelingLeft9 = footFeelingLeft9;
    }

    public String getFootFeelingRight1() {
        return footFeelingRight1;
    }

    public void setFootFeelingRight1(String footFeelingRight1) {
        this.footFeelingRight1 = footFeelingRight1;
    }

    public String getFootFeelingRight10() {
        return footFeelingRight10;
    }

    public void setFootFeelingRight10(String footFeelingRight10) {
        this.footFeelingRight10 = footFeelingRight10;
    }

    public String getFootFeelingRight11() {
        return footFeelingRight11;
    }

    public void setFootFeelingRight11(String footFeelingRight11) {
        this.footFeelingRight11 = footFeelingRight11;
    }

    public String getFootFeelingRight12() {
        return footFeelingRight12;
    }

    public void setFootFeelingRight12(String footFeelingRight12) {
        this.footFeelingRight12 = footFeelingRight12;
    }

    public String getFootFeelingRight2() {
        return footFeelingRight2;
    }

    public void setFootFeelingRight2(String footFeelingRight2) {
        this.footFeelingRight2 = footFeelingRight2;
    }

    public String getFootFeelingRight3() {
        return footFeelingRight3;
    }

    public void setFootFeelingRight3(String footFeelingRight3) {
        this.footFeelingRight3 = footFeelingRight3;
    }

    public String getFootFeelingRight4() {
        return footFeelingRight4;
    }

    public void setFootFeelingRight4(String footFeelingRight4) {
        this.footFeelingRight4 = footFeelingRight4;
    }

    public String getFootFeelingRight5() {
        return footFeelingRight5;
    }

    public void setFootFeelingRight5(String footFeelingRight5) {
        this.footFeelingRight5 = footFeelingRight5;
    }

    public String getFootFeelingRight6() {
        return footFeelingRight6;
    }

    public void setFootFeelingRight6(String footFeelingRight6) {
        this.footFeelingRight6 = footFeelingRight6;
    }

    public String getFootFeelingRight7() {
        return footFeelingRight7;
    }

    public void setFootFeelingRight7(String footFeelingRight7) {
        this.footFeelingRight7 = footFeelingRight7;
    }

    public String getFootFeelingRight8() {
        return footFeelingRight8;
    }

    public void setFootFeelingRight8(String footFeelingRight8) {
        this.footFeelingRight8 = footFeelingRight8;
    }

    public String getFootFeelingRight9() {
        return footFeelingRight9;
    }

    public void setFootFeelingRight9(String footFeelingRight9) {
        this.footFeelingRight9 = footFeelingRight9;
    }

    public String getHisTime() {
        return hisTime;
    }

    public void setHisTime(String hisTime) {
        this.hisTime = hisTime;
    }

    public String getLeftLoss() {
        return leftLoss;
    }

    public void setLeftLoss(String leftLoss) {
        this.leftLoss = leftLoss;
    }

    public String getLeftNormal() {
        return leftNormal;
    }

    public void setLeftNormal(String leftNormal) {
        this.leftNormal = leftNormal;
    }

    public String getLeftRecession() {
        return leftRecession;
    }

    public void setLeftRecession(String leftRecession) {
        this.leftRecession = leftRecession;
    }

    public int getMeasureItemId() {
        return measureItemId;
    }

    public void setMeasureItemId(int measureItemId) {
        this.measureItemId = measureItemId;
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

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public String getRightLoss() {
        return rightLoss;
    }

    public void setRightLoss(String rightLoss) {
        this.rightLoss = rightLoss;
    }

    public String getRightNormal() {
        return rightNormal;
    }

    public void setRightNormal(String rightNormal) {
        this.rightNormal = rightNormal;
    }

    public String getRightRecession() {
        return rightRecession;
    }

    public void setRightRecession(String rightRecession) {
        this.rightRecession = rightRecession;
    }

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.checkDate);
        dest.writeString(this.checkTime);
        dest.writeString(this.footFeelingLeft1);
        dest.writeString(this.footFeelingLeft10);
        dest.writeString(this.footFeelingLeft11);
        dest.writeString(this.footFeelingLeft12);
        dest.writeString(this.footFeelingLeft2);
        dest.writeString(this.footFeelingLeft3);
        dest.writeString(this.footFeelingLeft4);
        dest.writeString(this.footFeelingLeft5);
        dest.writeString(this.footFeelingLeft6);
        dest.writeString(this.footFeelingLeft7);
        dest.writeString(this.footFeelingLeft8);
        dest.writeString(this.footFeelingLeft9);
        dest.writeString(this.footFeelingRight1);
        dest.writeString(this.footFeelingRight10);
        dest.writeString(this.footFeelingRight11);
        dest.writeString(this.footFeelingRight12);
        dest.writeString(this.footFeelingRight2);
        dest.writeString(this.footFeelingRight3);
        dest.writeString(this.footFeelingRight4);
        dest.writeString(this.footFeelingRight5);
        dest.writeString(this.footFeelingRight6);
        dest.writeString(this.footFeelingRight7);
        dest.writeString(this.footFeelingRight8);
        dest.writeString(this.footFeelingRight9);
        dest.writeString(this.hisTime);
        dest.writeString(this.leftLoss);
        dest.writeString(this.leftNormal);
        dest.writeString(this.leftRecession);
        dest.writeInt(this.measureItemId);
        dest.writeInt(this.patientCode);
        dest.writeString(this.patientName);
        dest.writeLong(this.planId);
        dest.writeString(this.rightLoss);
        dest.writeString(this.rightNormal);
        dest.writeString(this.rightRecession);
        dest.writeInt(this.serialId);
        dest.writeInt(this.skipFootFeeling);
    }

    public FootFeelingDataListBean() {
    }

    protected FootFeelingDataListBean(Parcel in) {
        this.checkDate = in.readInt();
        this.checkTime = in.readString();
        this.footFeelingLeft1 = in.readString();
        this.footFeelingLeft10 = in.readString();
        this.footFeelingLeft11 = in.readString();
        this.footFeelingLeft12 = in.readString();
        this.footFeelingLeft2 = in.readString();
        this.footFeelingLeft3 = in.readString();
        this.footFeelingLeft4 = in.readString();
        this.footFeelingLeft5 = in.readString();
        this.footFeelingLeft6 = in.readString();
        this.footFeelingLeft7 = in.readString();
        this.footFeelingLeft8 = in.readString();
        this.footFeelingLeft9 = in.readString();
        this.footFeelingRight1 = in.readString();
        this.footFeelingRight10 = in.readString();
        this.footFeelingRight11 = in.readString();
        this.footFeelingRight12 = in.readString();
        this.footFeelingRight2 = in.readString();
        this.footFeelingRight3 = in.readString();
        this.footFeelingRight4 = in.readString();
        this.footFeelingRight5 = in.readString();
        this.footFeelingRight6 = in.readString();
        this.footFeelingRight7 = in.readString();
        this.footFeelingRight8 = in.readString();
        this.footFeelingRight9 = in.readString();
        this.hisTime = in.readString();
        this.leftLoss = in.readString();
        this.leftNormal = in.readString();
        this.leftRecession = in.readString();
        this.measureItemId = in.readInt();
        this.patientCode = in.readInt();
        this.patientName = in.readString();
        this.planId = in.readLong();
        this.rightLoss = in.readString();
        this.rightNormal = in.readString();
        this.rightRecession = in.readString();
        this.serialId = in.readInt();
        this.skipFootFeeling = in.readInt();
    }

    public static final Creator<FootFeelingDataListBean> CREATOR = new Creator<FootFeelingDataListBean>() {
        @Override
        public FootFeelingDataListBean createFromParcel(Parcel source) {
            return new FootFeelingDataListBean(source);
        }

        @Override
        public FootFeelingDataListBean[] newArray(int size) {
            return new FootFeelingDataListBean[size];
        }
    };
}
