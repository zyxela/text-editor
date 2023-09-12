package com.example.laba1

import android.graphics.Color
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){

    val textSize: MutableLiveData<Float> = MutableLiveData()
    val screenColor: MutableLiveData<Int> = MutableLiveData()


}