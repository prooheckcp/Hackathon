package com.example.hackathon.Adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hackathon.R

import com.example.hackathon.Fragments.dummy.DummyContent.NoteItem


class NotesRecyclerAdapter(private val values: List<NoteItem>, val itemClick: (NoteItem) -> Unit) : RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_notes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item.name
        holder.nameView2.text = item.name
        holder.dateView.text = item.currentTime.toString()
        holder.view.setOnClickListener{
            itemClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.item_name)
        val nameView2: TextView = view.findViewById(R.id.item_name2)
        val dateView: TextView = view.findViewById(R.id.item_date)

        override fun toString(): String {
            return super.toString() + " '" + dateView.text + "'"
        }


    }
}