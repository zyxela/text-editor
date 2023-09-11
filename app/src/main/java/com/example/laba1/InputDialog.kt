package com.example.laba1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel

class InputDialog(val viewModel: MainViewModel) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_view, container, false)
        with(view) {
            findViewById<Button>(R.id.apply_number).setOnClickListener {
                val number = findViewById<TextView>(R.id.number).text.toString().toFloat()
                viewModel.text.value?.size = number
            }
        }
        return view
    }
}