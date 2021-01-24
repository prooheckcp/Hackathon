package com.example.hackathon.Objects

object Functions {

    fun convertTimeFormat(startingHour : Int, startingMinute : Int, endingHour : Int, endingMinute : Int) : String {

        var result : String = ""

        //Calculate the string||

        //Set the starting hour
        if(startingHour < 10){
            result += "0" + startingHour.toString() + ":"
        }else{
            result = startingHour.toString() + ":"
        }

        //Set the starting minute
        if(startingMinute < 10){
            result += "0" + startingMinute.toString()
        }else{
            result += startingMinute.toString()
        }

        if(startingHour >= 12){
            result += "PM-"
        }else{
            result += "AM-"
        }

        //Set the ending hour
        if(endingHour < 10){
            result += "0" + endingHour.toString() + ":"
        }else{
            result += endingHour.toString() + ":"
        }

        //Set the ending minute
        if(endingMinute < 10){
            result += "0" + endingMinute.toString()
        }else{
            result += endingMinute.toString()
        }

        if(endingHour >= 12){
            result += "PM"
        }else{
            result += "AM"
        }
        //____________________||

        return result

    }

}