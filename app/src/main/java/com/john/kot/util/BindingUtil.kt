package com.john.kot.util

import android.graphics.drawable.GradientDrawable
import android.view.View

import androidx.databinding.BindingAdapter


@BindingAdapter(value = ["drawable_solidColor", "drawable_radius"], requireAll = false)
fun setViewBackground(view: View?, color: Int, radius: Int) {
    val drawable = GradientDrawable()
    drawable.setColor(color)
    drawable.cornerRadius = radius.toFloat()
    view?.background = drawable
}

