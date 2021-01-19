package com.example.hackathon.Fragments.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = arrayListOf(
        DummyItem("a", "uwu", "yes"),
        DummyItem("b", "owo", "no"),
        DummyItem("c", "zfz", "yes"),
        DummyItem("d", "pop", "no"),
        DummyItem("e", "juj", "yes"),
        DummyItem("e", "juj", "yes"),
        DummyItem("e", "juj", "yes")
    )



    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}