package com.example.animationdemo.data.source

import androidx.lifecycle.LiveData
import com.example.animationdemo.data.source.local.entities.Course

interface DataSource {

    fun newCourse(course: Course)

    fun updateCourse(course: Course)

    fun getAllCourses(): LiveData<List<Course>>

    fun getCourse(courseID: Long): LiveData<Course>

}