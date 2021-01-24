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

        //Change the class name
        holder.nameView.text = item.className
        holder.nameView2.text = item.className


        var timeDisplay = ""

        //Calculate the string||

            //Set the starting hour
            if(item.startingHour < 10){
                timeDisplay = timeDisplay + "0" + item.startingHour.toString() + ":"
            }else{
                timeDisplay = item.startingHour.toString() + ":"
            }

            //Set the starting minute
            if(item.startingMinute < 10){
                timeDisplay = timeDisplay + "0" + item.startingMinute.toString()
            }else{
                timeDisplay += item.startingMinute.toString()
            }

            if(item.startingHour >= 12){
                timeDisplay += "PM-"
            }else{
                timeDisplay += "AM-"
            }

            //Set the ending hour
            if(item.endingHour < 10){
                timeDisplay += "0" + item.endingHour.toString() + ":"
            }else{
                timeDisplay += item.endingHour.toString() + ":"
            }

            //Set the ending minute
            if(item.endingMinute < 10){
                timeDisplay += "0" + item.endingMinute.toString()
            }else{
                timeDisplay += item.endingMinute.toString()
            }

            if(item.endingHour >= 12){
                timeDisplay += "PM"
            }else{
                timeDisplay += "AM"
            }
        //____________________||





        //Change the class time
        holder.timeView.text = timeDisplay
        holder.timeView2.text = timeDisplay

        //Change the class link
        holder.linkView.text = item.classLink
        holder.linkView2.text = item.classLink

        holder.view.setOnClickListener{
            itemClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        //Views that hold the class name
        val nameView: TextView = view.findViewById(R.id.item_name)
        val nameView2: TextView = view.findViewById(R.id.item_name2)

        //Views that hold the class hour
        val timeView : TextView = view.findViewById(R.id.item_name3)
        val timeView2 : TextView = view.findViewById(R.id.item_name4)

        //Views that hold the class link
        val linkView : TextView = view.findViewById(R.id.item_name5)
        val linkView2 : TextView = view.findViewById(R.id.item_name6)

    }
}