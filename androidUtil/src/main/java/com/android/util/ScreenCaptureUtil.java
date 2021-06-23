package com.android.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.android.util.DisplayUtils.getScreenH;
import static com.android.util.DisplayUtils.getScreenW;

/**
 * 系统截图工具栏
 *
 * 另外一个
 * https://www.jianshu.com/p/d64cf9f69d05
 */
public class ScreenCaptureUtil {
    private final String TAG = "ScreenCaptureUtil";

    private static ScreenCaptureUtil ourInstance = null;
    private MediaProjectionManager mMediaProjectionManager;
    private Context mContext;
    private int REQUEST_MEDIA_PROJECTION = 1;
    private SimpleDateFormat dateFormat;
    private String pathImage;
    private WindowManager mWindowManager;
    private ImageReader mImageReader;
    private MediaProjection mMediaProjection;
    private int mResultCode;
    private Intent mResultData;
    private VirtualDisplay mVirtualDisplay;
    private String strDate;
    private int windowWidth;
    private int windowHeight;
    private String nameImage;
    private int mScreenDensity;
    private ImageView ivImgshow;


    public static ScreenCaptureUtil getInstance(Context context) {
        if (ourInstance == null) {
            synchronized (ScreenCaptureUtil.class) {
                if (ourInstance == null) {
                    ourInstance = new ScreenCaptureUtil(context);
                }
            }
        }
        return ourInstance;
    }


    private ScreenCaptureUtil(Context context) {
        this.mContext = context.getApplicationContext();
    }


    /**
     * 调用系统截图方法
     *
     * @param REQUEST_CODE
     */
    public void createScreenCaptureIntent(Context context, int REQUEST_CODE) {
        mMediaProjectionManager = (MediaProjectionManager) mContext.getApplicationContext().getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        createVirtualEnvironment();
        ((Activity) context).startActivityForResult(mMediaProjectionManager.createScreenCaptureIntent(), REQUEST_MEDIA_PROJECTION);
    }


    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void handleScreenShotIntent(int requestCode, int resultCode, Intent data, final IFilePath iFilePath) {
        if (requestCode == REQUEST_MEDIA_PROJECTION) {
            if (resultCode != Activity.RESULT_OK) {
                return;
            } else if (data != null && resultCode != 0) {
                mResultCode = resultCode;
                mResultData = data;

                startVirtual();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startCapture(iFilePath);
                    }
                }, 100);
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createVirtualEnvironment() {
        dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        strDate = dateFormat.format(new Date());
        pathImage = Environment.getExternalStorageDirectory().getPath() + "/Pictures/";
        nameImage = pathImage + strDate + ".png";
        mMediaProjectionManager = (MediaProjectionManager) mContext.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        windowWidth = (int) getScreenW(mContext);
        windowHeight = (int) getScreenH(mContext);
        mScreenDensity = (int) mContext.getResources().getDisplayMetrics().density;
        mImageReader = ImageReader.newInstance(windowWidth, windowHeight, 0x1, 2); //ImageFormat.RGB_565

        Log.i(TAG, "prepared the virtual environment");
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void startVirtual() {
        if (mMediaProjection != null) {
            Log.i(TAG, "want to display virtual");
            virtualDisplay();
        } else {
            Log.i(TAG, "start screen capture intent");
            Log.i(TAG, "want to build mediaprojection and display virtual");
            setUpMediaProjection();
            virtualDisplay();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setUpMediaProjection() {
        mMediaProjection = mMediaProjectionManager.getMediaProjection(mResultCode, mResultData);
        Log.i(TAG, "mMediaProjection defined");
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void virtualDisplay() {
        mVirtualDisplay = mMediaProjection.createVirtualDisplay("screen-mirror",
                windowWidth, windowHeight, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mImageReader.getSurface(), null, null);
        Log.i(TAG, "virtual displayed");
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void startCapture(IFilePath iFilePath) {
        strDate = dateFormat.format(new java.util.Date());
        nameImage = pathImage + strDate + ".png";

        Image image = mImageReader.acquireLatestImage();
        int width = image.getWidth();
        int height = image.getHeight();
        final Image.Plane[] planes = image.getPlanes();
        final ByteBuffer buffer = planes[0].getBuffer();
        int pixelStride = planes[0].getPixelStride();
        int rowStride = planes[0].getRowStride();
        int rowPadding = rowStride - pixelStride * width;
        Bitmap bitmap = Bitmap.createBitmap(width + rowPadding / pixelStride, height, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(buffer);
        bitmap = Bitmap.createBitmap(bitmap, 100, 150, 550, 350);
        image.close();
        Log.i(TAG, "image data captured");
//        Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, 27, 150, 607, 364);


        //保存截屏结果，如果要裁剪图片，在这里处理bitmap
        try {
            saveBitmap(bitmap, iFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if (bitmap != null) {
//            ivImgshow.setImageBitmap(bitmap);
//            try {
//                File fileImage = new File(nameImage);
//                if (!fileImage.exists()) {
//                    fileImage.createNewFile();
//                    Log.i(TAG, "image file created");
//                }
//                FileOutputStream out = new FileOutputStream(fileImage);
//                if (out != null) {
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//                    out.flush();
//                    out.close();
//                    Intent media = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//                    Uri contentUri = Uri.fromFile(fileImage);
//                    media.setData(contentUri);
//                    mContext.sendBroadcast(media);
//                    Log.i(TAG, "screen image saved");
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void tearDownMediaProjection() {
        if (mMediaProjection != null) {
            mMediaProjection.stop();
            mMediaProjection = null;
        }
        Log.i(TAG, "mMediaProjection undefined");
    }


    public void saveBitmap(Bitmap bmp, IFilePath iFilePath) throws IOException {
        String basePath = Environment.getExternalStorageDirectory().toString() + File.separator + "ScreenCapture";
        if (!new File(basePath).exists()) {
            new File(basePath).mkdirs();
        }
        File imageFile = new File(basePath + "/" + System.currentTimeMillis
                () + ".jpg");
        OutputStream fOut = new FileOutputStream(imageFile);
        bmp.compress(Bitmap.CompressFormat.JPEG, 80, fOut);//将bg输出至文件
        fOut.flush();
        fOut.close(); // do not forget to close the stream
//        mContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile
//                (imageFile)));

        iFilePath.getImgPath(imageFile.getAbsolutePath());
    }


    public interface IFilePath {
        void getImgPath(String path);
    }

    public void destroy(){
        tearDownMediaProjection();
        if (mImageReader!=null){
            mImageReader.close();
            mImageReader=null;
        }
    }

}
