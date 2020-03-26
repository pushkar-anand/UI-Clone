package com.example.animationdemo.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.animationdemo.data.source.local.entities.Certificate
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_course.view.*

class CertificateRVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(certificate: Certificate) {
        itemView.certificateTitleTV.text = certificate.name
        itemView.courseIllustration.setImageDrawable(certificate.illustration)
    }

}