package com.android.util.room
//
//import androidx.room.Database
//import androidx.room.RoomDatabase
//import androidx.room.migration.Migration
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.android.util.room.box.BleDao
//import com.android.util.room.box.BleEntity
//import com.android.util.room.officer.UserDao
//
//@Database(entities = [BleEntity::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun bleDao(): BleDao?
//
//    abstract fun userDao():UserDao
//
//
//    companion object {
//        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL(
//                    "ALTER TABLE BleEntity "
//                            + " ADD COLUMN bleCode INTEGER"
//                )
//            }
//        }
//    }
//}