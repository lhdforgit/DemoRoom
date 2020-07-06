package com.example.demoroomapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoroomapp.data.entity.PostRoomEntity

@Database(entities = arrayOf(PostRoomEntity::class), version = 1, exportSchema = false)
abstract class PostRoomDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PostRoomDatabase? = null

        fun getDatabase(context: Context): PostRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostRoomDatabase::class.java,
                    "word_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}