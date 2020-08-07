package com.facundomr.tgik.sealedclasses.planets.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.facundomr.tgik.sealedclasses.planets.data.PlanetsRepository
import com.facundomr.tgik.sealedclasses.planets.model.Planet

class PlanetsViewModel : ViewModel() {
    val state = liveData {
        emit(State.Loading)
        emit(State.Success(PlanetsRepository.getAll()))
    }
}

sealed class State {
    object Loading : State()
    class Success(val planets: List<Planet>) : State()
}
