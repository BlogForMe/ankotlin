package com.android.util.circledialog.engine.impl;

import android.content.Context;
import android.widget.ImageView;

import com.android.util.circledialog.engine.ImageLoadEngine;

/**
 * Created by hupei on 2019/1/14 15:34.
 */
@Deprecated
public final class PicassoImageLoadEngine implements ImageLoadEngine {
    @Override
    public void loadImage(Context context, ImageView imageView, String url) {
//        Picasso.with(context)
//                .load(url)
//                .priority(Picasso.Priority.HIGH)
//                .centerInside()
//                .into(imageView);
    }
}
