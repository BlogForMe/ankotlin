package com.comm.util.bean;


import android.os.Parcel;
import android.os.Parcelable;

/**
 *   分为4条消息
 * Created by cyh on 2017/11/24.
 */

public class FootDataBean implements Parcelable {

    private int id;
    private String temperatureForehead;
    private String temperatureTorso;
    private String temperatureLeftFoot;
    private String temperatureRightFoot;
    private String temperatureMeasureTime;
    private String pictureLeftInstep;  // 左脚背
    private String pictureLeftSole; // 左脚底
    private String pictureRightInstep;  // 右脚背
    private String picureRightSole;  // 右脚底
    private String pictureMeasuereTime;  //测量时间
    private String bloodPresureHigh; //血压高值
    private String bloodPresureLow;
    private String bloodPresurePulse;
    private String bloodPresureMeasureTime;
    private String bloodOxgen;  //血氧
    private String bloodPulse;  //脉搏
    private String bloodPerfusion;  //灌注值
    private String bloodOxgenMeasureTime;
    private String footFeelingLeft1; //足感左脚1
    private String footFeelingLeft2;
    private String footFeelingLeft3;
    private String footFeelingLeft4;
    private String footFeelingLeft5;
    private String footFeelingLeft6;
    private String footFeelingLeft7;
    private String footFeelingLeft8;
    private String footFeelingLeft9;
    private String footFeelingLeft10;
    private String footFeelingLeft11;
    private String footFeelingLeft12;
    private String footFeelingRight1;
    private String footFeelingRight2;
    private String footFeelingRight3;
    private String footFeelingRight4;
    private String footFeelingRight5;
    private String footFeelingRight6;
    private String footFeelingRight7;
    private String footFeelingRight8;
    private String footFeelingRight9;
    private String footFeelingRight10;
    private String footFeelingRight11;
    private String footFeelingRight12;
    private String footFeelingMeasureTime;
    private String bloodGlucoseBefore;// 血糖
    private String bloodGlucoseAfter;// 血糖
    private String bloodGlucoseMeasureTime;// 血糖
    private String reportContent;// 报告内容
    private String reportUpdateTime;//报告更新时间
    private String rightNormal;
    private String rightLoss;
    private String rightRecession;
    private String leftNormal;
    private String leftLoss;
    private String leftRecession;


    public String getRightNormal() {
        return rightNormal;
    }

    public void setRightNormal(String rightNormal) {
        this.rightNormal = rightNormal;
    }

    public String getRightLoss() {
        return rightLoss;
    }

    public void setRightLoss(String rightLoss) {
        this.rightLoss = rightLoss;
    }

    public String getRightRecession() {
        return rightRecession;
    }

    public void setRightRecession(String rightRecession) {
        this.rightRecession = rightRecession;
    }

    public String getLeftNormal() {
        return leftNormal;
    }

    public void setLeftNormal(String leftNormal) {
        this.leftNormal = leftNormal;
    }

    public String getLeftLoss() {
        return leftLoss;
    }

    public void setLeftLoss(String leftLoss) {
        this.leftLoss = leftLoss;
    }

    public String getLeftRecession() {
        return leftRecession;
    }

