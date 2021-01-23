package com.example.hackathon.Activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.Adapters.classesAdapter
import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.Objects.DataHandler.selectedWeekDay
import com.example.hackathon.Objects.DataHandler.yourSchedule
import com.example.hackathon.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_schedules_list.*
import kotlinx.android.synthetic.main.activity_week_days.*
import kotlinx.android.synthetic.main.class_input_box.*


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


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onResume() {
        super.onResume()



        //Clicked to add a classroom
        addClassButton.setOnClickListener {

            val newClassLayout = layoutInflater.inflate(R.layout.class_input_box, null, false)

            //Create the dialog box for the note||
            var newNoteBox = MaterialAlertDialogBuilder(this)


            newNoteBox.setView(newClassLayout)
            newNoteBox.setPositiveButton("Create"){ dialog, which ->
                val className : String = newClassLayout.findViewById<EditText>(R.id.classNameInput).text.toString()
                val classLink : String = newClassLayout.findViewById<EditText>(R.id.classLinkInput).text.toString()
                val startingHour = newClassLayout.findViewById<TimePicker>(R.id.timePicker).hour
                val startingMinute = newClassLayout.findViewById<TimePicker>(R.id.timePicker).minute
                val endingHour = newClassLayout.findViewById<TimePicker>(R.id.timePicker2).hour
                val endingMinute = newClassLayout.findViewById<TimePicker>(R.id.timePicker).minute

                //Check if the hour is in a valid format
                if(startingHour > endingHour || (startingHour == endingHour && startingMinute >= endingMinute)){
                    notification("Your class can't end before it starts can it?")
                }else{
                    (yourSchedule[selectedWeekDay] ?: error("")).add(scheduleClass(
                        startingHour,
                        startingMinute,
                        endingHour,
                        endingMinute,
                        className,
                        classLink
                    ))

                    //Reset the adapter
                    val intent = Intent(this, schedulesList::class.java)
                    startActivity(intent)
                    //classesAdapter()
                }

            }
            newNoteBox.setNegativeButton("Cancel"){ _, _->}
            //__________________________________||
            newNoteBox.show()
        }
    }

    //Handle box notifications
    fun notification(message : String){
        MaterialAlertDialogBuilder(this)
            .setTitle(message)
            .setItems(arrayOf("ok")){_,_->}
            .show()
    }

    //Holds the adapter for the classes||

        fun classesAdapter(){
            //Inflate on the adapter||

                val daysClasses : MutableList<scheduleClass> = DataHandler.yourSchedule[DataHandler.selectedWeekDay] ?: error(
                    "Didn't find the correct day"
                )

                adapter = classesAdapter(daysClasses){ item->
                    println(item.className)
                }
                scheduleRecycler.adapter = adapter
                val layoutManager = LinearLayoutManager(HomePage())
                scheduleRecycler.layoutManager = layoutManager
            //______________________||
        }
    //_________________________________||
}
