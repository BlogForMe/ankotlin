package com.comm.util.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BleEntity.class},version=1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BleDao bleDao();

//   public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE BleEntity "
//                    + " ADD COLUMN bleCode INTEGER");
//        }
//    };

}
