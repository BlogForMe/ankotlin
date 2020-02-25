package com.android.util.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.android.util.R;

import java.util.LinkedList;

public class CustomTabView extends LinearLayout implements View.OnClickListener {
    private LinkedList<View> mTabVies;
    private LinkedList<CusTab> mTabs;

    public CustomTabView(Context context) {
        this(context, null);
    }

    public CustomTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTabView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        mTabVies = new LinkedList<>();
        mTabs = new LinkedList<>();
    }

    public void addTab(CusTab tab) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.tab_custom_item, null);
        ImageView tabImg = view.findViewById(R.id.custom_tab_icon);
        TextView tabText = view.findViewById(R.id.custom_tab_text);
        tabImg.setImageResource(tab.normalImgResId);
        tabText.setText(tab.text);
        tabText.setTag(mTabVies.size());
        tabText.setTextColor(tab.normalColor);
        view.setTag(mTabVies.size());  //每次添加tab添加标签
        view.setOnClickListener(this);
        mTabVies.add(view);
        mTabs.add(tab);
        addView(view);
    }

    public void setCurrentItem(int position) {
        if (position >= mTabs.size() || position < 0) {
            position = 0;
        }
        updateState(position);
    }

    /**
     * 更新选中
     *
     * @param position
     */
    private void updateState(int position) {
        for (int i = 0; i < mTabVies.size(); i++) {
            View view = mTabVies.get(i);
            TextView textView = view.findViewById(R.id.custom_tab_text);
            ImageView imageView = view.findViewById(R.id.custom_tab_icon);
            if (i == position) {
                imageView.setImageResource(mTabs.get(i).selectedImgResId);
                textView.setTextColor(getContext().getResources().getColor(R.color.color_home_tab_y));
            } else {
                imageView.setImageResource(mTabs.get(i).normalImgResId);
                textView.setTextColor(getContext().getResources().getColor(R.color.color_home_tab_n));
            }
        }
    }

//    private void updateState(int position) {
//        for (int i = 0; i < mTabVies.size(); i++) {
//            View view = mTabVies.get(i);
//            TextView textView = view.findViewById(R.id.custom_tab_text);
//            ImageView imageView = view.findViewById(R.id.custom_tab_icon);
//            if (i == position) {
//                imageView.setImageResource(mTabs.get(i).selectedImgResId);
//                textView.setTextColor(mTabs.get(i).selectedColor);
//            } else {
//                imageView.setImageResource(mTabs.get(i).normalImgResId);
//                textView.setTextColor(mTabs.get(i).normalColor);
//            }
//        }
//    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        if (mOnTabSelectedListener != null) {
            mOnTabSelectedListener.tabSelected(view, position);
        }
        updateState(position);
    }

    private OnTabSelectedListener mOnTabSelectedListener;

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListener = onTabSelectedListener;
    }

    public interface OnTabSelectedListener {
        void tabSelected(View v, int position);
    }


    public static class CusTab {
        private int normalImgResId;
        private int selectedImgResId;
        private int normalColor;
        private int selectedColor;
        private String text;


        public CusTab setNormalImgResId(int normalImgResId) {
            this.normalImgResId = normalImgResId;
            return this;
        }

        public CusTab setSelectedImgResId(int selectedImgResId) {
            this.selectedImgResId = selectedImgResId;
            return this;
        }

        public CusTab setNormalColor(int normalColor) {
            this.normalColor = normalColor;
            return this;
        }

        public CusTab setSelectedColor(int selectedColor) {
            this.selectedColor = selectedColor;
            return this;
        }

        public CusTab setText(String text) {
            this.text = text;
            return this;
        }
    }

    /**
     * 设置每个Tab的宽高
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < mTabVies.size(); i++) {
            View view = mTabVies.get(i);
            int width = getResources().getDisplayMetrics().widthPixels / (mTabs.size());
            LayoutParams params = new LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT);
            view.setLayoutParams(params);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mTabVies != null) {
            mTabVies.clear();
        }
        if (mTabs != null) {
            mTabs.clear();
        }
    }
}