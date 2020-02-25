package com.comm.util.speak;

import android.content.Context;

/**
 * Created by Administrator on 8/31/2017.
 */

public interface ISpeak {
    void init(Context context);
    void speak(String message);
    void add(ISpeakPlayEvent speakPlayEvent);
    void remove(ISpeakPlayEvent speakPlayEvent);
    void release();
    void stop();
    void setStereoVolume(float left, float right);
    boolean checkInitSuccess();
    void setLanguage(int language);
    void addSpeakInitInterface(SpeakInitInterface initInterface);
    void removeSpeakInitInterface(SpeakInitInterface initInterface);
}
