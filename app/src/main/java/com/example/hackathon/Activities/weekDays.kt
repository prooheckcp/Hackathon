package com.example.hackathon.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.Adapters.weekdayAdapter
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import kotlinx.android.synthetic.main.activity_week_days.*

class weekDays : AppCompatActivity() {

    //Variables||
        lateinit var adapter: weekdayAdapter
    //_________||


    override fun onCreate(savedInstanceState: Bundle?) {

        //Inflate the layout into the phone
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week_days)

        //Inflate the adapter into the recycler view
        addWeekdayAdapter()

        //Set the go back button to go back into the home page
        goBackButton.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            DataHandler.lastwindow = 0 //Tell the code on which fragment are we spawning
            startActivity(intent)
        }
    }

    fun addWeekdayAdapter(){
        //Inflate on the adapter||

            adapter = weekdayAdapter(DataHandler.weekDayList){item->
                val intent = Intent(this, schedulesList::class.java)
                DataHandler.selectedWeekDay = item
                startActivity(intent)
            }
            weekdayList.adapter = adapter
            val layoutManager = LinearLayoutManager(HomePage())
            weekdayList.layoutManager = layoutManager
        //______________________||
    }

}