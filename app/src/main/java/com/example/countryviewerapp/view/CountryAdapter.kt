package com.example.countryviewerapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countryviewerapp.databinding.CountryBinding
import com.example.countryviewerapp.viewmodel.CountryListViewModel


var selectedPosition: Int = RecyclerView.NO_POSITION

class CountryAdapter :
    ListAdapter<CountryListViewModel.State.Country, CountryAdapter.CountryViewHolder>(DIFF_CALLBACK) {
    private lateinit var binding: CountryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        binding = CountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            notifyItemChanged(selectedPosition)
            selectedPosition = position
            notifyItemChanged(selectedPosition)
        }
    }

    class CountryViewHolder(private val binding: CountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CountryListViewModel.State.Country) {
            with(binding) {
                countryName.text = item.countryName
                if (selectedPosition == layoutPosition) {
                    countryCard.setCardBackgroundColor(android.graphics.Color.GRAY)
                    countryName.setTextColor(android.graphics.Color.WHITE)
                } else {
                    countryCard.setCardBackgroundColor(android.graphics.Color.WHITE)
                    countryName.setTextColor(android.graphics.Color.GRAY)
                }
            }
        }
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