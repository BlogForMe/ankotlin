package com.comm.util.bean;

/**
 * @author : John
 * @date : 2018/8/9
 */
public class MsgShow {

    /**
     * content : 医生对2018-08-07的检测进行了回复,请点击"查看"浏览。
     * haveRead : 0
     * id : 55
     * receiveTarget : 42063
     * sendDttm : 20180808205518
     * title : 医生回复
     * type : 2
     * type_ : 2
     * userType : 1
     */

    private String content;
    private String haveRead;
    private String id;
    private String receiveTarget;
    private String sendDttm;
    private String title;
    private String type;
    private String type_;
    private String userType;
    private String dataCheckDttm;
    private String standbyField;


    public String getStandbyField() {
        return standbyField;
    }

    public String getDataCheckDttm() {
        return dataCheckDttm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHaveRead() {
        return haveRead;
    }

    public void setHaveRead(String haveRead) {
        this.haveRead = haveRead;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiveTarget() {
        return receiveTarget;
    }

    public void setReceiveTarget(String receiveTarget) {
        this.receiveTarget = receiveTarget;
    }

    public String getSendDttm() {
        return sendDttm;
    }

    public void setSendDttm(String sendDttm) {
        this.sendDttm = sendDttm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
