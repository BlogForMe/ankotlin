package com.comm.util.recyclew.clickhead;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.comm.util.R;

/**
 * ClassName:      RecyclerViewAdapter
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/5/9 6:19 PM
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> datas;

    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.date_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.populate(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //是否存在分组的头部，每5个一组
    public boolean hasHeader(int pos) {
        if (pos % 5 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //采用xml方式来实现ItemDecoration，可以更方便的定制ItemDecoration的内容，生成head布局
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return new HeaderHolder(
            LayoutInflater.from(mContext).inflate(R.layout.item_decoration, parent, false));
    }

    //绑定head的数据
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        viewholder.group.setText("分组" + getHeaderId(position));
        viewholder.clickgroup.setText("点击分组" + getHeaderId(position));
    }

    //获取每条数据属于哪一分组
    public int getHeaderId(int position) {
        return position / 5;
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {
        TextView group;
        TextView clickgroup;

        public HeaderHolder(View itemView) {
            super(itemView);
            group = (TextView)itemView.findViewById(R.id.tv);
            clickgroup = (TextView)itemView.findViewById(R.id.tv1);
            clickgroup.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Log.i("TAG", "onTouch: ");
                    return false;
                }
            });
            clickgroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, clickgroup.getText().toString(), Toast.LENGTH_SHORT)
                        .show();
                }
            });
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_item_layout;
        String str;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_item_layout = (TextView)itemView.findViewById(R.id.tv_item_layout);
            tv_item_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void populate(String str) {
            tv_item_layout.setText(str);
            this.str = str;
        }
    }
}
