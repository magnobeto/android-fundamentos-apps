package com.example.avaliamais.ui.studentPlace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentPlaceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Área do estudante Fragment"
    }
    val text: LiveData<String> = _text
}