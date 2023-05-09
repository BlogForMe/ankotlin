package com.comm.util.recyclew.study;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.comm.util.R;

// https://juejin.cn/post/6844903498396467213#heading-4
public class StickyActivity extends AppCompatActivity {

    //@InjectView(R.id.text_recycler)
    RecyclerView textRecycler;
    private List<String> list = new ArrayList<>();
    private List<String> NameBean = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleyview_stick);
        //ButterKnife.inject(this);
        getSupportActionBar().hide();
        initData();

        textRecycler = findViewById(R.id.text_recycler);
        textRecycler.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        textRecycler.addItemDecoration(
            new SectionDecoration(list, this, new SectionDecoration.DecorationCallback() {
                @Override
                public String getGroupId(int position) {
                    if (NameBean.get(position) != null) {
                        return NameBean.get(position);
                    }
                    return "-1";
                }

                @Override
                public String getGroupFirstLine(int position) {
                    if (NameBean.get(position) != null) {
                        return NameBean.get(position);
                    }
                    return "";
                }
            }));
        textRecycler.setAdapter(adapter);
    }

    private void initData() {
        list.clear();
        NameBean.clear();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        NameBean.add("111111111");
        NameBean.add("222222222");
        NameBean.add("222222222");
        NameBean.add("222222222");
        NameBean.add("222222222");
        NameBean.add("222222222");
        NameBean.add("222222222");
        NameBean.add("222222222");
        NameBean.add("333333333");
        NameBean.add("333333333");
        NameBean.add("333333333");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
        NameBean.add("444444444");
    }
}
