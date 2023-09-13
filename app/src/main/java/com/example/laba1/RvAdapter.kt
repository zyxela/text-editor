package com.example.laba1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter:RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val ll = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return Holder(ll)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.font).text = "item $position"
    }
}

class Holder(item:View):RecyclerView.ViewHolder(item){

}