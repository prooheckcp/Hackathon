package com.example.hackathon.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hackathon.Activities.HomePage
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.Objects.SettingsObject
import com.example.hackathon.Objects.SettingsObject.isHollidays
import com.example.hackathon.R
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeScreen: Fragment(R.layout.fragment_home_screen) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)



    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()

        //Click event for the edit schedule button||
            editSchedule.setOnClickListener{
                (activity as HomePage).moveToWeekDays()
            }
        //________________________________________||


        var amountOfClasses : Int = 0

        //Count the amount of classes
        amountOfClasses += DataHandler.yourSchedule["Monday"]!!.size
        amountOfClasses += DataHandler.yourSchedule["Tuesday"]!!.size
        amountOfClasses += DataHandler.yourSchedule["Wednesday"]!!.size
        amountOfClasses += DataHandler.yourSchedule["Thursday"]!!.size
        amountOfClasses += DataHandler.yourSchedule["Friday"]!!.size

        if(amountOfClasses == 0){ //Check if he has any classes to be displayed

            className.text = "You have no\nfollowing classes"
            classNameBackground.text = "You have no\nfollowing classes"
        }else if(isHollidays){
            //Change display to holidays mode
            className.text = "You are in holidays\nmode"
            classNameBackground.text = "You are in holidays\nmode"
        }
    }
}