package com.example.animationdemo.data.source.local

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.animationdemo.data.source.local.daos.CertificateDao
import com.example.animationdemo.data.source.local.daos.CourseDao
import com.example.animationdemo.data.source.local.entities.Certificate
import com.example.animationdemo.data.source.local.entities.Course
import com.example.animationdemo.utils.runInBackground

@Database(entities = [Course::class, Certificate::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
    abstract fun certificateDao(): CertificateDao

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
                            .addCallback(callback)
                            .build()
                    }
                }
            }
            return appDatabase!!
        }

        private val callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDB(appDatabase!!)
            }
        }

        private fun populateDB(appDatabase: AppDatabase) = runInBackground {
            populateCourses(appDatabase.courseDao())
            populateCourses(appDatabase.courseDao())
            populateCertificates(appDatabase.certificateDao())
            populateCertificates(appDatabase.certificateDao())
        }

        @WorkerThread
        private fun populateCourses(courseDao: CourseDao) {
            var course = Course(
                0, "Build an app with Jetpack Compose"
            )
            courseDao.newCourse(course)
            course = Course(
                0, "Architecture Components Android"
            )
            courseDao.newCourse(course)
            course = Course(
                0, "Room in Android"
            )
            courseDao.newCourse(course)
        }

        @WorkerThread
        private fun populateCertificates(certificateDao: CertificateDao) {
            var cert = Certificate(
                0, "UI Design"
            )
            certificateDao.newCertificate(cert)
            cert = Certificate(
                0, "Kotlin"
            )
            certificateDao.newCertificate(cert)
            cert = Certificate(
                0, "Java"
            )
            certificateDao.newCertificate(cert)
        }

    }
}