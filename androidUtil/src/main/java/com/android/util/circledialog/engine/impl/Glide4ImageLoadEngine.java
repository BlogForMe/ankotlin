package com.android.util.circledialog.engine.impl;

import android.content.Context;
import android.widget.ImageView;

import com.android.util.circledialog.engine.ImageLoadEngine;

/**
 * Created by hupei on 2019/1/14 15:28.
 */
@Deprecated
public final class Glide4ImageLoadEngine implements ImageLoadEngine {

    @Override
    public void loadImage(Context context, ImageView imageView, String url) {
//        Glide.with(context)
//                .load(url)
//                .apply(new RequestOptions()
//                        .priority(Priority.HIGH)
//                        .fitCenter())
//                .into(imageView);
    }
}
