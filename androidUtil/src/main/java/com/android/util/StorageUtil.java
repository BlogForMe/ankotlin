package com.android.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import timber.log.Timber;


/**
 * Created by Administrator on 2017/12/14 0014.
 */

public class StorageUtil {

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }


    /**
     * 获取应用的缓存目录
     */
    public static String getCacheDirectory() {
        String downFile = Environment.getExternalStorageDirectory().getPath() + "/ApkFile";
        if (!new File(downFile).exists()) {
            new File(downFile).mkdirs();
        }
        if (downFile == null) {
            Timber.w("Can't define system cache directory! The app should be re-installed.");
        }
        return downFile;
    }

    public static String getRootDirectory() {
        String downFile = Environment.getExternalStorageDirectory().getPath();
        if (downFile == null) {
            Timber.w("Can't define system cache directory! The app should be re-installed.");
        }
        return downFile;
    }


    /**
     * 写出文件
     *
     * @param inputStream
     * @param writeFile
     */
    public static void writeSdCard(InputStream inputStream, File writeFile) {
        FileOutputStream fos;
        byte[] buff = new byte[1024];
        try {
            fos = new FileOutputStream(writeFile);
            int len;
            long sum = 0;
            while ((len = inputStream.read(buff)) != -1) {
                fos.write(buff, 0, len);
                sum += len;
            }
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    String mCurrentPhotoPath;

    static int num;

    /**
     * 创建oss图片名称
     *
     * @return
     */
    public static String createOssImgPath() {
        num++;
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_" + num;
        File imgFile = new File(imageFileName, ".jpg");
        // Save a file: path for use with ACTION_VIEW intents
//        mCurrentPhotoPath = image.getAbsolutePath();
        return imgFile.getPath();
    }


    /**
     * 下载的apk命名
     *
     * @param version
     * @return
     */
    public static String updateApkName(String version) {
        String apkDIR = "tz" + version + ".apk";
        return apkDIR;
    }

    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static <T> T jsonToObject(String json, Type type) {
        return new Gson().fromJson(json, type);
    }


    public static <T> ArrayList<T> deepCopy(ArrayList<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        ArrayList<T> dest = (ArrayList<T>) in.readObject();
        return dest;
    }





    public static String getAppDir(Context context, String appStorageRoot, String iconDir) {
        StringBuilder sb = new StringBuilder();
        if (isExternalStorageWritable()) {
            sb.append(getAppExternalStoragePath(appStorageRoot));
        } else {
            sb.append(getCachePath(context));
        }
        sb.append(iconDir);
        sb.append(File.separator);
        String path = sb.toString();
        if (createDirs(path)) {
            return path;
        }
        return null;
    }


    //获取SD下当前APP的目录
    private static String getAppExternalStoragePath(String appStorageRoot) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append(appStorageRoot);
        sb.append(File.separator);
        return sb.toString();
    }

    //创建文件夹
    private static boolean createDirs(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists() || !file.isDirectory()) {
            return file.mkdirs();
        }
        return true;
    }

    //获取应用的cache目录
    private static String getCachePath(Context context) {
        File f = context.getCacheDir();
        if (null == f) {
            return null;
        } else {
            return f.getAbsolutePath() + "/";
        }
    }

}
