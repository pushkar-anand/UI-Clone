package com.example.animationdemo.ui.fragments.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.animationdemo.R
import com.example.animationdemo.data.DataRepository
import com.example.animationdemo.data.source.local.entities.Certificate
import com.example.animationdemo.data.source.local.entities.Course
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val application: Application,
    dataRepository: DataRepository
) : ViewModel() {

    private val courses = dataRepository.getAllCourses()
    private val certificates = dataRepository.getAllCertificate()

    val coursesLiveData = Transformations.switchMap(courses) {
        addColorAndIllustrationsToCourses(it)
        MutableLiveData(it)
    }

    val certificatesLiveData = Transformations.switchMap(certificates) {
        addIllustrationsToCertificates(it)
        MutableLiveData(it)
    }

    private fun addColorAndIllustrationsToCourses(list: List<Course>): List<Course> {
        val colors = application.resources.getIntArray(R.array.colorCourseCardBackground)
        val illustrations = listOf(
            R.drawable.illustration1,
            R.drawable.illustration2,
            R.drawable.illustration3
        )

        list.forEachIndexed { index, course ->
            course.cardColor = colors[index % colors.size]
            course.illustration = illustrations[index % illustrations.size]
        }
        return list
    }

    private fun addIllustrationsToCertificates(list: List<Certificate>): List<Certificate> {
        val illustrations = listOf(
            R.drawable.certificate1,
            R.drawable.certificate2,
            R.drawable.certificate3
        )

        list.forEachIndexed { index, certificate ->
            certificate.illustration = illustrations[index % illustrations.size]
        }
        return list
    }

}