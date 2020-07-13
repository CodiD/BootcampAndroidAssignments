package com.isabelledionisius.myomelettapp.omeletts.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Omelett(
    val title: String,
    val image: Int,
    val ingredients: String
) : Parcelable {
}



