package com.example.hackathon.Objects

import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.Fragments.dummy.DummyContent

object DataHandler {

    //This is your schedule divided by week days
    val yourSchedule : Map<String, MutableList<scheduleClass>> = mapOf(
        "Monday" to mutableListOf(
            scheduleClass(8, 0,11, 0, "Game Frameworks", "www.google.com"),
            scheduleClass(11, 0,14, 0, "Math, Physics and Games II", "www.google.com")
        ),
        "Tuesday" to mutableListOf(
            scheduleClass(9, 0,10, 0,"Game Frameworks", "www.google.com"),
            scheduleClass(10, 0,11, 0,"Cooperative Learning", "www.google.com"),
            scheduleClass(11, 0,12, 0,"Management of Game and Apps Projects", "www.google.com"),
            scheduleClass(12, 0,13, 0, "Mobile Programming", "www.google.com"),
            scheduleClass(13, 0,14, 0, "Math, Physics and Games II", "www.google.com")
        ),
        "Wednesday" to mutableListOf(
            scheduleClass(9, 0,10, 0,"Cooperative Learning", "www.google.com"),
            scheduleClass(10, 0,13, 0, "Multiplatform Project", "www.google.com")
        ),
        "Thursday" to mutableListOf(
            scheduleClass(9, 0,12,  0,"Mobile Programming", "www.google.com"),
        ),
        "Friday" to mutableListOf(
            scheduleClass(8, 0,10, 0, "Management of Game and Apps Projects", "www.google.com")
        )
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