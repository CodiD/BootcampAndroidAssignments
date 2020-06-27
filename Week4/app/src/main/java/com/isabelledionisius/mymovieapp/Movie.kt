package com.isabelledionisius.mymovieapp

import android.os.Parcel
import android.os.Parcelable

 class Movie(
    val id: Int,
    val releaseDate: String,
    val title: String,
    val summary: String,
    val genre: String,
    val poster: Int
) : Parcelable {

    // the constructor calls the primary constructor
    constructor(parcel: Parcel) : this(
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!
    )

     /**
      * @ return the Movie information from the recycler view
      */
     companion object CREATOR : Parcelable.Creator<Movie> {
         override fun createFromParcel(parcel: Parcel): Movie {
             return Movie(parcel)
         }

         override fun newArray(size: Int): Array<Movie?> {
             return arrayOfNulls(size)
         }
     }

     /**
      * The info from the recycler view is being written to Parcel
      */

     override fun writeToParcel(dest: android.os.Parcel, flags: kotlin.Int) {
         dest.writeInt(id)
         dest.writeString(releaseDate)
         dest.writeString(title)
         dest.writeString(summary)
         dest.writeString(genre)
         dest.writeInt(poster)
     }

    // I am not dealing with file descriptors => providing 0 value
    override fun describeContents() = 0



 }



