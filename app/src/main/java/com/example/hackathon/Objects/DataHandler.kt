package com.example.hackathon.Objects

import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.Fragments.dummy.DummyContent

object DataHandler {

    var schedule : MutableList<scheduleClass> = mutableListOf<scheduleClass>(

        scheduleClass(12,16, "Maths", "www.google.com")

    )

    //This is your schedule divided by week days
    val yourSchedule : Map<String, MutableList<scheduleClass>> = mapOf(
        "Monday" to mutableListOf(
            scheduleClass(12,16, "Maths", "www.google.com")
        ),
        "Tuesday" to mutableListOf(),
        "Wednesday" to mutableListOf(),
        "Thursday" to mutableListOf(),
        "Friday" to mutableListOf()
    )

    //This is a list with all of the days of the week
    var weekDayList : MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

    //Store the last clicked weekday
    var selectedWeekDay : String = ""

   //Store the last clicked note
    var currentNote: DummyContent.NoteItem? = null

    //Store the window that you wished to be used when loading the main activity
    var lastwindow : Int = 0

}