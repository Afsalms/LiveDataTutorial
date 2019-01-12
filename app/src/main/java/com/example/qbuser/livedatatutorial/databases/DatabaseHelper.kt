package com.example.qbuser.livedatatutorial.databases

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.qbuser.livedatatutorial.daos.WordDao
import com.example.qbuser.livedatatutorial.models.Words

@Database(entities = arrayOf(Words::class), version = 1)
abstract class DatabaseHelper: RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: DatabaseHelper? = null
        fun getInstance(context: Context): DatabaseHelper {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    DatabaseHelper::class.java,
                    "liveData")
                    .build()
            }
            return INSTANCE as DatabaseHelper
        }
    }


}