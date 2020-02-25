package com.comm.util.speak;

import com.comm.util.bean.ErrorMessage;
import com.comm.util.green.Message;

/**
 * Created by Administrator on 9/5/2017.
 */

public interface ISpeakPlayEvent {
    void playStart(Message data);
    void playSuccess(Message data);
    void playError(ErrorMessage data);
}
