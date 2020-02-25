package com.comm.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;

import timber.log.Timber;

import static com.comm.util.SharedPrefsUtils.CONFIG_USER;
import static com.comm.util.SharedPrefsUtils.DEFAULT_URL;
import static com.comm.util.SharedPrefsUtils.KEY_HOST;


/**
 * Created by A on 2018/3/23.
 */

public class GlideImageLoader {


    public static void loadImage(Context context, Object path, ImageView imageView) {
        SharedPrefsUtils spUtil = new SharedPrefsUtils(CONFIG_USER);
        String IMAGE_URL = spUtil.getString(KEY_HOST, DEFAULT_URL) + "/casanube-file-service/casanube/file/";
        String totalPath = IMAGE_URL + path + "/download.run";
        GlideApp.with(context).load(totalPath).fitCenter().into(imageView);
    }
   public static void loadImageT1(Context context, Object path, ImageView imageView) {
        SharedPrefsUtils spUtil = new SharedPrefsUtils( CONFIG_USER);
        String IMAGE_URL = spUtil.getString(KEY_HOST, DEFAULT_URL) + "/casanube-file-service/casanube/file/t1/";
        String totalPath = IMAGE_URL + path + "/download.run";
        GlideApp.with(context).load(totalPath).fitCenter().into(imageView);
    }

    public static void loadImagePro(Context context, Object path, ImageView imageView) {
        SharedPrefsUtils spUtil = new SharedPrefsUtils(CONFIG_USER);
        String IMAGE_URL = spUtil.getString(KEY_HOST, DEFAULT_URL) + "/casanube-file-service/casanube/file/";
        String totalPath = IMAGE_URL + path + "/download.run";
        GlideApp.with(context).load(totalPath).fitCenter().placeholder(R.mipmap.info_placehoder_pro).into(imageView);
    }

    public static void loadImageDirect(Context context, Object path, ImageView imageView) {
        Timber.i("loadImg   " + path);
        GlideApp.with(context).load(path).fitCenter().into(imageView);
    }

    public static void loadImagePerchDirect(Context context, Object path, ImageView imageView) {
        Timber.i("loadImg   " + path);
        GlideApp.with(context).load(path).fitCenter().into(imageView);
    }


    public static void loadImageSkipMemeoryDisk(Context context, Object path, ImageView imageView) {
        Timber.i("loadImg   " + path);
        if (context==null&&imageView==null){
            return;
        }
        GlideApp.with(context).load(path)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .fitCenter().into(imageView);
    }

  public static void loadImageSkipMemeoryBack(Context context, Object path, ImageView imageView,RequestListener requestListener) {
        Timber.i("loadImg   " + path);
        GlideApp.with(context).load(path)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .listener(requestListener)
                .fitCenter().into(imageView);
    }




    public static void loadImagePlaceDirect(Context context, Object path, ImageView imageView) {
        Timber.i("loadImg   " + path);
        GlideApp.with(context).load(path).fitCenter().placeholder(R.mipmap.ic_content_txt).into(imageView);
    }


}
