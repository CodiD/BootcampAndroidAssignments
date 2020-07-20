package com.isabelledionisius.myomelettapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(OmelettDataList::class), version = 1, exportSchema = false)
public abstract class OmelettRoomDatabase:RoomDatabase() {
    abstract fun omelettDao(): DaoOmelett
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: OmelettRoomDatabase? = null

        fun getDatabase(context: Context): OmelettRoomDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OmelettRoomDatabase::class.java,
                    "omelett_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}





