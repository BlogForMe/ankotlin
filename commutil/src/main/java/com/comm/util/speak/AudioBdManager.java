package com.comm.util.speak;

import android.content.Context;

import com.comm.util.data.ServiceFactory;
import com.comm.util.green.Message;

/**
 * @author : John
 * @date : 2018/8/15
 */
public class AudioBdManager {

    private static AudioBdManager mySynthensizer;

    private Context context;

    public static AudioBdManager getInstance(Context context) {

        if (mySynthensizer == null) {
            mySynthensizer = new AudioBdManager();
        }
        return mySynthensizer;
    }

//    private AudioBdManager(Context context) {
//        this.context = context;
////        if (SWITCH_BUTTON) {
////        initialTts(); // 初始化TTS引擎
////        }
//    }


    public static AudioBdManager getInstance() {

        if (mySynthensizer == null) {
            mySynthensizer = new AudioBdManager();
        }
        return mySynthensizer;
    }

    public void boxSpeak(String txt) {
        ISpeakManager mSpeakManager = ServiceFactory.getInstance().getmPatientService().getSpeakManager();
        if (mSpeakManager == null) {
            return;
        }
        com.comm.util.green.Message message = new com.comm.util.green.Message();
        message.setRemindContent(txt);
        mSpeakManager.addPlay(message);
    }


    public void speak(String txt) {
        ISpeakManager mSpeakManager = ServiceFactory.getInstance().getmPatientService().getSpeakManager();
        if (mSpeakManager == null) {
            return;
        }
        Message message = new Message();
        message.setRemindContent(txt);
        mSpeakManager.addPlay(message);
    }

    //停止播放
    public void stopSpeak() {
        ISpeakManager mSpeakManager = ServiceFactory.getInstance().getmPatientService().getSpeakManager();
        if (mSpeakManager == null) {
            return;
        }
    }

    //停止播放
    public void stopNextSpeak() {
        ISpeakManager mSpeakManager = ServiceFactory.getInstance().getmPatientService().getSpeakManager();
        if (mSpeakManager == null) {
            return;
        }
        mSpeakManager.stop();
        mSpeakManager.stopPalyNextMessage();
    }


}
