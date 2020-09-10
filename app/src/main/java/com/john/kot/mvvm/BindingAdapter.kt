package com.john.kot.mvvm

import android.view.View
import androidx.databinding.BindingAdapter
import com.android.util.view.ViewBodySleep

@BindingAdapter(value=["app:setSleepData"])
fun setSleepData(viewBodySleep: ViewBodySleep, sleepData: String) {
    viewBodySleep.setSleepData(sleepData)
}

@BindingAdapter("app:visibleUnless")
fun visibleUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("app:goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}