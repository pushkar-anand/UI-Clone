package com.example.animationdemo.ui.activities

import androidx.lifecycle.ViewModel
import com.example.animationdemo.data.DataRepository
import javax.inject.Inject

class TestViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {
    val data = dataRepository.getData()
}