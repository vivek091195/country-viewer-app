package com.example.countryviewerapp.model

import retrofit2.Call
import retrofit2.http.GET

interface CountryApi {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountry(): Call<List<Country>>
}