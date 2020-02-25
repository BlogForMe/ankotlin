package com.comm.util.bean;

import java.util.List;

/**
 * @author : John
 * @date : 2018/8/30
 */
public class PackService {

    /**
     * dataList : [{"content":"1.自检设备4件","equipment":["蓝牙血压仪-0002","[蓝牙血糖仪-09898]","[蓝牙体温计-9877]","[蓝牙血氧仪-877634]"]},{"content":"2.数据上传分析(6项)"},{"content":"3.医生对自检数据进行回复"},{"content":"4.每周一次对患者进行远程检查"}]
     * meta : {"describe":"操作成功","statusCode":"0"}
     */


    private String content;
    private List<String> equipment;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }
}
