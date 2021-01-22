package com.example.hackathon.Adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hackathon.R

import com.example.hackathon.Fragments.dummy.DummyContent.NoteItem


class weekdayAdapter(private val values: List<String>, val itemClick: (String) -> Unit) : RecyclerView.Adapter<weekdayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weekday_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item
        holder.nameView2.text = item
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