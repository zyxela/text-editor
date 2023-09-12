package com.example.laba1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.skydoves.colorpickerview.listeners.ColorListener

class PaletteDialog (val viewModel: MainViewModel): DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.color_palette,container,false)
        val palette = view.findViewById<com.skydoves.colorpickerview.ColorPickerView>(R.id.colorPickerView)

        palette.setColorListener(ColorListener{ color, fromUser ->
           viewModel.screenColor.value = color
        })
        return view
    }
}