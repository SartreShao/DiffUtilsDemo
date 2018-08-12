package com.tipchou.diffutilsdemo

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by 邵励治 on 2018/8/12.
 * Perfect Code
 */
class MainRecyclerAdapter(viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_1 -> ViewHolder1(LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false))
            VIEW_2 -> ViewHolder2(LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false))
            else -> {
                throw Exception("")
            }
        }
    }


    companion object {
        private const val VIEW_1 = 0x0001
        private const val VIEW_2 = 0x0002
    }

    private var dataCopy: Data = Data("", ArrayList())

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

    class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textview)
        fun bind(text: String) {
            textView.text = text
        }
    }

    class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val texView: TextView = itemView.findViewById(R.id.textview)
        fun bind(text: String) {
            texView.text = text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_1
            else -> VIEW_2
        }
    }


    override fun getItemCount(): Int = dataCopy.list.size + 1

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            0 -> {
                (viewHolder as ViewHolder1).bind(dataCopy.text)
            }
            else -> {
                (viewHolder as ViewHolder2).bind(dataCopy.list[position - 1])
            }
        }
    }
}

data class Data(var text: String, val list: ArrayList<String>)
