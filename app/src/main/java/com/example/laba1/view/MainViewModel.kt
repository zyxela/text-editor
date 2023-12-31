package com.example.laba1.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val textSize: MutableLiveData<Float> = MutableLiveData()
    val screenColor: MutableLiveData<Int> = MutableLiveData()
    val isBold = MutableLiveData<Boolean>()
    val isItalics = MutableLiveData<Boolean>()
    val font = MutableLiveData<String>()

}