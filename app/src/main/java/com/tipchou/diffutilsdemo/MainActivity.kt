package com.tipchou.diffutilsdemo

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        var i = 1
        button.setOnClickListener {
            val data = Data("我是" + i.toString(), arrayListOf())
            for (item in 1..i) {
                data.list.add(item.toString())
            }
            i++
            viewModel.setRecyclerData(data)
        }
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = MainRecyclerAdapter(viewModel)
    }
}
