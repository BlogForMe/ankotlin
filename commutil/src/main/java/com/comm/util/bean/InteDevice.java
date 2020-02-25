package com.comm.util.bean;

/**
 * @author : John
 * @date : 2018/8/11
 */
public class InteDevice {
    //设备名称
    private String deviceName;
    //设备品牌代码
    private int mode;
    //别名
    private String deviceAlias;


    public String getDeviceName() {
        return deviceName;
    }

    public InteDevice setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public int getMode() {
        return mode;
    }

    public InteDevice setMode(int mode) {
        this.mode = mode;
        return this;
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public InteDevice setDeviceAlias(String deviceAlias) {
        this.deviceAlias = deviceAlias;
        return this;
    }
}
