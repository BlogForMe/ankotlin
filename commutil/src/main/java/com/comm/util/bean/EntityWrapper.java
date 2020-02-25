package com.comm.util.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : John
 * @date : 2018/9/10
 */
public class EntityWrapper implements Parcelable {
    private String initial;

    public String getInitial() {
        return initial;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.initial);
    }

    public EntityWrapper() {
    }

    protected EntityWrapper(Parcel in) {
        this.initial = in.readString();
    }

}
