package com.example.hackathon.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.R

class classesAdapter(private val values: List<scheduleClass>, val itemClick: (scheduleClass) -> Unit) : RecyclerView.Adapter<classesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.class_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item.className
        holder.nameView2.text = item.className
        //holder.dateView.text = item.currentTime.toString()
        holder.view.setOnClickListener{
            itemClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.item_name)
        val nameView2: TextView = view.findViewById(R.id.item_name2)

    }
}