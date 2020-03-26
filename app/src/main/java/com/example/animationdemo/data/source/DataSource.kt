package com.example.animationdemo.data.source

import androidx.lifecycle.LiveData
import com.example.animationdemo.data.source.local.entities.Certificate
import com.example.animationdemo.data.source.local.entities.Course

interface DataSource {

    fun newCourse(course: Course)

    fun updateCourse(course: Course)

    fun getAllCourses(): LiveData<List<Course>>

    fun getCourse(courseID: Long): LiveData<Course>

    fun newCertificate(certificate: Certificate)

    fun updateCertificate(certificate: Certificate)

    fun getAllCertificate(): LiveData<List<Certificate>>

    fun getCertificate(certificateID: Long): LiveData<Certificate>

}