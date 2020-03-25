package com.example.animationdemo.data.source.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animationdemo.data.source.local.daos.CourseDao
import com.example.animationdemo.data.source.local.entities.Course

@Database(entities = [Course::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao

    companion object {
        @Volatile
        private var appDatabase: AppDatabase? = null

        internal fun getDatabase(application: Application): AppDatabase {
            if (appDatabase == null) {
                synchronized(AppDatabase::class) {
                    if (appDatabase == null) {
                        appDatabase = Room.databaseBuilder(
                            application,
                            AppDatabase::class.java,
                            "app.db"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return appDatabase!!
        }
    }
}