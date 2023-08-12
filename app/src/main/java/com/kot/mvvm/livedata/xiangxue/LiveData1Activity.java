package com.kot.mvvm.livedata.xiangxue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.kot.R;

/**
 * 数据粘性问题
 */
public class LiveData1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data1);

        findViewById(R.id.bt_start).setOnClickListener(v -> {
            LiveDataBus.get().getChannel("myfirst1").setValue("我给你发数据了，你收到了吗");
            startActivity(new Intent(this,LiveData2Activity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LiveDataBus.get().getChannel("myfirst1", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged( String s) {
                Toast.makeText(LiveData1Activity.this, "我收到了蛋疼的消息 ---------         " + s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btNormal(View view) {
        LiveDataBus.get().getChannel("myfirst1").setValue("我给你发数据了，你收到了吗");
    }
}