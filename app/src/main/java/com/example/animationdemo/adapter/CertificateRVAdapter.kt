package com.example.animationdemo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animationdemo.R
import com.example.animationdemo.adapter.viewholder.CertificateRVHolder
import com.example.animationdemo.data.source.local.entities.Certificate

class CertificateRVAdapter : RecyclerView.Adapter<CertificateRVHolder>() {

    private var certificates = emptyList<Certificate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CertificateRVHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_certificate, parent, false)
    )

    override fun getItemCount() = certificates.size

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: CertificateRVHolder, position: Int) {
        val certificate = certificates[position]
        holder.bind(certificate)

        holder.certificateCard.setOnLongClickListener {
            onLongPress?.invoke(certificate)
            true
        }

    }

    fun updateCertificates(certificates: List<Certificate>) {
        this.certificates = certificates
        notifyDataSetChanged()
    }


    var onLongPress: ((certificate: Certificate) -> Unit)? = null


}