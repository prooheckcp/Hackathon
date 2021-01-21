package com.example.hackathon.Objects

import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.Fragments.dummy.DummyContent

object DataHandler {

    var schedule : MutableList<scheduleClass> = mutableListOf<scheduleClass>()
    var currentNote: DummyContent.NoteItem? = null
    var lastwindow : Int = 0

}