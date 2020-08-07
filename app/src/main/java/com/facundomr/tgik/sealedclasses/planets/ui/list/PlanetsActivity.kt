package com.facundomr.tgik.sealedclasses.planets.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.facundomr.tgik.sealedclasses.planets.R
import com.facundomr.tgik.sealedclasses.planets.util.exhaustive
import kotlinx.android.synthetic.main.activity_planets.*

class PlanetsActivity : AppCompatActivity(R.layout.activity_planets) {

    private val adapter = PlanetListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView.adapter = adapter

        val viewModel: PlanetsViewModel by viewModels()
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                State.Loading -> progress.isVisible = true
                is State.Success -> {
                    progress.isVisible = false
                    adapter.planets = state.planets
                }
            }.exhaustive
        })
    }
}
