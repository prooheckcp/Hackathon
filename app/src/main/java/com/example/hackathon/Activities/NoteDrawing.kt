package com.example.hackathon.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import kotlinx.android.synthetic.main.activity_note_drawing.*

class NoteDrawing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_drawing)
        
        noteName.text = DataHandler.currentNote?.name
    }
}