package com.example.hackathon.Fragments.dummy

import android.graphics.Bitmap
import java.util.*

object DummyContent {

    //Class that holds the information for each note
    data class NoteItem(var id : Int,var name: String, var hashMap: Bitmap?){
        var currentTime: Date = Calendar.getInstance().time
    }
    val ITEMS: MutableList<NoteItem> = arrayListOf(
        NoteItem(1,"Some note", null),
        NoteItem(2,"Another Note", null)
    )



}