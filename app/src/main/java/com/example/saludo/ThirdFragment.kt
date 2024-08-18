package com.example.saludo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController


class ThirdFragment : Fragment() {

    val args: ThirdFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        tvName.text = "¡Genial ${args.name}, ganaste!"

        val btnRestart = view.findViewById<Button>(R.id.btnRestart)
        btnRestart.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }
}