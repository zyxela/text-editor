package com.example.laba1.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laba1.R
import com.example.laba1.RvAdapter
import com.example.laba1.view.MainViewModel

class FontDialog(val viewModel: MainViewModel, val list: List<String>):DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.font_dialog, container, false)
        val rc = v.findViewById<RecyclerView>(R.id.rv)
        rc.layoutManager = LinearLayoutManager(v.context)
        rc.adapter = RvAdapter(viewModel, list)
        return v
    }
}