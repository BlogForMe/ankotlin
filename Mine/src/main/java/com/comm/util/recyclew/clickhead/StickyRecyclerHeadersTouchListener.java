package com.comm.util.recyclew.clickhead;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.comm.util.R;

/**
 * ClassName:      StickyRecyclerHeadersTouchListener
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/5/9 6:21 PM
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */
public class StickyRecyclerHeadersTouchListener implements RecyclerView.OnItemTouchListener {
    private final GestureDetector mTapDetector;
    private final RecyclerView mRecyclerView;
    private final TestDecoration mDecor;

    public static String TAG = "StickyRecyclerHeadersTouchListener";

    public StickyRecyclerHeadersTouchListener(final RecyclerView recyclerView,
                                              final TestDecoration decor) {
        mTapDetector = new GestureDetector(recyclerView.getContext(), new SingleTapDetector());
        mRecyclerView = recyclerView;
        mDecor = decor;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        //将事件交给GestureDetector类进行处理，通过onSingleTapUp返回的值，判断是否要拦截事件
        boolean tapDetectorResponse = this.mTapDetector.onTouchEvent(e);
        if (tapDetectorResponse) {
            // Don't return false if a single tap is detected
            return true;
        }
        //如果是点击在header区域，则拦截事件
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            int position = mDecor.findHeaderPositionUnder((int)e.getX(), (int)e.getY());
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent e) { /* do nothing? */
        Log.i(TAG, "onTouchEvent: ");
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // do nothing
        Log.i(TAG, "onRequestDisallowInterceptTouchEvent: ");
    }

    private class SingleTapDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            //根据点击的坐标查找是不是点击在header的区域
            int position = mDecor.findHeaderPositionUnder((int)e.getX(), (int)e.getY());
            if (position != -1) {
                //如果position不等于-1,则表示点击在header区域，然后在判断是否在header需要响应的区域
                View headerView = mDecor.getHeader(mRecyclerView, position);
                View view1 = headerView.findViewById(R.id.tv1);
                if (mDecor.findHeaderClickView(view1, (int)e.getX(), (int)e.getY())) {
                    //如果在header需要响应的区域，该区域的view模拟点击
                    view1.performClick();
                }
                mRecyclerView.playSoundEffect(SoundEffectConstants.CLICK);
                headerView.onTouchEvent(e);
                return true;
            }
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }
    }
}