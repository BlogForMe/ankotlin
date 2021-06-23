package com.android.util;


import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


public class BottomListSheetFrag extends BottomSheetFrag {

    private IClickItemPosition itemPosition;
    public static String PARAMS01 = "PARAM01";
    public static String PARAMS_WHICH = "which_role";

    public static BottomListSheetFrag newInstance(ArrayList<String> list, int intWhich) {
        BottomListSheetFrag bottomListSheetFrag = new BottomListSheetFrag();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(PARAMS01, list);
        bundle.putInt(PARAMS_WHICH, intWhich);
        bottomListSheetFrag.setArguments(bundle);
        return bottomListSheetFrag;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_list_sheet;
    }

    @Override
    protected void initView(View view) {
        ArrayList<String> list = getArguments().getStringArrayList(PARAMS01);
        final int role = getArguments().getInt(PARAMS_WHICH);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        BottomAdapter bottomAdapter = new BottomAdapter(R.layout.adapter_bottom_sheet, list);
        recyclerView.setAdapter(bottomAdapter);
        bottomAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                itemPosition.selectIndex(position, role);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            itemPosition = (IClickItemPosition) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface IClickItemPosition {
        void selectIndex(int position, int whichRole);
    }

    class BottomAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public BottomAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_adapter_bottom_sheet_name, item);
        }
    }
}
