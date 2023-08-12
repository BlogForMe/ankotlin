package com.kot.arch.recyclerview

import androidx.lifecycle.ViewModel

class RecycleViewModel : ViewModel() {

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    fun initDataset(): List<String> {
        return arrayOf("100", "100", "100", "100", "100").toList()
    }
}