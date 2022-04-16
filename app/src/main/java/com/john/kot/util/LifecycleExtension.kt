package com.john.kot.util

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 *
 * ClassName:      LifecycleExtension
 * Description:    Description
 * Author:         SongLei
 * CreateDate:     7/14/21 11:22 上午
 * UpdateUser:     SongLei
 * UpdateDate:     7/14/21 11:22 上午
 * UpdateRemark:   Modify the description
 */
fun Lifecycle.observerWhenDestroyed(destroyed: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, destroyed = destroyed))
}

fun Lifecycle.observerWhenCreated(create: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, create = create))
}

class LifecycleObserver(
    var lifecycle: Lifecycle?,
    var destroyed: (() -> Unit)? = null,
    var create: (() -> Unit)? = null
) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        create?.invoke()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        destroyed?.invoke()
        lifecycle?.apply {
            removeObserver(this@LifecycleObserver)
            lifecycle = null
        }
        create = null
        destroyed = null
    }
}