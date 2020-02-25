package com.comm.util.bean;

public class CommentBean {


    /**
     * count : 1
     * dataList : [{"businessId":"1","businessType":"1","commentContent":"w我我pinglun我评论 de的 neirong内容","commentDttm":20181203143335,"doctorId":319,"doctorName":"健康管家周","id":2}]
     * dataType : list
     * meta : {"describe":"操作成功","statusCode":"0"}
     */

    private String businessId;
    private String businessType;
    private String commentContent;
    private String commentDttm;
    private int doctorId;
    private String doctorName;
    private int id;
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCommentDttm(String commentDttm) {
        this.commentDttm = commentDttm;
    }


    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentDttm() {
        return commentDttm;
    }


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
