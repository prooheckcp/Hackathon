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
import com.example.hackathon.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //Start in this notes
        fragmentManager(HomeScreen())

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

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    //Respond to the main homepage
                    println("He clicked on the schedule")
                    fragmentManager(HomeScreen())
                    true
                }
                R.id.page_2 -> {
                    // Respond to the notes tab
                    fragmentManager(Notes())
                    true
                }
                R.id.page_3 ->{
                    //Respond to settings tab

                    true
                }
                else -> false
            }
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
            if(input.text.isNotEmpty()){
                DummyContent.ITEMS.add(DummyContent.NoteItem(DummyContent.ITEMS.count() + 1,input.text.toString(), null))
                fragmentManager(Notes())
            }else{
                notification("Note name cannot be empty")
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