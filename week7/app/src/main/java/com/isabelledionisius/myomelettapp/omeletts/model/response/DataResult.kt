package com.isabelledionisius.myomelettapp.omeletts.model.response
import kotlinx.serialization.Serializable

@Serializable
data class DataResult(
    //val href: String,
    val ingredients: String,
    val thumbnail: String,
    val title: String
)