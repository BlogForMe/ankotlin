package com.android.util;

public class PictureCompassUtil {
    private static final PictureCompassUtil ourInstance = new PictureCompassUtil();

   public static PictureCompassUtil getInstance() {
        return ourInstance;
    }

    private PictureCompassUtil() {
    }


    public void compass(){

    }


    interface ICompassAfter{
        void onStart();
        void  onSuccess(String path);
        void enError();
    }
}
