package com.kot.tool.shake.sensor;

/**
 * ClassName:      CompassSensorService
 * Description:    Description
 * Author:         zh
 * CreateDate:     02/02/2024 17:41
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

public class CompassSensorService extends SensorService {
    private volatile float mInterval;
    private Long mLastSendTime = System.currentTimeMillis();
    private float[] mMagneticValues;
    private float[] mAccelerateValues;
    private Callback mCallback;
    private Context mContext;
    private boolean hasRegistered;
    private SensorEventListener mSensorEventListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent intent) {
            if (intent != null && intent.values != null && intent.sensor != null) {
                int type = intent.sensor.getType();
                if (type == 2 || type == 1) {
                    if ((float)(System.currentTimeMillis()
                        - CompassSensorService.this.mLastSendTime)
                        > CompassSensorService.this.mInterval) {
                        CompassSensorService.this.mLastSendTime = System.currentTimeMillis();

                        try {
                            if (type == 2) {
                                CompassSensorService.this.mMagneticValues = intent.values;
                            }

                            if (type == 1) {
                                CompassSensorService.this.mAccelerateValues = intent.values;
                            }

                            if (CompassSensorService.this.mCallback == null
                                || CompassSensorService.this.mMagneticValues == null
                                || CompassSensorService.this.mAccelerateValues == null) {
                                return;
                            }

                            CompassSensorService.this.sendSensorResult(
                                CompassSensorService.this.mCallback,
                                CompassSensorService.this.mMagneticValues,
                                CompassSensorService.this.mAccelerateValues);
                        } catch (Exception var4) {
                        }
                    }

                }
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    public CompassSensorService() {
    }

    public void onCreate(Context context, JSONObject params) {
        this.mContext = context;
        this.mInterval = CommonUtils.getFloat(params, "interval", 100.0F);
    }

    public void register(Callback callback) {
        if (!this.hasRegistered) {
            this.hasRegistered = true;
            this.mCallback = callback;
            int rate = 3;
            SensorManager sensorManager = (SensorManager)this.mContext.getSystemService("sensor");
            Sensor magneticSensor = sensorManager.getDefaultSensor(2);
            Sensor accelerometerSensor = sensorManager.getDefaultSensor(1);
            sensorManager.registerListener(this.mSensorEventListener, magneticSensor, rate);
            sensorManager.registerListener(this.mSensorEventListener, accelerometerSensor, rate);
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
        this.mSensorEventListener = null;
        this.mCallback = null;
        this.mContext = null;
    }

    protected void sendSensorResult(Callback callback, float[] magneticValues,
                                    float[] accelerateValues) {
        JSONObject param = new JSONObject();
        float[] calValues = new float[3];
        float[] R = new float[9];
        SensorManager.getRotationMatrix(R, (float[])null, accelerateValues, magneticValues);
        SensorManager.getOrientation(R, calValues);
        calValues[0] = (float)Math.toDegrees((double)calValues[0]);
        int direction = (int)((calValues[0] + 360.0F) % 360.0F);
        param.put("direction", direction);
        callback.onTrigger(param, 2);
    }
}
