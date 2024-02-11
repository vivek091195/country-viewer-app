package com.example.countryviewerapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.countryviewerapp.R
import com.example.countryviewerapp.viewmodel.CountryListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val countryListViewModel: CountryListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
    }
}