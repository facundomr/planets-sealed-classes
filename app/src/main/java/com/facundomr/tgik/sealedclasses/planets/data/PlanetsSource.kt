package com.facundomr.tgik.sealedclasses.planets.data

import com.facundomr.tgik.sealedclasses.planets.R
import com.facundomr.tgik.sealedclasses.planets.model.Planet

fun getAllPlanets() = listOf<Planet>(
    Planet.BasicPlanet(name = "Mercury", id = 0, image = R.drawable.mercury),
    Planet.BasicPlanet(name = "Venus", id = 1, image = R.drawable.venus),
    Planet.PlanetWithSatellites(name = "Earth", id = 2, satellitesNames = listOf("Moon"), image = R.drawable.earth),
    Planet.PlanetWithSatellites(name = "Mars", id = 3, satellitesNames = listOf("Fobos", "Deimos"), image = R.drawable.mars),
    Planet.PlanetWithSatellites(name = "Jupiter", id = 4, satellitesNames = listOf("Metis", "Adrastea", "Amaltea", "76 more..."), image = R.drawable.jupiter),
    Planet.PlanetWithSatellites(name = "Saturn", id = 5, satellitesNames = listOf("Mimas", "Tetis", "Dione", "and more..."), image = R.drawable.saturn),
    Planet.PlanetWithSatellites(name = "Uranus", id = 6, satellitesNames = listOf("Cordelia", "Ofelia", "Bianca", "and more..."), image = R.drawable.uranus),
    Planet.PlanetWithSatellites(name = "Neptune", id = 7, satellitesNames = listOf("Náyade", "Talasa", "Despina", "Galatea", "and more..."), image = R.drawable.neptune)
)
