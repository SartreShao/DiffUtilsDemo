package com.tipchou.diffutilsdemo

import android.support.v7.util.DiffUtil

/**
 * Created by 邵励治 on 2018/8/12.
 * Perfect Code
 */
class MainDiffCallback(private val oldData: Data, private val newData: Data) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldData.list[oldItemPosition].javaClass == newData.list[oldItemPosition].javaClass

    override fun getOldListSize(): Int = oldData.list.size
    override fun getNewListSize(): Int = newData.list.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldData.list[oldItemPosition] == newData.list[newItemPosition]

}
