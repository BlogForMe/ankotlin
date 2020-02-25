package com.comm.util.bean;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : John
 * @date : 2018/7/25
 */

public class BleDevice implements Parcelable {
    private BluetoothDevice mDevice;
    private int model;
    private String deviceAlias;
    private String deviceName;
    private String mac;


    public BleDevice(BluetoothDevice mDevice, int model, String deviceAlias) {
        this.mDevice = mDevice;
        this.deviceName = mDevice.getName();
        this.mac = mDevice.getAddress();
        this.model = model;
        this.deviceAlias = deviceAlias;

    }

    public BluetoothDevice getmDevice() {
        return mDevice;
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public String getName() {
        if (mDevice != null)
            return mDevice.getName();
        return null;
    }

    public String getMac() {
        if (mDevice != null)
            return mDevice.getAddress();
        return null;
    }

    public String getKey() {
        if (mDevice != null) {
            return mDevice.getName() + mDevice.getAddress();
        }
        return "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mDevice, flags);
        dest.writeInt(this.model);
        dest.writeString(this.deviceAlias);
    }

    protected BleDevice(Parcel in) {
        this.mDevice = in.readParcelable(BluetoothDevice.class.getClassLoader());
        this.model = in.readInt();
        this.deviceAlias = in.readString();
    }

    public static final Creator<BleDevice> CREATOR = new Creator<BleDevice>() {
        @Override
        public BleDevice createFromParcel(Parcel source) {
            return new BleDevice(source);
        }

        @Override
        public BleDevice[] newArray(int size) {
            return new BleDevice[size];
        }
    };
}
