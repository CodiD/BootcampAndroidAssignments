package com.isabelledionisius.myomelettapp.omeletts.model.response

data class OmelettData(
    val href: String,
    val results: List<DataResult>,
    val title: String,
    val version: Double
)