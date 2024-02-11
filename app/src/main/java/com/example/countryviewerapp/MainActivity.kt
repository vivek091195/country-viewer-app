package com.example.countryviewerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.countryviewerapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
    }
}