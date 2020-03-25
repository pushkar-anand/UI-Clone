package com.example.animationdemo.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.animationdemo.AnimationDemo
import com.example.animationdemo.R
import javax.inject.Inject

class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var testViewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as AnimationDemo).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        testViewModel = ViewModelProvider(this, viewModelFactory)[TestViewModel::class.java]
        Log.d("Injected Data", testViewModel.data)
    }
}
