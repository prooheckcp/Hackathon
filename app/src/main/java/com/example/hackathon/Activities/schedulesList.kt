package com.example.hackathon.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.Adapters.classesAdapter
import com.example.hackathon.Adapters.weekdayAdapter
import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import kotlinx.android.synthetic.main.activity_schedules_list.*
import kotlinx.android.synthetic.main.activity_week_days.*

class schedulesList : AppCompatActivity() {

    //Variables||

        lateinit var adapter: classesAdapter //Holds the adapter to be inflated
    //_________||


    override fun onCreate(savedInstanceState: Bundle?) {

        //Inflate the layout into the phone
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedules_list)

        //Change the title of the window to the correct weekday
        windowTitleClasses.text = DataHandler.selectedWeekDay

        //Inflate the viewer
        classesAdapter()

        //Go back into the week days list
        goBackButtonSchedule.setOnClickListener {
            val intent = Intent(this, weekDays::class.java)
            startActivity(intent)
        }
    }

    //Holds the adapter for the classes||

        fun classesAdapter(){
            //Inflate on the adapter||

                val daysClasses : MutableList<scheduleClass> = DataHandler.yourSchedule[DataHandler.selectedWeekDay] ?: error("Didn't find the correct day")

                adapter = classesAdapter(daysClasses){item->
                    println(item.className)
                }
                scheduleRecycler.adapter = adapter
                val layoutManager = LinearLayoutManager(HomePage())
                scheduleRecycler.layoutManager = layoutManager
            //______________________||
        }
    //_________________________________||
}