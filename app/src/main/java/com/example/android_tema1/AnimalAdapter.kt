package com.example.android_tema1

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.android_tema1.Animal

class AnimalAdapter(private val animals: List<Animal>, private val fragment: Fragment) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.animalNameTextView)
        val continentTextView: TextView = itemView.findViewById(R.id.animalContinentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return AnimalViewHolder(view)
    }

    private fun getLayoutResourceForContinent(continent: String): Int {
        return when (continent) {
            "Europe" -> R.layout.europe_animal
            "Africa" -> R.layout.africa_animal
            "Asia" -> R.layout.asia_animal
            "North America" -> R.layout.north_america_animal
            "South America" -> R.layout.south_america_animal
            "Australia" -> R.layout.australia_animal
            "Antarctica" -> R.layout.antarctica_animal
            else -> R.layout.animal_item
        }
    }
    override fun getItemViewType(position: Int): Int {
        return getLayoutResourceForContinent(animals[position].continent)
    }
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]
        holder.nameTextView.text = animal.name
        holder.continentTextView.text = animal.continent
        val textColor = when (animal.continent) {
            "Africa" -> ContextCompat.getColor(holder.itemView.context, R.color.black)
            "Asia" -> ContextCompat.getColor(holder.itemView.context, R.color.white)
            "Australia" -> ContextCompat.getColor(holder.itemView.context, R.color.white)
            "Europe" -> ContextCompat.getColor(holder.itemView.context, R.color.white)
            "North America" -> ContextCompat.getColor(holder.itemView.context, R.color.white)
            "South America" -> ContextCompat.getColor(holder.itemView.context, R.color.black)
            "Antarctica" -> ContextCompat.getColor(holder.itemView.context, R.color.white)
            else -> ContextCompat.getColor(holder.itemView.context, R.color.black)
        }

        holder.nameTextView.setTextColor(textColor)
        holder.continentTextView.setTextColor(textColor)
        holder.itemView.setOnClickListener {
            val detailsFragment = AnimalDetailsFragment.newInstance(animal.name, animal.continent, textColor)
            fragment.parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, detailsFragment)
                .addToBackStack(null)
                .commit()
        }
    }
    override fun getItemCount() = animals.size
}
