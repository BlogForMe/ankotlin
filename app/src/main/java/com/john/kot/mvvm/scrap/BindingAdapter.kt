package com.john.kot.mvvm.scrap

import androidx.databinding.BindingAdapter
import com.android.util.view.ViewBodySleep

@BindingAdapter(value = ["app:setSleepData"])
fun sleepSetData(viewBodySleep: ViewBodySleep, spData: String) {
    viewBodySleep.setSleepData(spData)
}