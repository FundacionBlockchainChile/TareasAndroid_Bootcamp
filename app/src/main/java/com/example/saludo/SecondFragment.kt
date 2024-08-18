package com.example.saludo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController

class SecondFragment : Fragment() {

    val args:SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.name
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val btnEnviar = view.findViewById<Button>(R.id.btnEnviar)
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)

        tvName.text = "Hola, $name"

        btnEnviar.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedId)

            if (radioButton.text == "Pertenece a Whatsapp") {
                findNavController().navigate(
                    SecondFragmentDirections.actionSecondFragmentToThirdFragment(name)
                )
            } else {
                findNavController().navigate(
                    SecondFragmentDirections.actionSecondFragmentToFourthFragment(name)
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}