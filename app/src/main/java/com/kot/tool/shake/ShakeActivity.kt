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
import kotlin.math.log

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


//        val deviceSensors: List<Sensor> = sensorManager?.getSensorList(Sensor.TYPE_ALL)
//
        Sensor.TYPE_GRAVITY
        Sensor.TYPE_GYROSCOPE
        Sensor.TYPE_LINEAR_ACCELERATION


    }


    override fun onResume() {
        val sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if (sensor == null) {
            Log.i("ShakeActivity", "onResume: Failure! No magnetometer.")
            return
        }
        //注册监听加速度传感器
        val registerListener = sensorManager?.registerListener(
            shakeListener,
            sensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
        Log.i("TAG", "onResume: $registerListener")
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

        private val SHAKE_THRESHOLD_GRAVITY = 2.7f
        private val SHAKE_SLOP_TIME_MS = 500
        private val SHAKE_COUNT_RESET_TIME_MS = 3000


        val SENSITIVITY_LIGHT = 11
        val SENSITIVITY_MEDIUM = 13
        val SENSITIVITY_HARD = 15

        private val DEFAULT_ACCELERATION_THRESHOLD = SENSITIVITY_MEDIUM

        /**
         * When the magnitude of total acceleration exceeds this
         * value, the phone is accelerating.
         */
        private val accelerationThreshold = DEFAULT_ACCELERATION_THRESHOLD


        private var mLastUpdateTime: Long = 0
        private var mLastX = 0f
        private var mLastY = 0f
        private var mLastZ = 0f
        private var mShakeThreshold = 20


        override fun onSensorChanged(event: SensorEvent) {
            //避免一直摇
//            if (isShake) {
//                return
//            }
//            // 开始动画
//            anim?.start()
            val values = event.values
            /*

             * x : x轴方向的重力加速度，向右为正
             * y : y轴方向的重力加速度，向前为正
             * z : z轴方向的重力加速度，向上为正
             */
//            val x = Math.abs(values[0])
//            val y = Math.abs(values[1])
//            val z = Math.abs(values[2])

            val x = values[0]
            val y = values[1]
            val z = values[2]
            Log.i("ShakeActivity", "onSensorChanged:  x $x , y  $y , z $z")
////            加速度超过19，摇一摇成功
//            if (x > 19 || y > 19 || z > 19) {
//                isShake = true
//                //播放声音
//                playSound(this@ShakeActivity)
//                //震动，注意权限
//                vibrate(500)
//                //仿网络延迟操作，这里可以去请求服务器...
//                Handler(Looper.getMainLooper()).postDelayed({ //弹框
//                    showDialog()
//                    //动画取消
//                    anim?.cancel()
//                }, 1000)
//            }


//            val x = Math.abs(values[0])
//            val y = Math.abs(values[1])
//            val z = Math.abs(values[2])
//
//            val gX = x / SensorManager.GRAVITY_EARTH.toDouble()
//            val gY = y / SensorManager.GRAVITY_EARTH;
//            val gZ = z / SensorManager.GRAVITY_EARTH;
//
//            // gForce will be close to 1 when there is no movement.
//            val gForce = Math.sqrt(gX * gX + gY * gY + gZ * gZ);
//
//            Log.i("ShakeActivity", "onSensorChanged:  x $x , y  $y , z $z")
////            加速度超过19，摇一摇成功
////            if (gForce > SHAKE_THRESHOLD_GRAVITY) {
//            if (gForce > accelerationThreshold * accelerationThreshold) {
//                isShake = true
//                //播放声音
//                playSound(this@ShakeActivity)
//                //震动，注意权限
//                vibrate(500)
//                //仿网络延迟操作，这里可以去请求服务器...
//                Handler(Looper.getMainLooper()).postDelayed({ //弹框
//                    showDialog()
//                    //动画取消
//                    anim?.cancel()
//                }, 1000)
//            }


//            val currentTime = System.currentTimeMillis()
//            val diffTime: Long = currentTime - this.mLastUpdateTime
//            if (diffTime >= 100L) {
//                this.mLastUpdateTime = currentTime
//                val x = event.values[0]
//                val y = event.values[1]
//                val z = event.values[2]
//                val deltaX: Float = x - this.mLastX
//                val deltaY: Float = y - this.mLastY
//                val deltaZ: Float = z - this.mLastZ
//                this.mLastX = x
//                this.mLastY = y
//                this.mLastZ = z
//                val delta =
//                    Math.sqrt((deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ).toDouble())
//                        .toFloat() / diffTime.toFloat() * 10000.0f
//                val mIsShaking = delta > this.mShakeThreshold.toFloat()
//                if (mIsShaking) {
//                    startShake()
//                }
//            }

        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            Log.i("TAG", "onAccuracyChanged: ")
        }
    }


    fun startShake() {
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