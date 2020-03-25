package com.example.animationdemo.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class Course(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "course_id")
    val id: Long,

    @ColumnInfo(name = "course_title")
    var title: String

)