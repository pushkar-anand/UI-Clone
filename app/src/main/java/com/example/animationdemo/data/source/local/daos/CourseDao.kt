package com.example.animationdemo.data.source.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.animationdemo.data.source.local.entities.Course

@Dao
interface CourseDao {
    @Insert
    fun newCourse(course: Course): Long

    @Update
    fun updateCourse(course: Course)

    @Query("SELECT * FROM courses")
    fun getAllCourses(): LiveData<List<Course>>

    @Query("SELECT * FROM courses WHERE course_id = :courseID")
    fun getCourse(courseID: Long): LiveData<Course>
}