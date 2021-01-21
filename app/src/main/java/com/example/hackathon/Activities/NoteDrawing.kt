package com.example.hackathon.Activities

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon.Fragments.dummy.DummyContent
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_note_drawing.*


class NoteDrawing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_drawing)

        //Setup the window name
        noteName.text = DataHandler.currentNote?.name

        //Save the note||

            accept.setOnClickListener {
                saveNote()
                DataHandler.lastwindow = 1
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            }
        //_____________||

        //Redraw the canvas||

            redraw.setOnClickListener {
                drawingCanvas.canvasReset()
            }
        //_________________||

        //Delete the notes||

            trashcan.setOnClickListener {

                MaterialAlertDialogBuilder(this)
                        .setTitle("Delete note")
                        .setMessage("Do you wish to delete this note?")
                        .setPositiveButton("Delete"){_,_->


                            //Delete the note and move to the main screen||
                                DummyContent.ITEMS.removeAt(DataHandler.currentNote!!.id)
                                DataHandler.lastwindow = 1
                                val intent = Intent(this, HomePage::class.java)
                                startActivity(intent)
                            //___________________________________________||

                            //Fix the IDs||

                                var i : Int = 0
                                for (item in DummyContent.ITEMS){
                                    item.id = i
                                    i++
                                }
                            //___________||
                        }
                        .setNegativeButton("Cancel"){_,_->}
                        .show()
            }
        //________________||

        //Load the correct canvas if there is one to be loaded
        drawingCanvas.setCorrectBitmap()

    }



    fun saveNote(){
        val bitmapToSave : Bitmap = drawingCanvas.getbitmap()
        println(DataHandler.currentNote!!.id )
        DummyContent.ITEMS[DataHandler.currentNote!!.id ].hashMap = bitmapToSave

    }

}