package com.example.hackathon.Activities

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon.Fragments.dummy.DummyContent
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import kotlinx.android.synthetic.main.activity_note_drawing.*


class NoteDrawing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_drawing)

        //Setup the window name
        noteName.text = DataHandler.currentNote?.name

        accept.setOnClickListener {
            saveNote()
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        drawingCanvas.setCorrectBitmap()
    }

    fun saveNote(){
        val bitmapToSave :Bitmap = drawingCanvas.getbitmap()
        DummyContent.ITEMS.get(DataHandler.currentNote!!.id - 1).hashMap = bitmapToSave

        //DummyContent.ITEMS.get(DataHandler.currentNote!!.id).hashMap = drawingCanvas.getbitmap()
    }

}