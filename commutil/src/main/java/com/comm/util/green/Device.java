package com.comm.util.green;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by Administrator on 9/13/2017.
 */
@Entity
public class Device {
    @Id
    @Property(nameInDb = "_ID")
    private Long id;

    @Property
    private int deviceType;

    @Property
    private String shortAdress;

    @Property
    private String ieeAdress;

    @Property
    private boolean state;

    @Property
    private String softVersion;

    @Property
    private String hardwareVersion;

    public Device(int deviceType, String shortAdress, String ieeAdress) {
        this.deviceType = deviceType;
        this.shortAdress = shortAdress;
        this.ieeAdress = ieeAdress;
    }

    @Generated(hash = 1026727481)
    public Device(Long id, int deviceType, String shortAdress, String ieeAdress,
                  boolean state, String softVersion, String hardwareVersion) {
        this.id = id;
        this.deviceType = deviceType;
        this.shortAdress = shortAdress;
        this.ieeAdress = ieeAdress;
        this.state = state;
        this.softVersion = softVersion;
        this.hardwareVersion = hardwareVersion;
    }

    @Generated(hash = 1469582394)
    public Device() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getShortAdress() {
        return this.shortAdress;
    }

    public void setShortAdress(String shortAdress) {
        this.shortAdress = shortAdress;
    }

    public String getIeeAdress() {
        return this.ieeAdress;
    }

    public void setIeeAdress(String ieeAdress) {
        this.ieeAdress = ieeAdress;
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSoftVersion() {
        return this.softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public String getHardwareVersion() {
        return this.hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

}
