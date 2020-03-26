package com.example.animationdemo.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.animationdemo.data.source.local.entities.Course
import kotlinx.android.synthetic.main.item_course.view.*

class CoursesRVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(course: Course) {
        itemView.courseNameTV.text = course.title
        itemView.courseIllustration.setImageResource(course.illustration)
        /*Picasso.get().load(course.illustration).into(itemView.courseIllustration, object: Callback{
            override fun onSuccess() {
                Log.d(javaClass.simpleName, "Image Loaded")
            }

            override fun onError(e: Exception?) {
                e?.printStackTrace()
            }
        })*/
        itemView.courseCard.setCardBackgroundColor(course.cardColor)
    }

}