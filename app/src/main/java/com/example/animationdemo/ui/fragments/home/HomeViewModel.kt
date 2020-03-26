package com.example.animationdemo.ui.fragments.home

import androidx.lifecycle.ViewModel
import com.example.animationdemo.data.DataRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(dataRepository: DataRepository) : ViewModel() {

    val coursesLiveData = dataRepository.getAllCourses()
    val certificatesLiveData = dataRepository.getAllCertificate()

}