package com.facundomr.tgik.sealedclasses.planets.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facundomr.tgik.sealedclasses.planets.R
import com.facundomr.tgik.sealedclasses.planets.model.Planet
import com.facundomr.tgik.sealedclasses.planets.ui.detail.PlanetDetailActivity
import com.facundomr.tgik.sealedclasses.planets.ui.detail.PlanetDetailParams
import kotlinx.android.synthetic.main.item_planet.view.*

class PlanetListAdapter : RecyclerView.Adapter<PlanetViewHolder>() {

    var planets = emptyList<Planet>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PlanetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        )

    override fun getItemCount() = planets.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.render(planets[position])
    }
}

class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun render(planet: Planet) {
        itemView.name.text = planet.name
        itemView.image.setImageResource(planet.image)

        itemView.setOnClickListener {
            PlanetDetailActivity.start(it.context, PlanetDetailParams.PlanetEntityParam(planet))
        }
    }
}
