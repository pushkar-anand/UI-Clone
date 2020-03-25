package com.example.animationdemo.data

import androidx.lifecycle.LiveData
import com.example.animationdemo.data.source.DataSource
import com.example.animationdemo.data.source.local.LocalDataSource
import com.example.animationdemo.data.source.local.entities.Course
import javax.inject.Inject

class DataRepository @Inject constructor(private val localDataSource: LocalDataSource) :
    DataSource {

    override fun newCourse(course: Course) {
        localDataSource.newCourse(course)
    }

    override fun updateCourse(course: Course) {
        localDataSource.updateCourse(course)
    }

    override fun getAllCourses(): LiveData<List<Course>> {
        return localDataSource.getAllCourses()
    }

    override fun getCourse(courseID: Long): LiveData<Course> {
        return localDataSource.getCourse(courseID)
    }

    fun getData() = "Works great."
}