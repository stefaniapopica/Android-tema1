package com.example.android_tema1

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_tema1.Animal

class AnimalListFragment : Fragment() {
    private val animals = listOf(
        Animal("Eagle", "Europe"),
        Animal("Elephant", "Africa"),
        Animal("Panda", "Asia"),
        Animal("Coyote", "North America"),
        Animal("Anaconda", "South America"),
        Animal("Dingo", "Australia"),
        Animal("Seal", "Antarctica"),
        Animal("Lion", "Africa"),
        Animal("Eagle", "Africa"),
        Animal("Orangutan", "Asia"),
        Animal("Indian Elephant", "Asia"),
        Animal("Snow Leopard", "Asia"),
        Animal("Kangaroo", "Australia"),
        Animal("Koala", "Australia"),
        Animal("Emu", "Australia"),
        Animal("Wallaby", "Australia"),
        Animal("Giraffe", "Africa"),
        Animal("Brown Bear", "Europe"),
        Animal("Wolf", "Europe"),
        Animal("Reindeer", "Europe"),
        Animal("Tiger", "Asia"),
        Animal("Squirrel", "Europe"),
        Animal("Bison", "North America"),
        Animal("Hippopotamus", "Africa"),
        Animal("Badger", "North America"),
        Animal("Mountain Lion", "North America"),
        Animal("Vulture", "North America"),
        Animal("Llama", "South America"),
        Animal("Jaguar", "South America"),
        Animal("Tapir", "South America"),
        Animal("Parrot", "South America"),
        Animal("Penguin", "Antarctica"),
        Animal("Elephant Seal", "Antarctica"),
        Animal("Albatross", "Antarctica"),
        Animal("Snow Storm", "Antarctica"),
        Animal("Polar Bear", "Antarctica"),
        Animal("Panda", "Asia"),
        Animal("Indian Elephant", "Asia"),
        Animal("Tiger", "Asia"),
        Animal("Orangutan", "Asia"),
        Animal("Snow Leopard", "Asia"),
        Animal("Elephant", "Africa"),
        Animal("Lion", "Africa"),
        Animal("Giraffe", "Africa"),
        Animal("Hippopotamus", "Africa"),
        Animal("Vulture", "Africa"),
        Animal("Rhino", "Africa"),
        Animal("Chimpanzee", "Africa"),
        Animal("Ostrich", "Africa"),
        Animal("Cheetah", "Africa")
    )

    class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
        ) {
            outRect.bottom = space
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animal_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.animalsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(SpacesItemDecoration(32))

        val adapter = AnimalAdapter(animals, this)
        recyclerView.adapter = adapter

        return view
    }
}
