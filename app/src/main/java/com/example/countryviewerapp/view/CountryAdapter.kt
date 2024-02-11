package com.example.countryviewerapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.countryviewerapp.databinding.CountryBinding
import com.example.countryviewerapp.viewmodel.CountryListViewModel

class CountryAdapter :
    ListAdapter<CountryListViewModel.State.Country, CountryViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CountryListViewModel.State.Country>() {
            override fun areItemsTheSame(
                oldItem: CountryListViewModel.State.Country,
                newItem: CountryListViewModel.State.Country
            ): Boolean {
                return oldItem.numericCode == newItem.numericCode
            }

            override fun areContentsTheSame(
                oldItem: CountryListViewModel.State.Country,
                newItem: CountryListViewModel.State.Country
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}