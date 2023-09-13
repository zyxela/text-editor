package com.example.laba1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laba1.view.MainViewModel

class RvAdapter(val viewModel: MainViewModel, val fonts: List<String>) :
    RecyclerView.Adapter<RvAdapter.Holder>() {
    class Holder(item: View) : RecyclerView.ViewHolder(item) {
        init {
            item.findViewById<TextView>(R.id.font).setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val ll = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return Holder(ll)
    }

    override fun getItemCount(): Int {
        return fonts.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val fontView = holder.itemView.findViewById<TextView>(R.id.font)
        fontView.text = fonts[position]
        fontView.setOnClickListener {
            viewModel.font.value = fontView.text.toString()
        }
    }
}

