package com.isabelledionisius.myomelettapp.omeletts.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Omelett(
    val title: String,
    val thumbnail: String?,
    val ingredients: String
) : Parcelable {
}



