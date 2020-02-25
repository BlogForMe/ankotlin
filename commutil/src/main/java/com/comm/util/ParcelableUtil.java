package com.comm.util;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 序列化存取List对象
 *
 */
public class ParcelableUtil {

    private static final String deviceFile = "deviceFile";

    public  static <T> boolean saveParcelableData(List<T> data, File file) {
        try (FileOutputStream fos = AppUtil.getApp().openFileOutput(deviceFile, Context.MODE_PRIVATE);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             oos.writeObject(data);
             return  true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public <T> List<T> getParcelableData() {
       try(FileInputStream ofi = AppUtil.getApp().openFileInput(deviceFile);
           ObjectInputStream ois = new ObjectInputStream(ofi)){
           List<T> data = (List<T>) ois.readObject();
           return  data;
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       return  null;
    }
}
