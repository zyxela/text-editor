package com.example.laba1

import android.graphics.Color
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){

    val text: MutableLiveData<TextDesc> by lazy {
        MutableLiveData<TextDesc>()
    }

    fun setScreenColor(view: View){
        view.setBackgroundColor(Color.RED)
    }
}