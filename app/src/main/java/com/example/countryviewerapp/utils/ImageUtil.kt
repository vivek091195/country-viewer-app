package com.example.countryviewerapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.countryviewerapp.R

fun ImageView.loadImage(url: String?) {
    val options = RequestOptions().error(R.mipmap.ic_launcher_round)
    Glide.with(this.context).setDefaultRequestOptions(options).load(url).override(180, 160).into(this)
}