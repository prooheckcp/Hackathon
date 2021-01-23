package com.example.hackathon.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.Adapters.classesAdapter
import com.example.hackathon.Adapters.weekdayAdapter
import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.Fragments.Notes
import com.example.hackathon.Fragments.dummy.DummyContent
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

    override fun onResume() {
        super.onResume()


        //Handle the views used for the input
        val nameInput = EditText(this)
        nameInput.hint = "Insert class name"
        nameInput.setTextColor(Color.BLACK)
        nameInput.textSize = 16f

        val linkInput = EditText(this)
        linkInput.hint = "Insert classroom link"
        linkInput.setTextColor(Color.BLACK)
        linkInput.textSize = 16f


        /*val picker =  MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(10)
                        .setTitle("Select Appointment time")
                        .build()*/

        //Clicked to add a classroom
        addClassButton.setOnClickListener {

            //Create the dialog box for the note||
            var newNoteBox = MaterialAlertDialogBuilder(this)
            newNoteBox.setTitle("New class")
            newNoteBox.setView(nameInput)
            newNoteBox.setMessage("Do you wish to add a new class?")
            newNoteBox.setPositiveButton("Create"){dialog, which ->

            }
            newNoteBox.setNegativeButton("Cancel"){_,_->}
            //__________________________________||
            newNoteBox.show()
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