package com.kot.mvvm.livedata.xiangxue;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.kot.R;


//原文链接：https://blog.csdn.net/geyuecang/article/details/89028283
public class LiveData2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data1);

        LiveDataBus.get().getChannel("myfirst1", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged( String s) {
                Toast.makeText(LiveData2Activity.this, "我收到了蛋疼的消息" + s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}