package com.example.laba1.dialogs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.DialogFragment
import com.example.laba1.R
import com.example.laba1.view.MainViewModel

class StyleDialog(val viewModel: MainViewModel) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.style_dialog, container, false)
        view.findViewById<CheckBox>(R.id.is_bold).setOnClickListener {
            viewModel.isBold.value = view.findViewById<CheckBox>(R.id.is_bold).isChecked
        }
        view.findViewById<CheckBox>(R.id.is_italics).setOnClickListener {
            viewModel.isItalics.value = view.findViewById<CheckBox>(R.id.is_italics).isChecked
        }

        return view
    }
}