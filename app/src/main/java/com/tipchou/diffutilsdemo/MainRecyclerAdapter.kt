package com.tipchou.diffutilsdemo

import android.annotation.SuppressLint
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by 邵励治 on 2018/8/12.
 * Perfect Code
 */
class MainRecyclerAdapter(viewModel: MainViewModel) : RecyclerView.Adapter<MainRecyclerAdapter.MyViewHolder>() {

    private var dataCopy: Data = Data(ArrayList())

    init {
        viewModel.getRecyclerData().observeForever {

            val oldData = dataCopy
            val data = it
            if (data != null) {
                dataCopy = data
            }
            val diffResult = DiffUtil.calculateDiff(MainDiffCallback(oldData, dataCopy))
            diffResult.dispatchUpdatesTo(this)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textview)
        fun bind(text: String) {
            textView.text = text
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder = MyViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item, p0, false))

    override fun getItemCount(): Int = dataCopy.list.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.bind(dataCopy.list[p1])
    }
}

data class Data(val list: ArrayList<String>)
