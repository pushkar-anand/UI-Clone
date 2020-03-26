package com.example.animationdemo.ui.fragments.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.animationdemo.AnimationDemo
import com.example.animationdemo.R
import com.example.animationdemo.adapter.CertificateRVAdapter
import com.example.animationdemo.adapter.CoursesRVAdapter
import com.example.animationdemo.data.source.local.entities.Certificate
import com.example.animationdemo.data.source.local.entities.Course
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var coursesRVAdapter: CoursesRVAdapter
    private lateinit var certificateRVAdapter: CertificateRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as AnimationDemo).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViews()
    }

    override fun onResume() {
        super.onResume()
        addObservers()
    }

    override fun onPause() {
        super.onPause()
        removeObservers()
    }

    private fun initRecyclerViews() {
        coursesRVAdapter = CoursesRVAdapter()
        coursesRV.adapter = coursesRVAdapter

        certificateRVAdapter = CertificateRVAdapter()
        certificateRV.adapter = certificateRVAdapter

    }

    private fun addObservers() {
        homeViewModel.coursesLiveData.observe(requireActivity(), courseListObserver)
        homeViewModel.certificatesLiveData.observe(requireActivity(), certificateListObserver)
    }

    private fun removeObservers() {
        homeViewModel.coursesLiveData.removeObserver(courseListObserver)
        homeViewModel.certificatesLiveData.removeObserver(certificateListObserver)
    }

    private val courseListObserver = Observer<List<Course>> {
        val courses = addColorAndIllustrationsToCourses(it)
        coursesRVAdapter.updateCourses(courses)
    }

    private val certificateListObserver = Observer<List<Certificate>> {
        val certificates = addIllustrationsToCertificates(it)
        certificateRVAdapter.updateCertificates(certificates)
    }

    private fun addColorAndIllustrationsToCourses(list: List<Course>): List<Course> {
        val colors = requireActivity().resources.getIntArray(R.array.colorCourseCardBackground)
        val illustrations = listOf(
            R.drawable.illustration1,
            R.drawable.illustration2,
            R.drawable.illustration3
        )

        val courses = mutableListOf<Course>()
        list.forEachIndexed { index, course ->
            course.cardColor = colors[index % colors.size]
            course.illustration = illustrations[index % illustrations.size]
            courses.add(course)
        }
        return courses
    }

    private fun addIllustrationsToCertificates(list: List<Certificate>): List<Certificate> {
        val illustrations = listOf(
            R.drawable.certificate1,
            R.drawable.certificate2,
            R.drawable.illustration3
        )

        val certificates = mutableListOf<Certificate>()
        list.forEachIndexed { index, certificate ->
            certificate.illustration = illustrations[index % illustrations.size]
            certificates.add(certificate)
        }
        return certificates
    }

}
