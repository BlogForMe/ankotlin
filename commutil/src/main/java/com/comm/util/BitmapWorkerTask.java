package com.comm.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by A on 2018/3/28.
 */

public class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView cImgView;

    public BitmapWorkerTask(ImageView cImgView) {
        this.cImgView = cImgView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        return BitmapFactory.decodeFile(strings[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        cImgView.setImageBitmap(bitmap);
    }
}
