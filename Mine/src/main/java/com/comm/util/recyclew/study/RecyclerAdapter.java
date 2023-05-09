package com.comm.util.recyclew.study;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.comm.util.R;

/**
 * Created by wen on 2017/8/8.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    List<String> list = new ArrayList<>();

    public RecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).setData(position);
    }

    public List<String> getDataList() {
        return list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView viewById;

        public MyViewHolder(View itemView) {
            super(itemView);
            viewById = (TextView)itemView.findViewById(R.id.text);
        }

        public void setData(int position) {
            viewById.setText(list.get(position));
        }
    }
}