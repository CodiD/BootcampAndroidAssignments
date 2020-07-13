package com.isabelledionisius.myomelettapp.extensions


import android.view.View

fun View.onClick(onClickAction: () -> Unit) {
    setOnClickListener { onClickAction() }
}