package com.example.saludo

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class BulbasaurFragment : Fragment() {
    private var isDefaultBackground = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bulbasaur, container, false)

        val buttonChangeBackground: Button = view.findViewById(R.id.button_change_background)
        buttonChangeBackground.setOnClickListener {
            if (isDefaultBackground) {
                view.setBackgroundColor(Color.GREEN)
            } else {
                view.setBackgroundColor(Color.WHITE)
            }
            isDefaultBackground = !isDefaultBackground
        }

        return view
    }
}