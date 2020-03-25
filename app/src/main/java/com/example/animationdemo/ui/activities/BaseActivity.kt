package com.example.animationdemo.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animationdemo.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
