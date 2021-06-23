package com.android.util.pro.bean;


import android.os.Parcel;
import android.os.Parcelable;
import android.text.ParcelableSpan;

/**
 * 测量结果的model
 */

public class ScaleMeasureResult implements Parcelable {


    public static final String TAG = "ScaleMeasureResult";

    public String userId;
    public int age;//年龄
    public int sex;//0男 1女
    public int height;//身高
    public int roleType;//0普通 1运动员

    public String measureTime;//测量时间:1991-06-13 10:08:08

    public boolean isOnlyWeightData;

    /*阻抗*/
    public float resistance;//电阻

    /*体脂率*/
    public float fat;

    /*体重*/
    public float weight;

    /*水分率*/
    public float waterRate;

    /*基础代谢率率*/
    public float bmr;

    /*内脏脂肪等级*/
    public float visceralFat;

    /*肌肉量*/
    public float muscleVolume;

    /*骨骼肌*/
    public float skeletalMuscle;

    /*骨量*/
    public float boneVolume;

    /*BMI*/
    public float bmi;

    /*蛋白质*/
    public float protein;

    /*身体得分*/
    public float bodyScore;

    /*身体年龄*/
    public float bodyAge;

    /*身体年龄*/
    public int heartRate;


    public String bluetoothName;
    public String bluetoothAddress;

    //体重单位
    public String weightUnit = "kg";

    //体脂单位 百分比
    public String fatUnit = "%";


    public ScaleMeasureResult() {
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


    public String getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(String measureTime) {
        this.measureTime = measureTime;
    }

    public float getResistance() {
        return resistance;
    }

    public void setResistance(float resistance) {
        this.resistance = resistance;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(float waterRate) {
        this.waterRate = waterRate;
    }

    public float getBmr() {
        return bmr;
    }

    public void setBmr(float bmr) {
        this.bmr = bmr;
    }

    public float getVisceralFat() {
        return visceralFat;
    }

    public void setVisceralFat(float visceralFat) {
        this.visceralFat = visceralFat;
    }

    public float getMuscleVolume() {
        return muscleVolume;
    }

    public void setMuscleVolume(float muscleVolume) {
        this.muscleVolume = muscleVolume;
    }

    public float getBoneVolume() {
        return boneVolume;
    }

    public void setBoneVolume(float boneVolume) {
        this.boneVolume = boneVolume;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getFatUnit() {
        return fatUnit;
    }

    public void setFatUnit(String fatUnit) {
        this.fatUnit = fatUnit;
    }

    public float getSkeletalMuscle() {
        return skeletalMuscle;
    }

    public void setSkeletalMuscle(float skeletalMuscle) {
        this.skeletalMuscle = skeletalMuscle;
    }

    public float getBodyScore() {
        return bodyScore;
    }

    public void setBodyScore(float bodyScore) {
        this.bodyScore = bodyScore;
    }

    public float getBodyAge() {
        return bodyAge;
    }

    public void setBodyAge(float bodyAge) {
        this.bodyAge = bodyAge;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public boolean isOnlyWeightData() {
        return isOnlyWeightData;
    }

    public void setOnlyWeightData(boolean onlyWeightData) {
        isOnlyWeightData = onlyWeightData;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }


    public String getBluetoothName() {
        return bluetoothName;
    }

    public void setBluetoothName(String bluetoothName) {
        this.bluetoothName = bluetoothName;
    }

    public String getBluetoothAddress() {
        return bluetoothAddress;
    }

    public void setBluetoothAddress(String bluetoothAddress) {
        this.bluetoothAddress = bluetoothAddress;
    }

    @Override
    public String toString() {
        return "ScaleMeasureResult{" +
                "userId='" + userId + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", roleType=" + roleType +
                ", measureTime='" + measureTime + '\'' +
                ", isOnlyWeightData=" + isOnlyWeightData +
                ", resistance=" + resistance +
                ", fat=" + fat +
                ", weight=" + weight +
                ", waterRate=" + waterRate +
                ", bmr=" + bmr +
                ", visceralFat=" + visceralFat +
                ", muscleVolume=" + muscleVolume +
                ", skeletalMuscle=" + skeletalMuscle +
                ", boneVolume=" + boneVolume +
                ", bmi=" + bmi +
                ", protein=" + protein +
                ", bodyScore=" + bodyScore +
                ", bodyAge=" + bodyAge +
                ", heartRate=" + heartRate +
                ", bluetoothName='" + bluetoothName + '\'' +
                ", bluetoothAddress='" + bluetoothAddress + '\'' +
                ", weightUnit='" + weightUnit + '\'' +
                ", fatUnit='" + fatUnit + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeInt(this.age);
        dest.writeInt(this.sex);
        dest.writeInt(this.height);
        dest.writeInt(this.roleType);
        dest.writeString(this.measureTime);
        dest.writeByte(this.isOnlyWeightData ? (byte) 1 : (byte) 0);
        dest.writeFloat(this.resistance);
        dest.writeFloat(this.fat);
        dest.writeFloat(this.weight);
        dest.writeFloat(this.waterRate);
        dest.writeFloat(this.bmr);
        dest.writeFloat(this.visceralFat);
        dest.writeFloat(this.muscleVolume);
        dest.writeFloat(this.skeletalMuscle);
        dest.writeFloat(this.boneVolume);
        dest.writeFloat(this.bmi);
        dest.writeFloat(this.protein);
        dest.writeFloat(this.bodyScore);
        dest.writeFloat(this.bodyAge);
        dest.writeInt(this.heartRate);
        dest.writeString(this.bluetoothName);
        dest.writeString(this.bluetoothAddress);
        dest.writeString(this.weightUnit);
        dest.writeString(this.fatUnit);
    }

    protected ScaleMeasureResult(Parcel in) {
        this.userId = in.readString();
        this.age = in.readInt();
        this.sex = in.readInt();
        this.height = in.readInt();
        this.roleType = in.readInt();
        this.measureTime = in.readString();
        this.isOnlyWeightData = in.readByte() != 0;
        this.resistance = in.readFloat();
        this.fat = in.readFloat();
        this.weight = in.readFloat();
        this.waterRate = in.readFloat();
        this.bmr = in.readFloat();
        this.visceralFat = in.readFloat();
        this.muscleVolume = in.readFloat();
        this.skeletalMuscle = in.readFloat();
        this.boneVolume = in.readFloat();
        this.bmi = in.readFloat();
        this.protein = in.readFloat();
        this.bodyScore = in.readFloat();
        this.bodyAge = in.readFloat();
        this.heartRate = in.readInt();
        this.bluetoothName = in.readString();
        this.bluetoothAddress = in.readString();
        this.weightUnit = in.readString();
        this.fatUnit = in.readString();
    }

    public static final Parcelable.Creator<ScaleMeasureResult> CREATOR = new Parcelable.Creator<ScaleMeasureResult>() {
        @Override
        public ScaleMeasureResult createFromParcel(Parcel source) {
            return new ScaleMeasureResult(source);
        }

        @Override
        public ScaleMeasureResult[] newArray(int size) {
            return new ScaleMeasureResult[size];
        }
    };
}
