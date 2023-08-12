package com.kot.util;

import java.io.InputStream;
import java.util.LinkedList;

import android.content.Context;
import com.kot.R;

public class DataUtil {

    public static LinkedList<Float> loadDatas(Context context) {
        LinkedList<Float> datas = new LinkedList<>();
        try {
            InputStream in = context.getResources().openRawResource(R.raw.ecgdata);
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            String data0 = new String(buffer);
            in.close();
            String[] data0s = data0.split(",");
            for (String str : data0s) {
                datas.add(Float.parseFloat(str));
            }

//            data1Q.addAll(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
