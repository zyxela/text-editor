package com.example.laba1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val screenView = findViewById<View>(R.id.background)

        val txtView = findViewById<TextView>(R.id.owrText)
        viewModel.textSize.observe(this) {
            txtView.apply {
                textSize = viewModel.textSize.value!!
            }
        }

        viewModel.screenColor.observe(this){
                if (viewModel.screenColor.value != null){
                    screenView.setBackgroundColor(viewModel.screenColor.value!!)
                }

        }

        val changeScreenColor = findViewById<Button>(R.id.change_screen_color)

        val inputDialog = InputDialog(viewModel)
        val colorDialog = PaletteDialog(viewModel)
        changeScreenColor.setOnClickListener {
            colorDialog.show(supportFragmentManager,"paletteDialog")
        }

        findViewById<Button>(R.id.change_text_size).setOnClickListener {
            inputDialog.show(supportFragmentManager, "inputDialog")
        }

    }

}