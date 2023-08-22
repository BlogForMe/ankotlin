package com.kot.tool.shake

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.kot.R

/**
 * https://juejin.cn/post/6844903743595479054
 * https://github.com/taixiang/shake
 */
class ShakeActivity : AppCompatActivity() {
    /**
     * 传感器
     */
    private var sensorManager: SensorManager? = null
    private var shakeListener: ShakeSensorListener? = null

    /**
     * 判断一次摇一摇动作
     */
    private var isShake = false
    private var imgHand: ImageView? = null

    /**
     * 摇一摇动画
     */
    private var anim: ObjectAnimator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shake)
        imgHand = findViewById(R.id.imgHand)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        shakeListener = ShakeSensorListener()
//        anim = ObjectAnimator.ofFloat(imgHand, "rotation", 0f, 45f, -30f, 0f)
        anim?.duration = 500
        anim?.repeatCount = ValueAnimator.INFINITE
    }

    override fun onResume() {
        val sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if (sensor == null) {
            Log.i("ShakeActivity", "onResume: Failure! No magnetometer.")
        }
        //注册监听加速度传感器
        sensorManager?.registerListener(
            shakeListener,
            sensor,
            SensorManager.SENSOR_DELAY_FASTEST
        )
        super.onResume()
    }

    override fun onPause() {
        /**
         * 资源释放
         */
        sensorManager?.unregisterListener(shakeListener)
        super.onPause()
    }

    private inner class ShakeSensorListener : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            //避免一直摇
            if (isShake) {
                return
            }
            // 开始动画
            anim?.start()
            val values = event.values
            /*
             * x : x轴方向的重力加速度，向右为正
             * y : y轴方向的重力加速度，向前为正
             * z : z轴方向的重力加速度，向上为正
             */
            val x = Math.abs(values[0])
            val y = Math.abs(values[1])
            val z = Math.abs(values[2])

            Log.i("ShakeActivity", "onSensorChanged:  x $x , y  $y , z $z")
            //加速度超过19，摇一摇成功
            if (x > 19 || y > 19 || z > 19) {
                isShake = true
                //播放声音
                playSound(this@ShakeActivity)
                //震动，注意权限
                vibrate(500)
                //仿网络延迟操作，这里可以去请求服务器...
                Handler(Looper.getMainLooper()).postDelayed({ //弹框
                    showDialog()
                    //动画取消
                    anim?.cancel()
                }, 1000)
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    }

    private fun playSound(context: Context) {
        val player = MediaPlayer.create(context, R.raw.shake_sound)
        player.start()
    }

    private fun vibrate(milliseconds: Long) {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            (getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager).defaultVibrator
        } else {
            getSystemService(VIBRATOR_SERVICE) as Vibrator
        }

        //判断是否支持震动
        if (vibrator.hasVibrator()) {
            vibrator.cancel()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(150, 10))
            } else {
                vibrator.vibrate(milliseconds)
            }
        }
    }

    private fun showDialog() {
        val mAlertDialog = AlertDialog.Builder(this).show()
        val view = LayoutInflater.from(this).inflate(R.layout.layout_dialog, null)
        mAlertDialog.setContentView(view)
        mAlertDialog.setOnCancelListener { //这里让弹框取消后，才可以执行下一次的摇一摇
            isShake = false
            mAlertDialog.cancel()
        }
        val window = mAlertDialog.window
        window!!.setBackgroundDrawable(ColorDrawable(0x00000000))
    }
}