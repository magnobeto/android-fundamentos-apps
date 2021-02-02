package com.example.avaliamais.ui.aboutUs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutUsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Quem Somos Fragment"
    }
    val text: LiveData<String> = _text
}