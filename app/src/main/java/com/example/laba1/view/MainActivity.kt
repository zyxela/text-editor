package com.example.laba1.view

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.laba1.R
import com.example.laba1.dialogs.FontDialog
import com.example.laba1.dialogs.InputDialog
import com.example.laba1.dialogs.PaletteDialog
import com.example.laba1.dialogs.StyleDialog

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

        viewModel.screenColor.observe(this) {
            if (viewModel.screenColor.value != null) {
                screenView.setBackgroundColor(viewModel.screenColor.value!!)
            }

        }

        viewModel.isBold.observe(this) {
            if (it && viewModel.isItalics.value == true)
                txtView.setTypeface(null, Typeface.BOLD_ITALIC)
            else if (!it && viewModel.isItalics.value == true)
                txtView.setTypeface(null, Typeface.ITALIC)
            else if (it)
                txtView.setTypeface(null, Typeface.BOLD)
            else
                txtView.setTypeface(null, Typeface.NORMAL)
        }
        viewModel.isItalics.observe(this) {
            if (it && viewModel.isBold.value == true)
                txtView.setTypeface(null, Typeface.BOLD_ITALIC)
            else if (!it && viewModel.isBold.value == true)
                txtView.setTypeface(null, Typeface.BOLD)
            else if (it)
                txtView.setTypeface(null, Typeface.ITALIC)
            else
                txtView.setTypeface(null, Typeface.NORMAL)
        }
        viewModel.font.observe(this) {
            txtView.typeface = Typeface.createFromAsset(assets, "font/${it}")
        }


        val changeScreenColor = findViewById<Button>(R.id.change_screen_color)
        val changeStyle = findViewById<Button>(R.id.change_text_style)
        val changeFont = findViewById<Button>(R.id.change_font)


        val inputDialog = InputDialog(viewModel)
        val colorDialog = PaletteDialog(viewModel)
        val styleDialog = StyleDialog(viewModel)
        val fontDialog = FontDialog(viewModel, listOf("anika.ttf", "cisnero.otf", "roasted.otf"))


        changeScreenColor.setOnClickListener {
            colorDialog.show(supportFragmentManager, "paletteDialog")
        }

        findViewById<Button>(R.id.change_text_size).setOnClickListener {
            inputDialog.show(supportFragmentManager, "inputDialog")
        }

        changeStyle.setOnClickListener {
            styleDialog.show(supportFragmentManager, "styleDialog")
        }

        changeFont.setOnClickListener {
            fontDialog.show(supportFragmentManager, "fontDialog")
        }
    }

}