package com.example.animationdemo.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.animationdemo.data.source.local.entities.Certificate
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_certificate.view.*

class CertificateRVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val certificateCard: MaterialCardView = itemView.certificateCard

    fun bind(certificate: Certificate) {
        itemView.certificateNameTV.text = certificate.name
        itemView.certIllusIMG.setImageResource(certificate.illustration)
//        Picasso.get().load(certificate.illustration).into(itemView.certIllusIMG)
    }

}