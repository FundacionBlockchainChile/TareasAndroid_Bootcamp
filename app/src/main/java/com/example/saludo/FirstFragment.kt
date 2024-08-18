package com.example.saludo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_first, container, false)

        val btnNavigate = root.findViewById<Button>(R.id.btnNavigate)
        val inputName = root.findViewById<EditText>(R.id.inputName)

        btnNavigate.setOnClickListener {
            val name = inputName.text.toString()
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(name)
            )
        }

        return root

    }
}