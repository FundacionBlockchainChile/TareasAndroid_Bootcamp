package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Conectar los elementos de la UI
        val inputName: EditText = findViewById(R.id.inputName)
        val buttonGreet: Button = findViewById(R.id.buttonGreet)
        val textGreeting: TextView = findViewById(R.id.textGreeting)

        // Asignar la funcionalidad al botón
        buttonGreet.setOnClickListener {
            val name = inputName.text.toString()
            if (name.isNotBlank()) {
                textGreeting.text = "Hola $name"
                textGreeting.visibility = TextView.VISIBLE
            }
        }
    }
}
