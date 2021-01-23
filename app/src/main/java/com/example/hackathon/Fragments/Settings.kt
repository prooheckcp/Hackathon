package com.example.hackathon.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import com.example.hackathon.Objects.SettingsObject
import com.example.hackathon.R
import kotlinx.android.synthetic.main.fragment_settings.*

class Settings : Fragment(R.layout.fragment_settings) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   println("work")
        //  checkboxMemory = view?.findViewById(R.id.checkB
        //   println(checkBox)
        // println(switch2)
    }

    /*     println("work")
       //  checkboxMemory = view?.findViewById(R.id.checkBox);
      print(checkBox)
         checkboxMemory = checkBox
         //println(checkboxMemory == null)
        // checkboxMemory.
     }*/

    override fun onResume() {
        super.onResume()
        switch1.isChecked = SettingsObject.isHollidays

        switch1.setOnCheckedChangeListener {buttonView, isChecked ->
            SettingsObject.isHollidays = isChecked


        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // checkboxMemory?.isChecked = true;
        //   checkboxMemory = checkBox
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}