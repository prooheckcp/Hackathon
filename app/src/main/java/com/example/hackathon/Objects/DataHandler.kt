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
            scheduleClass(8,11, "Game Frameworks", "www.google.com"),
            scheduleClass(11,14, "Math, Physics and Games II", "www.google.com")
        ),
        "Tuesday" to mutableListOf(
            scheduleClass(9,10, "Game Frameworks", "www.google.com"),
            scheduleClass(10,11, "Cooperative Learning", "www.google.com"),
            scheduleClass(11,12, "Management of Game and Apps Projects", "www.google.com"),
            scheduleClass(12,13, "Mobile Programming", "www.google.com"),
            scheduleClass(13,14, "Math, Physics and Games II", "www.google.com")
        ),
        "Wednesday" to mutableListOf(
            scheduleClass(9,10, "Cooperative Learning", "www.google.com"),
            scheduleClass(10,13, "Multiplatform Project", "www.google.com")
        ),
        "Thursday" to mutableListOf(
            scheduleClass(9,12, "Mobile Programming", "www.google.com"),
        ),
        "Friday" to mutableListOf(
            scheduleClass(8,10, "Management of Game and Apps Projects", "www.google.com")
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