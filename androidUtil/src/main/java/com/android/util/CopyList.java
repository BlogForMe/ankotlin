package com.android.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class CopyList {
    public static <T> List<T> deepCopy(List<T> src) {
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        List<T> dest = null;
        try {
            out = new ObjectOutputStream(outPut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(outPut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            dest = (List<T>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dest;
    }
}
