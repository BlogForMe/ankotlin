package com.comm.util.recyclew.clickhead;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.comm.util.R;

//https://cloud.tencent.com/developer/beta/article/1334984
public class StickyHeadClickActivity extends AppCompatActivity {

    RecyclerView textRecycler;
    private List<String> list = new ArrayList<>();
    private List<String> NameBean = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleyview_stick);
        initData();

        textRecycler = findViewById(R.id.text_recycler);
        textRecycler.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        TestDecoration testDecoration = new TestDecoration(adapter);
        textRecycler.addOnItemTouchListener(
            new StickyRecyclerHeadersTouchListener(textRecycler, testDecoration));
        textRecycler.addItemDecoration(testDecoration);
        adapter.setData(NameBean);
        textRecycler.setAdapter(adapter);
    }

    private void initData() {
        //list.add("1");
        //list.add("2");
        //list.add("3");
        //list.add("4");
        //list.add("5");
        //list.add("1");
        //list.add("2");
        //list.add("3");
        //list.add("4");
        //list.add("5");
        //list.add("1");
        //list.add("2");
        //list.add("3");
        //list.add("4");
        //list.add("5");
        //list.add("1");
        //list.add("2");
        //list.add("3");
        //list.add("4");
        //list.add("5");
        //list.add("1");
        //list.add("2");
        //list.add("3");
        //list.add("4");
        //list.add("5");
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
