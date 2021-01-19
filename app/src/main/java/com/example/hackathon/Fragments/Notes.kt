package com.example.hackathon.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon.Activities.HomePage
import com.example.hackathon.Adapters.NotesRecyclerAdapter
import com.example.hackathon.Fragments.dummy.DummyContent
import com.example.hackathon.R
import kotlinx.android.synthetic.main.fragment_notes_list.*

/**
 * A fragment representing a list of Items.
 */
class Notes: Fragment(R.layout.fragment_home_screen) {

    lateinit var adapter: NotesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Inflate on the adapter||

            adapter = NotesRecyclerAdapter(DummyContent.ITEMS)
            notesList.adapter = adapter
            val layoutManager = LinearLayoutManager(HomePage())
            notesList.layoutManager = layoutManager
        //______________________||

        //Someone clicked on the create a new button
        noteCreateButton.setOnClickListener {
            (activity as HomePage).createNewNote()
        }

    }



}