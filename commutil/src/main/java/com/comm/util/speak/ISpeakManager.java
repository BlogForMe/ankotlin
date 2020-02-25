package com.comm.util.speak;

import com.comm.util.green.Message;

import java.util.List;

/**
 * Created by Administrator on 9/15/2017.
 */

public interface ISpeakManager {
    void init();
    void addSpeakPlayEvent(ISpeakPlayEvent speakPlayEvent);
    void addPlay(Message data);
    void addListPlay(List<Message> datas);
    void addPlayToFist(Message data);
    void removePlay(Message data);
    void removePlay(int messageType);
    void play();
    void pause();
    void setCheckPause(boolean checkPause);
    void release();

    /**
     * 停止播放消息，当前播放的也会停止
     */
    void stop();

    /**
     * 停止播放，但是当前正在播放的还会播放
     */
    void stopPalyNextMessage();
    void setStereoVolume(float left, float right);
    boolean checkInitSuccess();
    void setLanguage(int language);
    boolean checkHasMessage();

    void removeSpeakPlayEvent(ISpeakPlayEvent speakPlayEvent);

    void setPalyHelp(boolean palyHelp);

    boolean isHelp(); //使用帮助

    void setSpeakPF(ISpeak mSpeak);
}
