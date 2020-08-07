package com.facundomr.tgik.sealedclasses.planets.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object PlanetsRepository {

    suspend fun getAll() = withContext(Dispatchers.IO) {
        delay(3000)
        getAllPlanets()
    }

    fun getById(id: Int) = getAllPlanets()[id]

}
