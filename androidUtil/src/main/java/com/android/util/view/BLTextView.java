package com.android.util.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class BLTextView extends AppCompatTextView {

    public BLTextView(Context context) {
        this(context,null);
    }

    public BLTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        TextPaint mTextPaint = getPaint();
        mTextPaint.setUnderlineText(true);
    }
}
