package com.android.util;

import androidx.room.Room;

import com.android.util.room.AppDatabase;
import com.android.util.room.BleDao;
import com.android.util.room.BleEntity;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;

import static com.android.util.DateUtils.yyyyMMDDHHmmss;

public class RoomUtil {
    private static final RoomUtil ourInstance = new RoomUtil();
    private final BleDao bledao;

    public static RoomUtil getInstance() {
        return ourInstance;
    }

    private RoomUtil() {
        AppDatabase db = Room.databaseBuilder(AppUtil.getApp(), AppDatabase.class, "bleDb.db")
//                .addMigrations(MIGRATION_1_2)
                .build();
        bledao= db.bleDao();
    }


    public void insertBleData(String saveStrData,int bleCode){
        try{
            if (bledao!=null){
//                int randomTxt = new Random().nextInt(100);
                String  time  = DateUtils.dateToString(new Date(),yyyyMMDDHHmmss);
                bledao.insertBle(new BleEntity().setBleCode(bleCode).setBleParam(saveStrData).setCreateDttm(Long.parseLong(time)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Observable<List<BleEntity>> selectBleData(){
        return  bledao.getAll();
    }

    public void deleteData(BleEntity bleEntity){
        bledao.deleteData(bleEntity);
    }
    public BleEntity  findUserLastData(){
        return   bledao.findUserLastData();
    }
}
