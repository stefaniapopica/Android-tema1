package com.example.android_tema1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class AnimalDetailsFragment : Fragment() {
    companion object {
        private const val ARG_NAME = "name"
        private const val ARG_CONTINENT = "continent"
        private const val ARG_COLOR = "color"

        fun newInstance(name: String, continent: String, color: Int): AnimalDetailsFragment {
            val fragment = AnimalDetailsFragment()
            val args = Bundle().apply {
                putString(ARG_NAME, name)
                putString(ARG_CONTINENT, continent)
                putInt(ARG_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animal_details, container, false)
        val name = arguments?.getString(ARG_NAME) ?: ""
        val continent = arguments?.getString(ARG_CONTINENT) ?: ""
        val color = arguments?.getInt(ARG_COLOR, Color.BLACK)

        val textView: TextView = view.findViewById(R.id.animalDetailsTextView)
        textView.text = "$name\n$continent"
        color?.let {
            textView.setTextColor(it)
        }

        val background = when (continent) {
            "Africa" -> R.color.yellow
            "Asia" -> R.color.red
            "Australia" -> R.color.purple
            "Europe" -> R.color.green
            "North America" -> R.color.brown
            "South America" -> R.color.orange
            "Antarctica" -> R.color.blue
            else -> R.color.white
        }
        view.setBackgroundResource(background)

        return view
    }

}
