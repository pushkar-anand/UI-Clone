package com.example.animationdemo.ui.fragments.certificate

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.animationdemo.AnimationDemo
import com.example.animationdemo.R
import kotlinx.android.synthetic.main.fragment_certificate.*
import javax.inject.Inject


class CertificateFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var certificateViewModel: CertificateViewModel

    private val args: CertificateFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        certificateViewModel =
            ViewModelProvider(this, viewModelFactory).get(CertificateViewModel::class.java)
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_certificate, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as AnimationDemo).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val certificateID = args.CERTID
        if (certificateID == -1L) {
            findNavController().popBackStack()
        }
        certificateViewModel.certificateID = certificateID
        certificateViewModel.certificateLiveData.observe(viewLifecycleOwner, Observer {
            certificateNameTV.text = it.name
            certIllusIMG.setImageResource(it.illustration)
            certIssueTV.text = getString(R.string.certificate_issues_text, it.name)
        })

    }
}
