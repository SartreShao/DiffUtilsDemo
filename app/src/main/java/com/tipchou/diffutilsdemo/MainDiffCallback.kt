package com.tipchou.diffutilsdemo

import android.support.v7.util.DiffUtil

/**
 * Created by 邵励治 on 2018/8/12.
 * Perfect Code
 */
class MainDiffCallback(private val oldData: Data, private val newData: Data) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (oldItemPosition == 0) {
            if (newItemPosition == 0) {
                oldData.text.javaClass == newData.text.javaClass
            } else {
                oldData.text.javaClass == newData.list[newItemPosition - 1].javaClass
            }
        } else {
            if (newItemPosition == 0) {
                oldData.list[oldItemPosition - 1].javaClass == newData.text.javaClass
            } else {
                oldData.list[oldItemPosition - 1].javaClass == newData.list[newItemPosition - 1].javaClass
            }
        }
    }

    override fun getOldListSize(): Int = oldData.list.size + 1

    override fun getNewListSize(): Int = newData.list.size + 1

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (oldItemPosition == 0) {
            if (newItemPosition == 0) {
                oldData.text == newData.text
            } else {
                oldData.text == newData.list[newItemPosition - 1]
            }
        } else {
            if (newItemPosition == 0) {
                oldData.list[oldItemPosition - 1] == newData.text
            } else {
                oldData.list[oldItemPosition - 1] == newData.list[newItemPosition - 1]
            }
        }
    }
}
