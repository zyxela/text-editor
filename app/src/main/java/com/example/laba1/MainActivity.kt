package com.example.laba1

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val txtView = findViewById<TextView>(R.id.owrText)
        viewModel.text.observe(this){
            txtView.apply {
                textSize = it.size
                setTextColor(it.color)
                
            }
        }

        val changeScreenColor = findViewById<Button>(R.id.change_screen_color)
        val screenView = findViewById<View>(R.id.background)
        val inputDialog = InputDialog(viewModel)

        changeScreenColor.setOnClickListener {
            inputDialog.show(supportFragmentManager, "inputDialog")
        }

    }

}