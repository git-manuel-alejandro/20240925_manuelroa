package com.iacc.manuelroa_20240921.ui.animacion
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnimacionViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "soy una animación"
    }
    val text: LiveData<String> = _text
}