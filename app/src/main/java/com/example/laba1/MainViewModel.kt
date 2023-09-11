package com.example.laba1

import android.graphics.Color
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class MainViewModel: ViewModel(){

    val textSize: MutableLiveData<Float> = MutableLiveData()

    fun setScreenColor(view: View){
        view.setBackgroundColor(Color.RED)
    }
}