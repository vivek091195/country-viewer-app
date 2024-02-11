package com.example.countryviewerapp.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryName: String,

    @SerializedName("flagPNG")
    val flag: String,

    @SerializedName("numericCode")
    val numericCode: String
)
