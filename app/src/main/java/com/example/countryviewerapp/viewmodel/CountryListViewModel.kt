package com.example.countryviewerapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.countryviewerapp.model.CountryService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryListViewModel : ViewModel() {
    private val _countriesList = MutableStateFlow(State())
    val countryList = _countriesList.asStateFlow()
    private val countryService = CountryService().getCountryService()

    fun fetchCountryData() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = countryService.getCountry().execute()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    _countriesList.update {
                        it.copy(
                            countryList = response.body()?.map { country ->
                                State.Country(
                                    countryName = country.countryName,
                                    flag = country.flag,
                                    numericCode = country.numericCode
                                )
                            },
                            error = null,
                            loading = false
                        )
                    }
                } else {
                    _countriesList.update {
                        it.copy(
                            countryList = null,
                            error = State.ErrorDetails(
                                code = response.code(),
                                message = response.message()
                            ),
                            loading = false
                        )
                    }
                }
            }
        }
    }

    data class State(
        val countryList: List<Country>? = null,
        val error: ErrorDetails? = null,
        val loading: Boolean = false
    ) {
        data class Country(
            val countryName: String,
            val flag: String,
            val numericCode: String? = ""
        )

        data class ErrorDetails(
            val message: String,
            val code: Int
        )
    }

}