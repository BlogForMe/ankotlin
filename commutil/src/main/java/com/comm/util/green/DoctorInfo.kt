package com.comm.util.green

import java.io.Serializable

data class DoctorInfo(val doctorId:Int,var doctorName: String) {
    
    fun DoctorInfo.clone(): DoctorInfo {
        val person = DoctorInfo(doctorId,doctorName)
        return person
    }
}









/**
 *
{
"doctorInfo":{
"department":"神经科45",
"doctorId":10,
"doctorName":"万斯",
"email":"789@755.com",
"expertArea":"心血管疾病目前承担国家、省部级、国际合作科研课题7项。擅长心内科、心电生理、起搏器植入、临床药理。尤其在冠心病介入治疗和我国心血管疾病预防医学的发展方面作出了贡献。多次组织牵头或参与国际大规模、多中心临床实验，填补了我国在这一领域的空白。",
"jobTitle":"专家医生54666666专家医生54666666专家医生54666666专家医生54666666专家医生54666666",
"mobile":"15387464403",
"pic":"08deb8ef76d44a43b7df115c68e6ada1",
"registerDate":20171108160157,
"remark":"6目前承担国家、省部级、国际合作科研课题7项。擅长心内科、心电生理、起搏器植入、临床药理。尤其在冠心病介入治疗和我国心血管疾病预防医学的发展方面作出了贡献。多次组织牵头或参与国际大规模、多中心临床实验，填补了我国在这一领域的空白。",
"unionUserId":139
},
"type":"15",
"needConfirm":"false"
}

 */