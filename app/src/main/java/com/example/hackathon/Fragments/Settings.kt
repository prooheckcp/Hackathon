package com.example.hackathon.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import com.example.hackathon.Activities.HomePage
import com.example.hackathon.Objects.SettingsObject
import com.example.hackathon.R
import kotlinx.android.synthetic.main.fragment_settings.*

class Settings : Fragment(R.layout.fragment_settings) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onResume() {
        super.onResume()

        wipeDataButton.setOnClickListener{
            (activity as HomePage).wipeData()
        }

        switch1.isChecked = SettingsObject.isHollidays

        switch1.setOnCheckedChangeListener {buttonView, isChecked ->
            SettingsObject.isHollidays = isChecked


        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}