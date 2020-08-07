package com.facundomr.tgik.sealedclasses.planets.ui.detail

import com.facundomr.tgik.sealedclasses.planets.model.Planet
import java.io.Serializable

sealed class PlanetDetailParams : Serializable {

    class PlanetEntityParam(val planet: Planet) : PlanetDetailParams()
    class PlanetIdParam(val id: Int) : PlanetDetailParams()

}
