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
import android.os.Bundle
import android.os.Handler
import android.os.Vibrator
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
    private val anim: ObjectAnimator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shake)
        imgHand = findViewById(R.id.imgHand)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        shakeListener = ShakeSensorListener()

        anim?.duration = 500
        anim?.repeatCount = ValueAnimator.INFINITE
    }

    override fun onResume() {
        //注册监听加速度传感器
        sensorManager?.registerListener(
            shakeListener,
            sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
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
            //加速度超过19，摇一摇成功
            if (x > 19 || y > 19 || z > 19) {
                isShake = true
                //播放声音
                playSound(this@ShakeActivity)
                //震动，注意权限
                vibrate(500)
                //仿网络延迟操作，这里可以去请求服务器...
                Handler().postDelayed({ //弹框
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
        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(milliseconds)
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