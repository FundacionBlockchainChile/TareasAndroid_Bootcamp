package com.example.saludo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate

class SectionFragment : Fragment() {

    private lateinit var themeSwitcher: Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_section, container, false)

        // Conectar los elementos de la UI
        val inputName: EditText = view.findViewById(R.id.inputName)
        val buttonGreet: Button = view.findViewById(R.id.buttonGreet)
        val textGreeting: TextView = view.findViewById(R.id.textGreeting)
        themeSwitcher = view.findViewById(R.id.themeSwitcher)

        // Cargar preferencia guardada
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        themeSwitcher.isChecked = isDarkMode

        // Configurar el listener para cambiar el tema
        themeSwitcher.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("dark_mode", isChecked).apply()
            updateTheme(isChecked)
        }

        // Asignar la funcionalidad al botón de saludo
        buttonGreet.setOnClickListener {
            val name = inputName.text.toString()
            if (name.isNotBlank()) {
                textGreeting.text = "Hola $name"
                textGreeting.visibility = TextView.VISIBLE
            }
        }

        return view
    }

    private fun updateTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        // Reinicia la actividad para aplicar el nuevo tema
        requireActivity().recreate()
    }
}
