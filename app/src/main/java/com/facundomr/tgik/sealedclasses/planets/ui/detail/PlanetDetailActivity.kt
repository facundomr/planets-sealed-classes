package com.facundomr.tgik.sealedclasses.planets.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.isVisible
import com.facundomr.tgik.sealedclasses.planets.R
import com.facundomr.tgik.sealedclasses.planets.data.PlanetsRepository
import com.facundomr.tgik.sealedclasses.planets.model.Planet
import com.facundomr.tgik.sealedclasses.planets.util.exhaustive
import kotlinx.android.synthetic.main.activity_planet_detail.*

class PlanetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)

        val params = intent.getSerializableExtra(EXTRA_PARAMS) as PlanetDetailParams

        val receivedPlanet = when (params) {
            is PlanetDetailParams.PlanetEntityParam -> params.planet
            is PlanetDetailParams.PlanetIdParam -> PlanetsRepository.getById(params.id)
        }

        show(receivedPlanet)
    }

    private fun show(planet: Planet) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        name.text = planet.name
        description.text = "This is the Planet id ${planet.id}"

        when (planet) {
            is Planet.BasicPlanet -> satellitesGroup.isVisible = false
            is Planet.PlanetWithSatellites -> {
                satellitesGroup.isVisible = true
                satellites.text = planet.satellitesNames.joinToString(", ")
            }
        }.exhaustive
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_PARAMS = "EXTRA_PLANET_DETAIL_PARAMS"

        fun start(context: Context, params: PlanetDetailParams) {
            val intent = Intent(context, PlanetDetailActivity::class.java)
            intent.putExtra(EXTRA_PARAMS, params)
            context.startActivity(intent)
        }
    }
}
