package com.tipchou.diffutilsdemo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by 邵励治 on 2018/8/12.
 * Perfect Code
 */
class MainViewModel : ViewModel() {
    private val recyclerData = MutableLiveData<Data>()

    fun getRecyclerData(): MutableLiveData<Data> {
        return recyclerData
    }

    fun setRecyclerData(data: Data) {
        recyclerData.value = data
    }
}
