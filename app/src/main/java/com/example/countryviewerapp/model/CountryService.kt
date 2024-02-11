package com.example.countryviewerapp.model

class CountryService {
    fun getCountryService(): CountryApi {
        return RetrofitClient.getClient().create(CountryApi::class.java)
    }
}