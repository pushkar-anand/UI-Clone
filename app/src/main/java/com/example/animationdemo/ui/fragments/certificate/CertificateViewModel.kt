package com.example.animationdemo.ui.fragments.certificate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.animationdemo.R
import com.example.animationdemo.data.DataRepository
import com.example.animationdemo.data.source.local.entities.Certificate
import javax.inject.Inject

class CertificateViewModel @Inject constructor(private val dataRepository: DataRepository) :
    ViewModel() {

    private val idLiveData = MutableLiveData<Long>()
    var certificateID: Long = 0
        set(value) {
            field = value
            idLiveData.postValue(value)
        }

    private val certificateData = Transformations.switchMap(idLiveData) {
        dataRepository.getCertificate(it)
    }

    val certificateLiveData = Transformations.switchMap(certificateData) {
        val cert = addIllustrationsToCertificate(it)
        MutableLiveData(cert)
    }

    private fun addIllustrationsToCertificate(certificate: Certificate): Certificate {
        val illustrations = listOf(
            R.drawable.certificate1,
            R.drawable.certificate2,
            R.drawable.certificate3
        )
        certificate.illustration = illustrations[(certificate.id % 3).toInt()]
        return certificate
    }

}