package com.kot.mvvm.demo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserDemo(var name: String = "", var age: Int = 0, var address: String) : Animal(), Parcelable