    public void setLeftRecession(String leftRecession) {
        this.leftRecession = leftRecession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTemperatureForehead() {
        return temperatureForehead;
    }

    public void setTemperatureForehead(String temperatureForehead) {
        this.temperatureForehead = temperatureForehead;
    }

    public String getTemperatureTorso() {
        return temperatureTorso;
    }

    public void setTemperatureTorso(String temperatureTorso) {
        this.temperatureTorso = temperatureTorso;
    }

    public String getTemperatureLeftFoot() {
        return temperatureLeftFoot;
    }

    public void setTemperatureLeftFoot(String temperatureLeftFoot) {
        this.temperatureLeftFoot = temperatureLeftFoot;
    }

    public String getTemperatureRightFoot() {
        return temperatureRightFoot;
    }

    public void setTemperatureRightFoot(String temperatureRightFoot) {
        this.temperatureRightFoot = temperatureRightFoot;
    }

    public String getTemperatureMeasureTime() {
        return temperatureMeasureTime;
    }

    public void setTemperatureMeasureTime(String temperatureMeasureTime) {
        this.temperatureMeasureTime = temperatureMeasureTime;
    }

    public String getPictureLeftInstep() {
        return pictureLeftInstep;
    }

    public void setPictureLeftInstep(String pictureLeftInstep) {
        this.pictureLeftInstep = pictureLeftInstep;
    }

    public String getPictureLeftSole() {
        return pictureLeftSole;
    }

    public void setPictureLeftSole(String pictureLeftSole) {
        this.pictureLeftSole = pictureLeftSole;
    }

    public String getPictureRightInstep() {
        return pictureRightInstep;
    }

    public void setPictureRightInstep(String pictureRightInstep) {
        this.pictureRightInstep = pictureRightInstep;
    }

    public String getPicureRightSole() {
        return picureRightSole;
    }

    public void setPicureRightSole(String picureRightSole) {
        this.picureRightSole = picureRightSole;
    }

    public String getPictureMeasuereTime() {
        return pictureMeasuereTime;
    }

    public void setPictureMeasuereTime(String pictureMeasuereTime) {
        this.pictureMeasuereTime = pictureMeasuereTime;
    }

    public String getBloodPresureHigh() {
        return bloodPresureHigh;
    }

    public void setBloodPresureHigh(String bloodPresureHigh) {
        this.bloodPresureHigh = bloodPresureHigh;
    }

    public String getBloodPresureLow() {
        return bloodPresureLow;
    }

    public void setBloodPresureLow(String bloodPresureLow) {
        this.bloodPresureLow = bloodPresureLow;
    }


    public String getBloodOxgen() {
        return bloodOxgen;
    }

    public void setBloodOxgen(String bloodOxgen) {
        this.bloodOxgen = bloodOxgen;
    }

    public String getBloodOxgenMeasureTime() {
        return bloodOxgenMeasureTime;
    }

    public void setBloodOxgenMeasureTime(String bloodOxgenMeasureTime) {
        this.bloodOxgenMeasureTime = bloodOxgenMeasureTime;
    }

    public String getFootFeelingLeft1() {
        return footFeelingLeft1;
    }

    public void setFootFeelingLeft1(String footFeelingLeft1) {
        this.footFeelingLeft1 = footFeelingLeft1;
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

    public String getFootFeelingRight1() {
        return footFeelingRight1;
    }

    public void setFootFeelingRight1(String footFeelingRight1) {
        this.footFeelingRight1 = footFeelingRight1;
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

    public String getFootFeelingMeasureTime() {
        return footFeelingMeasureTime;
    }

    public void setFootFeelingMeasureTime(String footFeelingMeasureTime) {
        this.footFeelingMeasureTime = footFeelingMeasureTime;
    }

    public String getBloodGlucoseBefore() {
        return bloodGlucoseBefore;
    }

    public void setBloodGlucoseBefore(String bloodGlucoseBefore) {
        this.bloodGlucoseBefore = bloodGlucoseBefore;
    }

    public String getBloodGlucoseAfter() {
        return bloodGlucoseAfter;
    }

    public void setBloodGlucoseAfter(String bloodGlucoseAfter) {
        this.bloodGlucoseAfter = bloodGlucoseAfter;
    }

    public String getBloodGlucoseMeasureTime() {
        return bloodGlucoseMeasureTime;
    }

    public void setBloodGlucoseMeasureTime(String bloodGlucoseMeasureTime) {
        this.bloodGlucoseMeasureTime = bloodGlucoseMeasureTime;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportUpdateTime() {
        return reportUpdateTime;
    }

    public void setReportUpdateTime(String reportUpdateTime) {
        this.reportUpdateTime = reportUpdateTime;
    }

    public String getBloodPresureMeasureTime() {
        return bloodPresureMeasureTime;
    }

    public void setBloodPresureMeasureTime(String bloodPresureMeasureTime) {
        this.bloodPresureMeasureTime = bloodPresureMeasureTime;
    }

    public String getBloodPulse() {
        return bloodPulse;
    }

    public void setBloodPulse(String bloodPulse) {
        this.bloodPulse = bloodPulse;
    }

    public String getBloodPerfusion() {
        return bloodPerfusion;
    }

    public void setBloodPerfusion(String bloodPerfusion) {
        this.bloodPerfusion = bloodPerfusion;
    }

    public String getBloodPresurePulse() {
        return bloodPresurePulse;
    }

    public void setBloodPresurePulse(String bloodPresurePulse) {
        this.bloodPresurePulse = bloodPresurePulse;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.temperatureForehead);
        dest.writeString(this.temperatureTorso);
        dest.writeString(this.temperatureLeftFoot);
        dest.writeString(this.temperatureRightFoot);
        dest.writeString(this.temperatureMeasureTime);
        dest.writeString(this.pictureLeftInstep);
        dest.writeString(this.pictureLeftSole);
        dest.writeString(this.pictureRightInstep);
        dest.writeString(this.picureRightSole);
        dest.writeString(this.pictureMeasuereTime);
        dest.writeString(this.bloodPresureHigh);
        dest.writeString(this.bloodPresureLow);
        dest.writeString(this.bloodPresurePulse);
        dest.writeString(this.bloodPresureMeasureTime);
        dest.writeString(this.bloodOxgen);
        dest.writeString(this.bloodPulse);
        dest.writeString(this.bloodPerfusion);
        dest.writeString(this.bloodOxgenMeasureTime);
        dest.writeString(this.footFeelingLeft1);
        dest.writeString(this.footFeelingLeft2);
        dest.writeString(this.footFeelingLeft3);
        dest.writeString(this.footFeelingLeft4);
        dest.writeString(this.footFeelingLeft5);
        dest.writeString(this.footFeelingLeft6);
        dest.writeString(this.footFeelingLeft7);
        dest.writeString(this.footFeelingLeft8);
        dest.writeString(this.footFeelingLeft9);
        dest.writeString(this.footFeelingLeft10);
        dest.writeString(this.footFeelingLeft11);
        dest.writeString(this.footFeelingLeft12);
        dest.writeString(this.footFeelingRight1);
        dest.writeString(this.footFeelingRight2);
        dest.writeString(this.footFeelingRight3);
        dest.writeString(this.footFeelingRight4);
        dest.writeString(this.footFeelingRight5);
        dest.writeString(this.footFeelingRight6);
        dest.writeString(this.footFeelingRight7);
        dest.writeString(this.footFeelingRight8);
        dest.writeString(this.footFeelingRight9);
        dest.writeString(this.footFeelingRight10);
        dest.writeString(this.footFeelingRight11);
        dest.writeString(this.footFeelingRight12);
        dest.writeString(this.footFeelingMeasureTime);
        dest.writeString(this.bloodGlucoseBefore);
        dest.writeString(this.bloodGlucoseAfter);
        dest.writeString(this.bloodGlucoseMeasureTime);
        dest.writeString(this.reportContent);
        dest.writeString(this.reportUpdateTime);
        dest.writeString(this.rightNormal);
        dest.writeString(this.rightLoss);
        dest.writeString(this.rightRecession);
        dest.writeString(this.leftNormal);
        dest.writeString(this.leftLoss);
        dest.writeString(this.leftRecession);
    }

    public FootDataBean() {
    }

    protected FootDataBean(Parcel in) {
        this.id = in.readInt();
        this.temperatureForehead = in.readString();
        this.temperatureTorso = in.readString();
        this.temperatureLeftFoot = in.readString();
        this.temperatureRightFoot = in.readString();
        this.temperatureMeasureTime = in.readString();
        this.pictureLeftInstep = in.readString();
        this.pictureLeftSole = in.readString();
        this.pictureRightInstep = in.readString();
        this.picureRightSole = in.readString();
        this.pictureMeasuereTime = in.readString();
        this.bloodPresureHigh = in.readString();
        this.bloodPresureLow = in.readString();
        this.bloodPresurePulse = in.readString();
        this.bloodPresureMeasureTime = in.readString();
        this.bloodOxgen = in.readString();
        this.bloodPulse = in.readString();
        this.bloodPerfusion = in.readString();
        this.bloodOxgenMeasureTime = in.readString();
        this.footFeelingLeft1 = in.readString();
        this.footFeelingLeft2 = in.readString();
        this.footFeelingLeft3 = in.readString();
        this.footFeelingLeft4 = in.readString();
        this.footFeelingLeft5 = in.readString();
        this.footFeelingLeft6 = in.readString();
        this.footFeelingLeft7 = in.readString();
        this.footFeelingLeft8 = in.readString();
        this.footFeelingLeft9 = in.readString();
        this.footFeelingLeft10 = in.readString();
        this.footFeelingLeft11 = in.readString();
        this.footFeelingLeft12 = in.readString();
        this.footFeelingRight1 = in.readString();
        this.footFeelingRight2 = in.readString();
        this.footFeelingRight3 = in.readString();
        this.footFeelingRight4 = in.readString();
        this.footFeelingRight5 = in.readString();
        this.footFeelingRight6 = in.readString();
        this.footFeelingRight7 = in.readString();
        this.footFeelingRight8 = in.readString();
        this.footFeelingRight9 = in.readString();
        this.footFeelingRight10 = in.readString();
        this.footFeelingRight11 = in.readString();
        this.footFeelingRight12 = in.readString();
        this.footFeelingMeasureTime = in.readString();
        this.bloodGlucoseBefore = in.readString();
        this.bloodGlucoseAfter = in.readString();
        this.bloodGlucoseMeasureTime = in.readString();
        this.reportContent = in.readString();
        this.reportUpdateTime = in.readString();
        this.rightNormal = in.readString();
        this.rightLoss = in.readString();
        this.rightRecession = in.readString();
        this.leftNormal = in.readString();
        this.leftLoss = in.readString();
        this.leftRecession = in.readString();
    }

    public static final Creator<FootDataBean> CREATOR = new Creator<FootDataBean>() {
        @Override
        public FootDataBean createFromParcel(Parcel source) {
            return new FootDataBean(source);
        }

        @Override
        public FootDataBean[] newArray(int size) {
            return new FootDataBean[size];
        }
    };
}
