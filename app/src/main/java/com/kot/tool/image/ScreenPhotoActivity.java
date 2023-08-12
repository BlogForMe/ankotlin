package com.kot.tool.image;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.util.PhotoTakeManger;
import com.android.util.base.CBaseActivity;
import com.john.kot.R;


/**
 * 上传照片
 */
public class ScreenPhotoActivity extends CBaseActivity implements View.OnClickListener {
//
//    @BindView(R2.id.iv_left_instep)
//    ImageView ivLeftInstep;
//    @BindView(R2.id.iv_left_sole)
//    ImageView ivLeftSole;
//    @BindView(R2.id.iv_right_instep)
//    ImageView ivRightInstep;
//    @BindView(R2.id.iv_right_sole)
//    ImageView ivRightSole;
//
//    @BindView(R2.id.tv_name)
//    TextView tvPatientName;
//
//    @BindView(R2.id.tv_describe)
//    TextView tvDescribe;
    private PhotoTakeManger photoTakeManger;
//    private FootPicPresenter footPicPresenter;
    private String leftInstep, leftSole, rightInstep, rightSole;
    public static final String QUESTION_NAIREREFLD = "questionnaireRefId";
    private String ansserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("上传足部照片");
        findViewById(R.id.iv_left_instep).setOnClickListener(this::onClick);
//        ivLeftSole.setOnClickListener(this::onClick);
//        ivRightInstep.setOnClickListener(this::onClick);
//        ivRightSole.setOnClickListener(this::onClick);
        photoTakeManger = new PhotoTakeManger(this);

//        String patientName = getIntent().getStringExtra(Intent_Name);
//        tvPatientName.setText(patientName + "您好：");
//        String questionnaireRefId = getIntent().getStringExtra(QUESTION_NAIREREFLD);
//        String riskLevel = getIntent().getStringExtra("riskLevel");
//        tvDescribe.setText(String.format(getString(R.string.screen_evaluate), riskLevel));
//        ansserId = getIntent().getStringExtra(ANSWERID);
//        findViewById(R.id.tv_check_commit).setOnClickListener(new EventUtil() {
//            @Override
//            protected void onEventClick(View v) {
//                mPresenter.UpdateImageFromScreening(questionnaireRefId, leftInstep, leftSole, rightInstep, rightSole);
//            }
//        });
    }

//    @Override
//    protected ScreenPhtoPresenter createPresenter() {
//        footPicPresenter = new FootPicPresenter();
//        return new ScreenPhtoPresenter();
//    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_screen_photo;
    }

    @Override
    public void onClick(View v) {
        photoTakeManger.startTakeByCamera();

//        photoTakeManger.setTakePictureCallBackListener(new PhotoTakeManger.takePictureCallBackListener() {
//            @Override
//            public void successful(boolean isTailor, File outFile, Uri filePath) {
//                showLoading();
//                footPicPresenter.footPhotoFile(outFile, new FileUploadObserver<PictureUp>() {
//                    @Override
//                    public void onUpLoadSuccess(PictureUp pictureUp) {
//                        hideLoading();
//                        List<PictureUp.ModelListBean> picList = pictureUp.getModel_list();
//                        if (picList != null && !picList.isEmpty()) {
//                            String feet_id = picList.get(0).getFile_group_id();
//                            if (v.getId() == R.id.iv_left_instep) {
//                                leftInstep = feet_id;
//                            } else if (v.getId() == R.id.iv_left_sole) {
//                                leftSole = feet_id;
//                            } else if (v.getId() == R.id.iv_right_instep) {
//                                rightInstep = feet_id;
//                            } else if (v.getId() == R.id.iv_right_sole) {
//                                rightSole = feet_id;
//                            }
//                        }
//                        GlideImageLoader.loadImageDirect(ScreenPhotoActivity.this, outFile, (ImageView) v);
//                    }
//
//                    @Override
//                    public void onUpLoadFail(Throwable e) {
//                        hideLoading();
//                        ToastUtil.showShort("上传失败");
//                    }
//                    @Override
//                    public void onProgress(int progress) {
//                    }
//                });
//            }
//
//            @Override
//            public void failed(int errorCode, List<String> deniedPermissions) {
//
//            }
//        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        photoTakeManger.attachToActivityForResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        photoTakeManger.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

//    @Override
//    public void showResult(boolean parseCount) {
//        if (parseCount) {
//            int sourceType;
//            if (EventUtil.isPatient()) {
//                sourceType = SOURCE_TYPE_PATIENT;
//            } else {
//                sourceType = SOURCE_TYPE_DOC;
//            }
//            ARouter.getInstance().build(DPCO_WEBACTIVITY)
//                    .withString(PARRAM_URL, "#/ScreeningReport/" + ansserId + "/" +  + sourceType)
//                    .withString(WEB_FROM, SCRREEN_LIST_PATIENT)
//                    .navigation();
//        }
//    }
}
