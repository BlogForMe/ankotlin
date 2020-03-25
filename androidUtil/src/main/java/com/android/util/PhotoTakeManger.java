package com.android.util;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

import static com.android.util.StorageUtil.getAppDir;


/**
 * https://github.com/xuhongv/TakePhotoAndroidN
 */
public class PhotoTakeManger {

    //布尔值，true：在mActivity进行操作 ；false :Fragment操作
    private Activity mActivity;
    private Context mContext;

    private boolean isActicity;

    //默认不开启裁剪
    private boolean isTailor = false;

    //裁剪宽高的比例,默认是是 1 ：1
    private int aspectX = 1;
    private int aspectY = 1;

    //裁剪图片的宽高,默认是是 1 ：1
    private int outputX = 350;
    private int outputY = 350;


    //拿到未裁剪相片的回调码（拍照后）
    private static final int CODE_ORIGINAL_PHOTO_CAMERA = 101;

    //拿到未裁剪相片的回调码（选择本地图库后）
    private static final int CODE_ORIGINAL_PHOTO_ALBUM = 102;

    //拿到已裁剪相片的回调码
    private static final int CODE_TAILOR_PHOTO = 103;

    private final String FILE_PROVIDER_AUTHORITY;

    private PermissionListener permissionListener;
    //图片回调接口
    private takePictureCallBackListener takeCallBacklistener;

    //是否压缩图片 默认开启压缩图片的
    private boolean isCompressor = true;
    //临时存储相片地址
    private String imgPath;
    //最终得到的Url
    private Uri outputUri;

    public PhotoTakeManger(Activity activity) {
        this.mActivity = activity;
        mContext = activity;
        isActicity = true;
        FILE_PROVIDER_AUTHORITY = mActivity.getPackageName() + ".fileprovider";
    }

