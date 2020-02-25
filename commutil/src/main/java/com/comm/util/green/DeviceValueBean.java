package com.comm.util.green;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 9/29/2017.
 */
@Entity
public class DeviceValueBean {
    @Id
    @Property(nameInDb = "_ID")
    private Long number;

    @Property
    private int pressureHighValue;

    @Property
    private int pressureLowValue;

    @Property
    private int jumpValue;

    @Property
    private double dataValue;

    @Property
    private String date;

    @Property
    private Date checkDate;

    @Property
    private boolean checkGls;

    @Property
    private int deviceType;

    @Property
    private int beforeMeal = 0;

    public String getCkeckTime() {
        return ckeckTime;
    }

    public void setCkeckTime(String ckeckTime) {
        this.ckeckTime = ckeckTime;
    }

    @Property
    private String  ckeckTime;
    @Property
    @Convert(converter = AlarmConverter.class, columnType = Integer.class)
    private Alarm alarm = Alarm.INIT;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Long getNumber() {
        return this.number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public int getPressureHighValue() {
        return this.pressureHighValue;
    }

    public void setPressureHighValue(int pressureHighValue) {
        this.pressureHighValue = pressureHighValue;
    }

    public int getPressureLowValue() {
        return this.pressureLowValue;
    }

    public void setPressureLowValue(int pressureLowValue) {
        this.pressureLowValue = pressureLowValue;
    }

    public int getJumpValue() {
        return this.jumpValue;
    }

    public void setJumpValue(int jumpValue) {
        this.jumpValue = jumpValue;
    }

    public double getDataValue() {
        return this.dataValue;
    }

//    public void setDataValue(int dataValue) {
//        this.dataValue = dataValue;
//    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
        checkDate = new Date();
    }

    public boolean isCheckGls() {
        return this.checkGls;
    }

    public void setCheckGls(boolean checkGls) {
        this.checkGls = checkGls;
    }

    public String getCheckDateFormat() {
        if (checkDate == null)return "";
        return new SimpleDateFormat("yyyyMMddHHmmss").format(checkDate);
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public boolean getCheckGls() {
        return this.checkGls;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public Alarm getAlarm() {
        return this.alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public int getBeforeMeal() {
        return this.beforeMeal;
    }

    public void setBeforeMeal(int beforeMeal) {
        this.beforeMeal = beforeMeal;
    }

    public void setDataValue(double dataValue) {
        this.dataValue = dataValue;
    }






    @Transient
    private boolean state;

    @Generated(hash = 1916061704)
    public DeviceValueBean(Long number, int pressureHighValue, int pressureLowValue,
                           int jumpValue, double dataValue, String date, Date checkDate, boolean checkGls,
                           int deviceType, int beforeMeal, String ckeckTime, Alarm alarm) {
        this.number = number;
        this.pressureHighValue = pressureHighValue;
        this.pressureLowValue = pressureLowValue;
        this.jumpValue = jumpValue;
        this.dataValue = dataValue;
        this.date = date;
        this.checkDate = checkDate;
        this.checkGls = checkGls;
        this.deviceType = deviceType;
        this.beforeMeal = beforeMeal;
        this.ckeckTime = ckeckTime;
        this.alarm = alarm;
    }

    @Generated(hash = 1557266673)
    public DeviceValueBean() {
    }


   public enum Alarm{
        INIT(0),
        ALARM(1),
        RELASE(2);

       final int id; // 使用稳定的 id 来转换，不要使用不稳定的名字和顺序

       Alarm(int id) {
           this.id = id;
       }
    }

    public static class AlarmConverter implements PropertyConverter<Alarm, Integer> {
        @Override
        public Alarm convertToEntityProperty(Integer databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            for (Alarm role : Alarm.values()) {
                if (role.id == databaseValue) {
                    return role;
                }
            }
            return Alarm.INIT; // 准备一个默认值，防止数据移除时崩溃
        }

        @Override
        public Integer convertToDatabaseValue(Alarm entityProperty) {
            // 判断返回 null
            return entityProperty == null ? null : entityProperty.id;
        }
    }
}
