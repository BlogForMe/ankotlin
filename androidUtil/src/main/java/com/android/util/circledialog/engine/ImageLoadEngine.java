package com.android.util.circledialog.engine;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by hupei on 2019/1/14 9:54.
 */
@Deprecated
public interface ImageLoadEngine {

    void loadImage(Context context, ImageView imageView, String url);

}
