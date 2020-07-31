package com.sunnyweather.fsystem.activity.ui.mystudy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home MyStudy"
    }
    val text: LiveData<String> = _text
}