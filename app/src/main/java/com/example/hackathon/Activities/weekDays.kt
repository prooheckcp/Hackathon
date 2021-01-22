package com.example.hackathon.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon.Objects.DataHandler
import com.example.hackathon.R
import kotlinx.android.synthetic.main.activity_week_days.*

class weekDays : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week_days)
    }

    override fun onResume() {
        super.onResume()

        goBackButton.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            DataHandler.lastwindow = 0
            startActivity(intent)
        }
    }

}