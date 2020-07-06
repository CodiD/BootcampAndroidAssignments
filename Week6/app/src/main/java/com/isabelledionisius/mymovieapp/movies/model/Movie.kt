package com.isabelledionisius.mymovieapp.movies.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
 class Movie(
    val id: Int,
    val releaseDate: String,
    val title: String,
    val summary: String,
    val genre: String,
    val poster: Int
) : Parcelable {
    // I am not dealing with file descriptors => providing 0 value
    override fun describeContents() = 0
 }



