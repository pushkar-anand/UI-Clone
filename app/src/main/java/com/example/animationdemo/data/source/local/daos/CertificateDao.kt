package com.example.animationdemo.data.source.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.animationdemo.data.source.local.entities.Certificate

@Dao
interface CertificateDao {

    @Insert
    fun newCertificate(certificate: Certificate): Long

    @Update
    fun updateCertificate(certificate: Certificate)

    @Query("SELECT * FROM certificates")
    fun getAllCertificate(): LiveData<List<Certificate>>

    @Query("SELECT * FROM certificates WHERE certificate_id = :certificateID")
    fun getCertificate(certificateID: Long): LiveData<Certificate>

}