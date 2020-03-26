package com.example.animationdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animationdemo.R
import com.example.animationdemo.adapter.viewholder.CoursesRVHolder
import com.example.animationdemo.data.source.local.entities.Course

class CoursesRVAdapter : RecyclerView.Adapter<CoursesRVHolder>() {
    private var courses = emptyList<Course>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CoursesRVHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
    )

    override fun getItemCount() = courses.size

    override fun onBindViewHolder(holder: CoursesRVHolder, position: Int) {
        val course = courses[position]
        holder.bind(course)
    }

    fun updateCourses(courses: List<Course>) {
        this.courses = courses
        notifyDataSetChanged()
    }
}