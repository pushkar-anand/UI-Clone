package com.example.animationdemo.ui.fragments.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.animationdemo.AnimationDemo
import com.example.animationdemo.R
import com.example.animationdemo.adapter.CertificateRVAdapter
import com.example.animationdemo.adapter.CoursesRVAdapter
import com.example.animationdemo.data.source.local.entities.Certificate
import com.example.animationdemo.data.source.local.entities.Course
import kotlinx.android.synthetic.main.content_home.*
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
        val navController = findNavController()
        AppBarConfiguration(navController.graph, navDrawer)
        navigationView.setupWithNavController(navController)
        navDrawerIMG.setOnClickListener {
            navDrawer.open()
        }
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
        certificateRVAdapter.onLongPress = ::showCertificate

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
        coursesRVAdapter.updateCourses(it)
        nmbrOfCoursesTV.text = requireActivity().resources.getQuantityString(
            R.plurals.no_courses,
            it.size,
            it.size
        )
    }

    private val certificateListObserver = Observer<List<Certificate>> {
        certificateRVAdapter.updateCertificates(it)
    }

    private fun showCertificate(certificate: Certificate) {
        Log.d(javaClass.simpleName, "Long Press ${certificate.name}")
    }


}
