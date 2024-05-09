package com.kot.tool.shake.sensor;

/**
 * ClassName:      AccelerometerForH5SensorService
 * Description:    Description
 * Author:         zh
 * CreateDate:     02/02/2024 17:39
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kot.tool.shake.util.Callback;
import com.kot.tool.shake.util.CommonUtils;

import com.alibaba.fastjson.JSONObject;

public class AccelerometerForH5SensorService extends SensorService {
    private Context mContext;
    private float mInterval;
    private int mSpeedThreshold;
    private int mCountsLimited;
    private Callback mCallback;
    private long mLastUpdateTime;
    private int mShakeCounts = 0;
    private float lastX;
    private float lastY;
    private float lastZ;
    private boolean hasRegistered;
    private SensorEventListener mSensorEventListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent intent) {
            long currentUpdateTime = System.currentTimeMillis();
            long timeInterval = currentUpdateTime
                - AccelerometerForH5SensorService.this.mLastUpdateTime;
            if (!((float)timeInterval < AccelerometerForH5SensorService.this.mInterval)) {
                AccelerometerForH5SensorService.this.mLastUpdateTime = currentUpdateTime;
                float x = intent.values[0];
                float y = intent.values[1];
                float z = intent.values[2];
                float deltaX = x - AccelerometerForH5SensorService.this.lastX;
                float deltaY = y - AccelerometerForH5SensorService.this.lastY;
                float deltaZ = z - AccelerometerForH5SensorService.this.lastZ;
                AccelerometerForH5SensorService.this.lastX = x;
                AccelerometerForH5SensorService.this.lastY = y;
                AccelerometerForH5SensorService.this.lastZ = z;
                double speed = Math.sqrt(
                    (double)(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ))
                    / (double)timeInterval * 10000.0;
                if (!(speed < (double)AccelerometerForH5SensorService.this.mSpeedThreshold)) {
                    if (AccelerometerForH5SensorService.this.mShakeCounts
                        < AccelerometerForH5SensorService.this.mCountsLimited) {
                        AccelerometerForH5SensorService.this.mShakeCounts++;
                    } else {
                        AccelerometerForH5SensorService.this.mShakeCounts = 0;
                        AccelerometerForH5SensorService.this.unregister();
                        AccelerometerForH5SensorService.this.mCallback.onTrigger((JSONObject)null,
                            0);
                    }
                }
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    public AccelerometerForH5SensorService() {
    }

    public void onCreate(Context context, JSONObject params) {
        this.mContext = context;
        this.mInterval = CommonUtils.getFloat(params, "interval", 100.0F);
        this.mSpeedThreshold = CommonUtils.getInt(params, "speedThreshold", 1100);
        this.mCountsLimited = CommonUtils.getInt(params, "countsLimited", 2);
    }

    public void register(Callback callback) {
        if (!this.hasRegistered) {
            this.hasRegistered = true;
            this.mCallback = callback;
            SensorManager sensorManager = (SensorManager)this.mContext.getSystemService("sensor");
            int rate = 3;
            Sensor sensor = sensorManager.getDefaultSensor(1);
            sensorManager.registerListener(this.mSensorEventListener, sensor, rate);
        }
    }

    public void unregister() {
        if (this.hasRegistered) {
            this.hasRegistered = false;
            SensorManager sensorManager = (SensorManager)this.mContext.getSystemService("sensor");
            sensorManager.unregisterListener(this.mSensorEventListener);
        }
    }

    public void onDestroy() {
        this.mContext = null;
        this.mCallback = null;
        this.mSensorEventListener = null;
    }
}
