package com.example.hackathon.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.hackathon.Fragments.HomeScreen
import com.example.hackathon.Fragments.Notes
import com.example.hackathon.Fragments.Settings
import com.example.hackathon.Fragments.dummy.DummyContent
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //Check on which fragment should the app start
        when(DataHandler.lastwindow){
            0->{fragmentManager(HomeScreen())}
            1->{fragmentManager(Notes())}
        }

        //Add the listener for the navigation bar
        bottom_nav_bar.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.page_1 ->{
                    fragmentManager(HomeScreen())
                }
                R.id.page_2 ->{
                    fragmentManager(Notes())
                }

                R.id.page_3 ->{
                    fragmentManager(Settings())
                }
            }
            true
        }

    }

    private fun fragmentManager(fragment: Fragment):Unit{
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment_content, fragment)
            commit()
        }
    }

    fun moveToDrawingRoom(){
        val intent = Intent(this, NoteDrawing::class.java)
        startActivity(intent)
    }


    fun createNewNote(){

        val input = EditText(this)
        input.hint = "Insert note name"
        input.setTextColor(Color.BLACK);
        input.textSize = 16f

        //Create the dialog box for the note||
        var newNoteBox = MaterialAlertDialogBuilder(this)
        newNoteBox.setTitle("New note")
        newNoteBox.setView(input)
        newNoteBox.setMessage("Do you wish to create a new node?")
        newNoteBox.setPositiveButton("Create"){dialog, which ->
            if(input.text.isNotEmpty() && input.text.length < 12){
                DummyContent.ITEMS.add(DummyContent.NoteItem(DummyContent.ITEMS.count() + 1,input.text.toString(), null))
                fragmentManager(Notes())
            }else if(input.text.isEmpty()){
                notification("Note name cannot be empty")
            }else{
                notification("The name is too long")
            }
        }
        newNoteBox.setNegativeButton("Cancel"){_,_->}
        //__________________________________||
        newNoteBox.show()
    }

    //Handle box notifications
    fun notification(message : String){
        MaterialAlertDialogBuilder(this)
            .setTitle(message)
            .setItems(arrayOf("ok")){_,_->}
            .show()
    }

}