package com.example.hackathon.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hackathon.Fragments.HomeScreen
import com.example.hackathon.Fragments.Notes
import com.example.hackathon.Fragments.Settings
import com.example.hackathon.R
import com.google.android.material.bottomnavigation.BottomNavigationView
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



}