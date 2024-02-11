package com.example.countryviewerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.countryviewerapp.R
import com.example.countryviewerapp.databinding.CountryBinding
import com.example.countryviewerapp.databinding.HomepageBinding
import com.example.countryviewerapp.viewmodel.CountryListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val countryListViewModel: CountryListViewModel by viewModels()
    private val countryAdapter = CountryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: HomepageBinding = HomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countryListRecyclerView.adapter = countryAdapter
        countryListViewModel.fetchCountryData()

        CoroutineScope(Dispatchers.Main).launch {
            countryListViewModel.countryList.collect {
                binding.loader.isVisible = it.loading
                countryAdapter.submitList(it.countryList)
            }
        }
    }
}