    public void startGrantPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Timber.i("startTakeByCamera  requestRuntimePermission");
            requestRuntimePermission(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    new PermissionListener() {
                        @Override
                        public void onGranted() {
                        }

                        @Override
                        public void onDenied(List<String> deniedPermissions) {
                            if (takeCallBacklistener != null) {
                                takeCallBacklistener.failed(1, deniedPermissions);
                            }
                        }
                    });
        } else {
            startOpenCamera();

        }
        Timber.i("startTakeByCamera  startOpenCamera");
    }

    public void startTakeByCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Timber.i("startTakeByCamera  requestRuntimePermission");
            requestRuntimePermission(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    new PermissionListener() {
                        @Override
                        public void onGranted() {
                            startOpenCamera();
                        }

                        @Override
                        public void onDenied(List<String> deniedPermissions) {
                            if (takeCallBacklistener != null) {
                                takeCallBacklistener.failed(1, deniedPermissions);
                            }
                        }
                    });
        } else {
            startOpenCamera();

        }
        Timber.i("startTakeByCamera  startOpenCamera");
    }

    private void startOpenCamera() {
        imgPath = generateImagePath(mContext);
        Timber.i("startOpenCamera  " + imgPath);
        File imgFile = new File(imgPath);
        Uri imgUri = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            imgUri = FileProvider.getUriForFile(mContext, FILE_PROVIDER_AUTHORITY, imgFile);
        } else {
            imgUri = Uri.fromFile(imgFile);
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
        if (isActicity) {
            mActivity.startActivityForResult(intent, CODE_ORIGINAL_PHOTO_CAMERA);
        } else {
//            mFragment.startActivityForResult(intent, CODE_ORIGINAL_PHOTO_CAMERA);
        }
    }


    /**
     * 对外接口，是否裁剪
     *
     * @param aspectX 要裁剪的宽比例
     * @param aspectY 要裁剪的高比例
     * @param outputX 要裁剪图片的宽
     * @param outputY 要裁剪图片的高
     */

    public void setTailor(int aspectX, int aspectY, int outputX, int outputY) {
        isTailor = true;
        this.aspectX = aspectX;
        this.aspectY = aspectY;
        this.outputX = outputX;
        this.outputY = outputY;
    }


    /**
     * 申请运行时权限
     */
    private void requestRuntimePermission(String[] permissions, PermissionListener listener) {

        permissionListener = listener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(mContext, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }

        //此处兼容了无法在fragment回调监听事件
        if (!permissionList.isEmpty()) {
            if (isActicity) {
                ActivityCompat.requestPermissions((Activity) mContext, permissionList.toArray(new String[permissionList.size()]), 1);
            } else {
//                mFragment.requestPermissions(permissionList.toArray(new String[permissionList.size()]), 1);
            }

            if (takeCallBacklistener != null) {
                takeCallBacklistener.failed(1, permissionList);
            }
        } else {
            permissionListener.onGranted();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    //被拒绝权限
                    if (deniedPermissions.isEmpty()) {
                        permissionListener.onGranted();
                    } else {
                        permissionListener.onDenied(deniedPermissions);
                        if (takeCallBacklistener != null) {
                            takeCallBacklistener.failed(1, deniedPermissions);
                        }
                    }
                }
                break;
        }
    }

    public void attachToActivityForResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1) {
            return;
        }
        File temFile = null;
        File srcFile ;
        File outPutFile = null;
        switch (requestCode) {
            case CODE_ORIGINAL_PHOTO_CAMERA:
                srcFile = new File(imgPath);
                Timber.i("attachToActivityForResult outPutFile    " + srcFile.getAbsolutePath());
//                outPutFile = new File(generateImagePath(mContext));
//                outputUri = Uri.fromFile(outPutFile);
                Uri imageContentUri = getImageContentUri(mContext, srcFile);
                if (isTailor) {
                    statZoom(srcFile, outPutFile);
                } else {
                    if (imageContentUri != null) {
                        //如果是拍照的,删除临时文件
                        //返回一个压缩后的图片
                        if (isCompressor) {
                            Bitmap deBitmap = martixBitmap(decodeUriAsBitmap(imageContentUri));
                            temFile = outputIamge(mContext, compressImage(deBitmap, 50));
                            Timber.i("attachToActivityForResult temFile    " + temFile.getAbsolutePath());
                            outputUri = Uri.fromFile(temFile);
//                            if (temFile.exists()){
//                                temFile.delete();
//                            }
                        }
                        if (takeCallBacklistener != null) {
                            takeCallBacklistener.successful(true, temFile, outputUri);
                        }
                    }

                }
                break;
        }
    }

    /**
     * 缩放法压缩
     * @param bit
     * @return
     */
    private Bitmap martixBitmap(Bitmap bit) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        Bitmap bm = Bitmap.createBitmap(bit, 0, 0, bit.getWidth(), bit.getHeight(), matrix, true);
        return createScaledBitamp(bm);
    }

    /**
     * 固定尺寸
     * @param bit
     * @return
     */
    public Bitmap createScaledBitamp(Bitmap bit) {
        Bitmap bitmap = Bitmap.createScaledBitmap(bit, 120, 200, true);
        return bitmap;
    }

    private void statZoom(File srcFile, File outPutFile) {
//        if (isActicity) {
//            mActivity.startActivityForResult(intent, CODE_TAILOR_PHOTO);
//        } else {
//            mFragment.startActivityForResult(intent, CODE_TAILOR_PHOTO);
//        }
    }

    //裁剪根据文件路径获取uri
    private Uri getImageContentUri(Context context, File imgFile) {
        String filePath = imgFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=?",
                new String[]{filePath}, null);
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (imgFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return context.getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            }
        }
        return null;
    }

    /**
     * 返回一张压缩后的图片
     *
     * @param image 原图片
     * @param size  裁剪之后的大小
     * @return
     */
    private static Bitmap compressImage(Bitmap image, int size) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 40, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > size) {    //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();
            options -= 10;
            if (options >0 || options < 100){
                image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            }
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    //在自定义目录创建图片
    private static File outputIamge(Context context, Bitmap bitmap) {
        File outputIamge = new File(generateImagePath(context));
        Timber.i("attachToActivityForResult outputIamge   " + outputIamge.getAbsolutePath());
        //创建
        try {
            outputIamge.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream fOut = null;

        try {
            fOut = new FileOutputStream(outputIamge);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        bitmap.compress(Bitmap.CompressFormat.PNG, 60, fOut);

        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputIamge;
    }

//    public static Bitmap compressImageToBitmap(Bitmap bmp) {
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        bmp.compress(Bitmap.CompressFormat.JPEG, 100, os);
//        if (os.toByteArray().length / 1024 > 1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
//            os.reset();//重置baos即清空baos
//            bmp.compress(Bitmap.CompressFormat.JPEG, 50, os);//这里压缩50%，把压缩后的数据存放到baos中
//        }
//        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//        BitmapFactory.Options newOpts = new BitmapFactory.Options();
//        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
//        newOpts.inJustDecodeBounds = true;
//        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
//        Bitmap bitmap = BitmapFactory.decodeStream(is, null, newOpts);
//        newOpts.inJustDecodeBounds = false;
//        int w = newOpts.outWidth;
//        int h = newOpts.outHeight;
//        float hh = 240f;// 设置高度为240f时，可以明显看到图片缩小了
//        float ww = 120f;// 设置宽度为120f，可以明显看到图片缩小了
//        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
//        int be = 1;//be=1表示不缩放
//        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
//            be = (int) (newOpts.outWidth / ww);
//        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
//            be = (int) (newOpts.outHeight / hh);
//        }
//        if (be <= 0) be = 1;
//        newOpts.inSampleSize = be;//设置缩放比例
//        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
//        is = new ByteArrayInputStream(os.toByteArray());
//        bitmap = BitmapFactory.decodeStream(is, null, newOpts);
//        //压缩好比例大小后再进行质量压缩
////      return compress(bitmap, maxSize); // 这里再进行质量压缩的意义不大，反而耗资源，删除
//        return bitmap;
//    }


    public void setTakePictureCallBackListener(takePictureCallBackListener takeCallBacklistener) {
        this.takeCallBacklistener = takeCallBacklistener;
    }


    //得到图片回调接口（内部）
    public interface takePictureCallBackListener {
        /**
         * 成功回调
         *
         * @param isTailor 是否开启了裁剪
         * @param outFile
         * @param filePath
         */
        void successful(boolean isTailor, File outFile, Uri filePath);

        /**
         * 失败回调
         *
         * @param errorCode         错误码  0：图片发生错误  1：被拒绝的权限
         * @param deniedPermissions 被拒绝的权限
         */
        void failed(int errorCode, List<String> deniedPermissions);

    }

    private interface PermissionListener {

        void onGranted();

        void onDenied(List<String> deniedPermissions);
    }


    private static final String ICON_DIR = "icon";
    private static final String APP_STORAGE_ROOT = "AndroidNAdaption";


    //产生图片的路径，带文件夹和文件名，文件名为当前毫秒数
    private static String generateImagePath(Context mContext) {
        return getAppDir(mContext, APP_STORAGE_ROOT, ICON_DIR) + System.currentTimeMillis() + ".jpg";
    }

    /**
     * 根据uri返回bitmap
     *
     * @param uri
     * @return
     */
    public Bitmap decodeUriAsBitmap(Uri uri) {
        Bitmap bitmap = null;
        try {
            // 先通过getContentResolver方法获得一个ContentResolver实例，
            // 调用openInputStream(Uri)方法获得uri关联的数据流stream
            // 把上一步获得的数据流解析成为bitmap
            bitmap = BitmapFactory.decodeStream(mContext.getContentResolver().openInputStream(uri));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }


}
