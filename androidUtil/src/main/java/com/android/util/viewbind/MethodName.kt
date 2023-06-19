package com.android.util.viewbind

import android.view.LayoutInflater
import android.view.View
import java.lang.reflect.Method

/**
 *
 * ClassName:      ClassExt
 * Description:    Description
 * Author:         SongLei
 * CreateDate:     4/27/22 5:35 下午
 * UpdateUser:     SongLei
 * UpdateDate:     4/27/22 5:35 下午
 * UpdateRemark:   Modify the description
 */
private const val INFLATE_NAME = "inflate"
private const val BIND_NAME = "bind"

internal fun <T> Class<T>.inflateMethod(): Method =
    getMethod(INFLATE_NAME, LayoutInflater::class.java)

internal fun <T> Class<T>.bindMethod(): Method = getMethod(BIND_NAME, View::class.java)