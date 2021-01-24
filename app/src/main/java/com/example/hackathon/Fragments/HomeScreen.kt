package com.example.hackathon.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hackathon.Activities.HomePage
import com.example.hackathon.Classes.scheduleClass
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.Objects.DataHandler.yourSchedule
import com.example.hackathon.Objects.Functions
import com.example.hackathon.Objects.SettingsObject.isHollidays
import com.example.hackathon.R
import kotlinx.android.synthetic.main.fragment_home_screen.*
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.hours
import kotlin.time.minutes

class HomeScreen: Fragment(R.layout.fragment_home_screen) {

    //Variables||
    var nextClassWeekday : String? = null
    var nextClassNumber : Int? = null
    //_________||


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)



    }

    @ExperimentalTime
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

            //Set the display card image
            nextClassBackground.setImageResource(R.drawable.classroom_background)

        }else if(isHollidays){

            //Change display to holidays mode
            className.text = "You are in holidays\nmode"
            classNameBackground.text = "You are in holidays\nmode"
            nextClassBackground.setImageResource(R.drawable.beach_background)
        }else{

            //Set the display card image
            nextClassBackground.setImageResource(R.drawable.classroom_background)

            //Calculate the next class
            val currentCalendar : Calendar = Calendar.getInstance()
            val currentDay = currentCalendar.get(Calendar.DAY_OF_WEEK)
            val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = currentCalendar.get(Calendar.MINUTE)


            fun setNextClassInfo(toDisplayObject :scheduleClass?){

                //Set the class name
                className.text = toDisplayObject?.className
                classNameBackground.text = toDisplayObject?.className

                //Set the class link
                nextClassLink.setOnClickListener{
                    val siteIntent = Intent("android.intent.action.VIEW",
                            Uri.parse("http://${toDisplayObject?.classLink}"));
                        startActivity(siteIntent);
                }

                //Set the class hours
                if(toDisplayObject != null){
                    classRommHourView.text = Functions.convertTimeFormat(toDisplayObject!!.startingHour, toDisplayObject!!.startingMinute, toDisplayObject!!.endingHour, toDisplayObject!!.endingMinute)

                    if(nextClassNumber == currentDay){

                        if(toDisplayObject.startingHour < currentHour || (toDisplayObject.startingHour == currentHour && toDisplayObject.startingMinute <= toDisplayObject.startingMinute)  ){
                            classStatus.text = "Class in progress"
                        }else{
                            classStatus.text = "Today in " + ((toDisplayObject.startingHour * 60 + toDisplayObject.startingMinute ) - (currentHour * 60 + currentMinute) ) + " minutes"
                        }
                    }else{
                        //The class is in the future
                        classStatus.text = "Scheduled for " + nextClassWeekday
                    }

                }else{
                    classRommHourView.text = "N/A"

                }

                //Set the class status

            }

            //Check if u have anymore classes today
            val hasFirstDayClass: scheduleClass? = checkIfClass(currentDay, currentHour, currentMinute)

            if(hasFirstDayClass != null){
                //Has a class today
                println("Has a class today")
                setNextClassInfo(hasFirstDayClass)
            }else{

                println("There is no class today")
                var hasFollowingClass: scheduleClass? = null
                //Sunday -> 1 /// Saturday -> 7
                for(i in currentDay+1..7){
                    if(hasFollowingClass == null){
                        hasFollowingClass = checkIfClass(i, 0, 0)
                    }
                }

                for(i in 1 until currentDay){
                    if(hasFollowingClass == null){
                        hasFollowingClass = checkIfClass(i, 0, 0)
                    }
                }

                setNextClassInfo(hasFollowingClass)

            }



        }
    }

    private fun checkIfClass(currentWeekDay: Int , currentHour : Int, currentMinute: Int) : scheduleClass? {

        var returnValue : scheduleClass? = null

        fun loopData(classesOfDay : MutableList<scheduleClass>){

            var earliestClass : scheduleClass? = null

            for(loopedClass in classesOfDay){
                if(loopedClass.endingHour > currentHour){
                    //Has valid format
                    if(earliestClass == null){

                        //If there is still no class to get set then put it as the earliest
                        earliestClass = loopedClass
                    }else if(earliestClass.endingHour > loopedClass.endingHour){
                        earliestClass = loopedClass
                    }

                }
            }

            returnValue = earliestClass

        }

        when(currentWeekDay){
            Calendar.MONDAY->{
                loopData(yourSchedule["Monday"]!!)
                nextClassWeekday = "Monday"
                nextClassNumber = Calendar.MONDAY
            }
            Calendar.TUESDAY->{
                loopData(yourSchedule["Tuesday"]!!)
                nextClassWeekday = "Tuesday"
                nextClassNumber = Calendar.TUESDAY
            }
            Calendar.WEDNESDAY->{
                loopData(yourSchedule["Wednesday"]!!)
                nextClassWeekday = "Wednesday"
                nextClassNumber = Calendar.WEDNESDAY
            }
            Calendar.THURSDAY->{
                loopData(yourSchedule["Thursday"]!!)
                nextClassWeekday = "Thursday"
                nextClassNumber = Calendar.THURSDAY
            }
            Calendar.FRIDAY->{
                loopData(yourSchedule["Friday"]!!)
                nextClassWeekday = "Friday"
                nextClassNumber = Calendar.FRIDAY
            }
        }

        return returnValue
    }

}