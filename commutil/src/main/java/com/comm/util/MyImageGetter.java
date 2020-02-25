package com.comm.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.comm.util.R;

//https://daihanglin.github.io/2017/10/13/imageGetter/
public class MyImageGetter implements Html.ImageGetter {
    private Context mContext;
    private TextView tv;


    public MyImageGetter(Context context, TextView textView) {
        this.mContext = context;
        this.tv = textView;
    }

    @Override
    public Drawable getDrawable(String source) {
        MyDrawableWrapper myDrawable = new MyDrawableWrapper();
        Drawable drawable = mContext.getResources().getDrawable(R.mipmap.info_placehoder_pro);
        drawable.setBounds(
                0,
                0,
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        myDrawable.setDrawable(drawable);
        Glide.with(mContext)
                .asBitmap()
                .load(source)
                .into(new BitmapTarget(myDrawable));
        return myDrawable;
    }


    class MyDrawableWrapper extends BitmapDrawable {
        private Drawable drawable;

        MyDrawableWrapper() {
        }

        @Override
        public void draw(Canvas canvas) {
            if (drawable != null)
                drawable.draw(canvas);
        }

        public Drawable getDrawable() {
            return drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }
    }


    class BitmapTarget extends SimpleTarget<Bitmap> {
        private final MyDrawableWrapper myDrawable;

        public BitmapTarget(MyDrawableWrapper myDrawable) {
            this.myDrawable = myDrawable;
        }

        @Override
        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            Drawable drawable = new BitmapDrawable(mContext.getResources(), resource);
            //获取原图大小
            int width = drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight();
            //自定义drawable的高宽, 缩放图片大小最好用matrix变化，可以保证图片不失真
            drawable.setBounds(0, 0, 500, 500);
            myDrawable.setBounds(0, 0, 500, 500);
            myDrawable.setDrawable(drawable);
            tv.setText(tv.getText());
            tv.invalidate();
        }
    }


}

