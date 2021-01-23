package com.example.hackathon.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import com.example.hackathon.R
import kotlinx.android.synthetic.main.fragment_settings.*

class Settings : Fragment(R.layout.fragment_settings) {
    var isHolliday : Boolean = false;
    var checkboxMemory : CheckBox? = checkBox;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("work")
        //  checkboxMemory = view?.findViewById(R.id.checkB
        print(checkBox)
        checkboxMemory = checkBox



    }

   /*     println("work")
      //  checkboxMemory = view?.findViewById(R.id.checkBox);
     print(checkBox)
        checkboxMemory = checkBox
        //println(checkboxMemory == null)
       // checkboxMemory.
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // checkboxMemory?.isChecked = true;
     //   checkboxMemory = checkBox


        println(checkboxMemory == null)

        checkboxMemory?.isChecked = true;
        fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked
                when (view.id) {
                    R.id.checkBox -> {
                        if (checked) {
                            isHolliday = true;
                        } else {
                            isHolliday = true;
                        }
                    }
                }

            }
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}