package com.iacc.manuelroa_20240921.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iacc.manuelroa_20240921.R

class HomeViewModel : ViewModel() {


    private val _conductores = MutableLiveData<List<Conductor>>().apply {
        value = listOf(
            Conductor("Juan Pérez", 34, R.drawable.conductor1),
            Conductor("María Gómez", 45, R.drawable.conductor1),
            Conductor("Carlos Sánchez", 27, R.drawable.conductor1),
            Conductor("Laura Morales", 50, R.drawable.conductor1),
            Conductor("Pedro Fernández", 12, R.drawable.conductor1),
            Conductor("Ana Rodríguez", 40, R.drawable.conductor1)
        )
    }
    val conductores: LiveData<List<Conductor>> = _conductores
}
