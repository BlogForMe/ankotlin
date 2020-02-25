package com.comm.util.bean;

import com.comm.util.green.Message;

/**
 *   错误消息 --百度语音
 * Created by Administrator on 12/1/2017.
 */

public class ErrorMessage {

    public ErrorMessage(String description) {
        this.description = description;
    }

    public ErrorMessage(int code, String description, String error, Message message) {
        this.code = code;
        this.description = description;
        this.error = error;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    private int code;
    private String description;
    private String error;
    private Message message;


    @Override
    public String toString() {
        return "ErrorMessage{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", error='" + error + '\'' +
                ", message=" + message +
                '}';
    }
}
