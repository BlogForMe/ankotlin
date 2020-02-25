package com.comm.util.rx;

import com.comm.util.bean.AppintBean;
import com.comm.util.bean.ArchHealPlan;
import com.comm.util.bean.BaseCount;
import com.comm.util.bean.CommentBean;
import com.comm.util.bean.CommitVideo;
import com.comm.util.bean.DoctorDetail;
import com.comm.util.bean.MsgShow;
import com.comm.util.bean.NurseBean;
import com.comm.util.bean.PackService;
import com.comm.util.bean.PatientBean;
import com.comm.util.bean.PatientDynamicBean;
import com.comm.util.bean.PictureUp;
import com.comm.util.bean.RecordCheck;
import com.comm.util.bean.RemoteDetail;
import com.comm.util.bean.RemoteListBean;
import com.comm.util.bean.ReportBean;
import com.comm.util.bean.SigleField;
import com.comm.util.bean.StrangeBean;
import com.comm.util.bean.UpdateBean;
import com.comm.util.bean.MeasureData;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * @author : John
 * @date : 2018/8/8
 */
public interface ICommonApis {

    @POST("Measure/MeasureDataSearchTwo")
    Observable<BaseCount<MeasureData>> measureDataSearch(@Body RequestBody requestBody);


    @POST("BloodSugarFoot/InsertReply")
    Observable<BaseCount> insertReply(@Body RequestBody requestBody);

    @POST("DoctorApp/SystemMsgInfoSearch")
    Observable<BaseCount<List<MsgShow>>> systemMsgInfoSearch(@Body RequestBody requestBody);

    @POST("DoctorApp/SystemMsgInfoUpdate")
    Observable<BaseCount> systemMsGInfoUpdate(@Body RequestBody requestBody);

    @POST("Patient/SearchNew")
    Observable<BaseCount<List<PatientBean>>> obtainPatientDetail(@Body RequestBody requestBody);


    @POST("Order/Search")
    Observable<BaseCount<List<ArchHealPlan>>> orderSearch(@Body RequestBody requestBody);

    @POST("DoctorApp/RemoteCheckRecord")
    Observable<BaseCount<List<RecordCheck>>> remoteCheckRecord(@Body RequestBody requestBody);

    @POST("DoctorApp/ServicePackage")
    Observable<BaseCount<List<PackService>>> getServicePackage(@Body RequestBody requestBody);

    @POST("Video/EndVideo")
    Observable<BaseCount> endVideo(@Body RequestBody requestBody);

    @POST("ClientVersion/Search")
    Observable<UpdateBean> clientVersion(@Body RequestBody requestBody);

    @POST("RemoteCheck/UpdateTaskStatus")
    Observable<BaseCount> updateTaskStatus(@Body RequestBody requestBody);

    @POST("Video/AppVideoConnect")
    Observable<SigleField> AppVideoConnect(@Body RequestBody requestBody);

    @POST("Measure/PatientInfoSearch")
    Observable<BaseCount<PatientDynamicBean>> patientInfoSearch(@Body RequestBody requestBody);

    @POST("Appointment/SearchPatientAppointment")
    Observable<BaseCount<List<AppintBean>>> appintRecordSearch(@Body RequestBody requestBody);

    @POST("Patient/NursingSearch")
    Observable<BaseCount<List<NurseBean>>> nurseSearch(@Body RequestBody requestBody);

    //获取医生信息
    @POST("Doctor/SearchNotDataAuth")
    Observable<BaseCount<List<DoctorDetail>>> searchTeamForLeadDoctor(@Body RequestBody requestBody);

    @POST("UpDoctor/ReportIllnessState")
    Observable<BaseCount> reportIllnessState(@Body RequestBody requestBody);


    @POST("UpDoctor/TzAppSearchHistoryUpDoctorInfo")
    Observable<BaseCount<ReportBean>> tzAppSearchHistoryUpDoctorInfo(@Body RequestBody requestBody);

    @POST("Measure/BloodSugarInfoInsert")
    Observable<BaseCount> bloodSugarInfoInsert(@Body RequestBody requestBody);

    @POST("Measure/TemperatureInfoInsert")
    Observable<BaseCount> temperatureInfoInsert(@Body RequestBody requestBody);


    @POST("Measure/BloodOxygenInfoInsert")
    Observable<BaseCount> bloodOxygenInfoInsert(@Body RequestBody requestBody);

    @POST("Measure/BloodPressureInfoInsert")
    Observable<BaseCount> bloodPressureInfoInsert(@Body RequestBody requestBody);

    @POST("UpDoctor/TzAppSearchHistoryUpDoctor")
    Observable<BaseCount<List<ReportBean>>> reportList(@Body RequestBody requestBody);


    @POST("UpDoctor/upCommentSearch")
    Observable<BaseCount<List<CommentBean>>> upCommentSearch(@Body RequestBody requestBody);

    @POST("UpDoctor/upCommentInsert")
    Observable<BaseCount> upCommentInsert(@Body RequestBody requestBody);

    @POST("Doctor/AnomalyMessageNotLimit")
    Observable<BaseCount<List<StrangeBean>>> anomalyMessage(@Body RequestBody requestBody);

    @POST("Video/ReceiveVideoInvitation")
    Observable<BaseCount> receiveVideoInvitation(@Body RequestBody requestBody);


    @POST("RemoteCheck/TzRemoteCheckSearch")
    Observable<BaseCount<List<RemoteDetail>>> tzRemoteCheckSearch(@Body RequestBody requestBody);

    @POST("VideoInfo/VideoInfoSearch")
    Observable<BaseCount<List<CommitVideo>>> videoInfoSearch(@Body RequestBody requestBody);

    @POST("DoctorApp/RemoteCheckRecordSubmit")
    Observable<BaseCount<List<CommitVideo>>> remoteCheckRecordSubmit(@Body RequestBody requestBody);

    @POST("DoctorApp/RemoteCheckToDo")
    Observable<BaseCount<RemoteListBean>> remoteCheckToDo(@Body RequestBody requestBody);

    @POST("RoutineUrineMeasure/RoutineUrineInfoInsert")
    Observable<BaseCount> routineUrineInfoInsert(@Body RequestBody requestBody);

    @Multipart
    @POST("/casanube-file-service/casanube/file/upload.run")
    Observable<PictureUp> imgUpServer(@Part MultipartBody.Part imgs);
}
