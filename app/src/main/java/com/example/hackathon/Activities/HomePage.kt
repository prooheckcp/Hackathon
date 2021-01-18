package com.example.hackathon.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hackathon.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    //Respond to the main homepage
                    true
                }
                R.id.page_2 -> {
                    // Respond to the notes tab
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