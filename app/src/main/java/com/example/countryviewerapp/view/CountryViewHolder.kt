package com.example.countryviewerapp.view

import android.graphics.BitmapFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.countryviewerapp.databinding.CountryBinding
import com.example.countryviewerapp.viewmodel.CountryListViewModel

class CountryViewHolder(private val binding: CountryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CountryListViewModel.State.Country) {
        with(binding) {
            countryName.text = item.countryName
            countryFlag.setImageBitmap(BitmapFactory.decodeStream(item.flag.byteInputStream()))
        }
    }
}