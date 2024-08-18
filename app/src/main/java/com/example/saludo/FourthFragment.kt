package com.example.saludo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FourthFragment : Fragment() {
    val args: FourthFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        tvName.text = "Te equivocaste, ${args.name}. Inténtalo nuevamente."

        val btnTryAgain = view.findViewById<Button>(R.id.btnTryAgain)
        btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.action_fourthFragment_to_firstFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }
}