package com.example.myapps.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapps.R
import com.example.myapps.models.DailyItem

class DailyAdapter(private val items: List<DailyItem>) :
    RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {

    inner class DailyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleDaily)
        val desc: TextView = view.findViewById(R.id.descDaily)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_daily, parent, false)
        return DailyViewHolder(view)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.desc.text = item.description
    }

    override fun getItemCount(): Int = items.size
}
