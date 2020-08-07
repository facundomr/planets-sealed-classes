package com.facundomr.tgik.sealedclasses.planets.model

import androidx.annotation.DrawableRes
import java.io.Serializable

sealed class Planet(val id: Int, val name: String, @DrawableRes val image: Int): Serializable {
    class BasicPlanet(id: Int, name: String, @DrawableRes image: Int) : Planet(id, name, image)
    class PlanetWithSatellites(id: Int, name: String, val satellitesNames: List<String>, @DrawableRes image: Int) : Planet(id, name, image)
}
