package com.example.animationdemo.data.source.local

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.animationdemo.data.source.DataSource
import com.example.animationdemo.data.source.local.entities.Course
import com.example.animationdemo.utils.runInBackground
import javax.inject.Inject

class LocalDataSource @Inject constructor(application: Application) : DataSource {

    private val appDatabase: AppDatabase = AppDatabase.getDatabase(application)
    private val courseDao = appDatabase.courseDao()

    override fun newCourse(course: Course) = runInBackground {
        courseDao.newCourse(course)
    }

    override fun updateCourse(course: Course) = runInBackground {
        courseDao.updateCourse(course)
    }

    override fun getAllCourses(): LiveData<List<Course>> = courseDao.getAllCourses()
    override fun getCourse(courseID: Long): LiveData<Course> = courseDao.getCourse(courseID)
}
