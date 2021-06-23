package com.android.util.circledialog.callback;

import android.widget.TextView;

/**
 * Created by hupei on 2019/4/22 15:46.
 */
public interface CircleItemViewBinder<T> {

    void onBinder(TextView itemView, T item, int position);

}
