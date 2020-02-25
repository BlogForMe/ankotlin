package com.comm.util.pro;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;

import com.comm.util.bean.FootFeelingDataListBean;

import java.io.File;

import static android.text.TextUtils.isEmpty;

/**
 * Created by cyh on 2018/1/31.
 */

public class CommonUtil {

    public final static String Shared_Doctor_Key = "SharedDoctorKey"; //医生对象


    public static final String ACTION_FIND_DEVICE = "find_device";
    public static final String ACTION_SEARCH_TIME_OUT = "search_timeout";
    public static final String ACTION_START_SCAN = "start_scan";

    public static boolean isLeftNull(FootFeelingDataListBean footFeelBean) {
        if (isEmpty(footFeelBean.getFootFeelingLeft1()) && isEmpty(footFeelBean.getFootFeelingLeft2()) && isEmpty(footFeelBean.getFootFeelingLeft3()) && isEmpty(footFeelBean.getFootFeelingLeft4())
                && isEmpty(footFeelBean.getFootFeelingLeft5()) && isEmpty(footFeelBean.getFootFeelingLeft6()) && isEmpty((footFeelBean.getFootFeelingLeft7())) && isEmpty(footFeelBean.getFootFeelingLeft8())
                && isEmpty(footFeelBean.getFootFeelingLeft9()) && isEmpty(footFeelBean.getFootFeelingLeft10()) && isEmpty(footFeelBean.getFootFeelingLeft11()) && isEmpty(footFeelBean.getFootFeelingLeft12())) {
            return true;
        }
        return false;
    }

    public static boolean isRightNull(FootFeelingDataListBean footFeelBean) {
        if (isEmpty(footFeelBean.getFootFeelingRight1()) && isEmpty(footFeelBean.getFootFeelingRight2()) && isEmpty(footFeelBean.getFootFeelingRight3()) && isEmpty(footFeelBean.getFootFeelingRight4()) &&
                isEmpty(footFeelBean.getFootFeelingRight5()) && isEmpty(footFeelBean.getFootFeelingRight6()) && isEmpty(footFeelBean.getFootFeelingRight7()) && isEmpty(footFeelBean.getFootFeelingRight8()) &&
                isEmpty(footFeelBean.getFootFeelingRight9()) && isEmpty(footFeelBean.getFootFeelingRight10()) && isEmpty(footFeelBean.getFootFeelingRight11()) && isEmpty(footFeelBean.getFootFeelingRight12())) {
            return true;
        }
        return false;
    }

    public static final String IMG_LIST = "img_list"; //第几张图片
    public static final String POSITION = "position"; //第几张图片
    public static final String PIC_PATH = "pic_path"; //图片路径
    public static final int MAX_SELECT_PIC_NUM = 8; // 最多上传5张图片
    public static final int REQUEST_CODE_MAIN = 10; //请求码
    public static final int RESULT_CODE_VIEW_IMG = 11; //查看大图页面的结果码


    public final static String Intent_PatientCode = "Intent.PatientCode";
    public final static String Intent_PatientName = "Intent.PatientName";
    public final static String Intent_Check_Time = "Intent.Check.Time";

    /**
     * 对文件重命名      *文件的路径
     */
    public static void chageFileName(String filePath, String reName) {
        //Logger.e("文件名"+filePath+"-----------------"+reName);
        File file = new File(filePath);
        //前面路径必须一样才能修改成功
        String path = filePath.substring(0, filePath.lastIndexOf("/") + 1) + reName + filePath.substring(filePath.lastIndexOf("."), filePath.length());
        File newFile = new File(path);
        file.renameTo(newFile);

        //Logger.e("重命名 文件名" + file.getAbsolutePath());

    }

    /**
     * Description 加载本地图片
     *
     * @author cyh on 15:36
     **/
    public static Bitmap seeImage(Context context, String fileName) {
        Bitmap bitmap1 = null;
        try {
//            String cameraPath= Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM+File.separator+"Camera"+File.separator;
            String cameraPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            File imageFile = new File(cameraPath, fileName + ".png");
            Uri imageUri;
            //将File对象转换为Uri并启动照相程序
            if (Build.VERSION.SDK_INT >= 24) {
                imageUri = FileProvider.getUriForFile(context, "com.casanube.patient.Fileprovider", imageFile);
            } else {
                imageUri = Uri.fromFile(imageFile);
            }
            bitmap1 = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(imageUri));
            Matrix matrix = new Matrix();
            if ((bitmap1.getByteCount() / 1024 / 1024) > 15) {
                matrix.setScale(0.2f, 0.2f);
            } else {
                matrix.setScale(0.5f, 0.5f);
            }
            bitmap1 = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getWidth(), bitmap1.getHeight(), matrix, true);
        } catch (Exception e) {
            //Logger.e(e.toString());
//            if (onErrorListener!= null)
//            onErrorListener.onError("error");
        }
        return bitmap1;
    }


    /**
     * 自定义过滤器
     * custom intentFilter
     */
//    public static IntentFilter makeGattUpdateIntentFilter() {
//        final IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(StringUtil.ACTION_GATT_CONNECTED);
//        intentFilter.addAction(StringUtil.ACTION_GATT_DISCONNECTED);
//        intentFilter.addAction(StringUtil.ACTION_GATT_SERVICES_DISCOVERED);
//        intentFilter.addAction(StringUtil.ACTION_DATA_AVAILABLE);
//        //---
//        intentFilter.addAction(StringUtil.ACTION_SPO2_DATA_AVAILABLE);
//        intentFilter.addAction(StringUtil.ACTION_CHARACTER_NOTIFICATION);
//        intentFilter.addAction(ACTION_FIND_DEVICE);
//        intentFilter.addAction(ACTION_SEARCH_TIME_OUT);
//        intentFilter.addAction(ACTION_START_SCAN);
//        return intentFilter;
//    }


    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


}
