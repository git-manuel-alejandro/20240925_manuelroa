package com.iacc.manuelroa_20240921.ui.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VideoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Soy un video !!"
    }
    val text: LiveData<String> = _text
}