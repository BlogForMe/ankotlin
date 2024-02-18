package com.kot.tool.shake.sensor;

import com.alibaba.fastjson.JSONObject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kot.tool.shake.util.Callback;
import com.kot.tool.shake.util.CommonUtils;

/**
 * ClassName:      GyroscopeSensorService
 * Description:    Description
 * Author:         zh
 * CreateDate:     02/02/2024 17:23
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */

public class GyroscopeSensorService extends SensorService {
    private static final int DELAY_DEFAULT = 50;
    private static final int DELAY_GAME = 20;
    private static final int DELAY_UI = 60;
    private static final int DELAY_NORMAL = 200;
    private SensorEventListener gyroscopeListener = new SensorChangedListener();
    private SensorEventListener accelerometerListener = new SensorChangedListener();
    private SensorEventListener magneticFieldListener = new SensorChangedListener();
    private float[] accelerometerValues;
    private float[] magneticFieldValues;
    private float[] gyroscopeValues;
    private volatile int delay = 50;
    private long lastSendTime = System.currentTimeMillis();
    private Callback mCallback;
    private Context mContext;
    private float mInterval;
    private boolean hasRegistered;

    public GyroscopeSensorService() {
    }

    public void onCreate(Context context, JSONObject params) {
        this.mContext = context;
        this.mInterval = CommonUtils.getFloat(params, "interval", 0.5F);
    }

    public void register(Callback callback) {
        if (!this.hasRegistered) {
            this.hasRegistered = true;
            SensorManager sensorManager = (SensorManager)this.mContext.getSystemService("sensor");
            if (sensorManager != null) {
                Sensor sensor = sensorManager.getDefaultSensor(4);
                Sensor sensorAccelerometer = sensorManager.getDefaultSensor(1);
                Sensor sensorMagneticField = sensorManager.getDefaultSensor(2);
                this.mCallback = callback;
                this.delay = 50;
                if (this.mInterval != 0.0F) {
                    this.delay = (int)(this.mInterval * 1000.0F);
                }

                int samplingPeriodUs = 3;
                if (this.delay >= 0 && this.delay < 20) {
                    samplingPeriodUs = 1;
                } else if (this.delay >= 20 && this.delay < 60) {
                    samplingPeriodUs = 1;
                } else if (this.delay >= 60 && this.delay < 200) {
                    samplingPeriodUs = 2;
                }

                sensorManager.registerListener(this.gyroscopeListener, sensor, samplingPeriodUs);
                sensorManager.registerListener(this.accelerometerListener, sensorAccelerometer,
                    samplingPeriodUs);
                sensorManager.registerListener(this.magneticFieldListener, sensorMagneticField,
                    samplingPeriodUs);
            }
        }
    }

    public void unregister() {
        if (this.hasRegistered) {
            this.hasRegistered = false;
            SensorManager sensorManager = (SensorManager)this.mContext.getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.gyroscopeListener);
                sensorManager.unregisterListener(this.accelerometerListener);
                sensorManager.unregisterListener(this.magneticFieldListener);
            }
        }
    }

    public void onDestroy() {
        this.mContext = null;
        this.mCallback = null;
        this.accelerometerValues = null;
        this.magneticFieldValues = null;
        this.gyroscopeValues = null;
    }

    private void sendDataIfNeed() {
        if (this.accelerometerValues != null && this.magneticFieldValues != null
            && this.gyroscopeValues != null) {
            long now = System.currentTimeMillis();
            if (now - this.lastSendTime >= (long)this.delay) {
                this.lastSendTime = now;
                float x = this.gyroscopeValues[0];
                float y = this.gyroscopeValues[1];
                float z = this.gyroscopeValues[2];
                if (this.mCallback != null) {
                    JSONObject result = new JSONObject();
                    result.put("x", x);
                    result.put("y", y);
                    result.put("z", z);
                    this.mCallback.onTrigger(result, 4);
                }
            }
        }
    }

    private class SensorChangedListener implements SensorEventListener {
        private SensorChangedListener() {
        }

        public void onSensorChanged(SensorEvent event) {
            if (event != null && event.values != null && event.sensor != null) {
                int eventType = event.sensor.getType();
                if (eventType == 1) {
                    GyroscopeSensorService.this.accelerometerValues = event.values;
                } else if (eventType == 2) {
                    GyroscopeSensorService.this.magneticFieldValues = event.values;
                } else if (eventType == 4) {
                    GyroscopeSensorService.this.gyroscopeValues = event.values;
                }

                GyroscopeSensorService.this.sendDataIfNeed();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }
}