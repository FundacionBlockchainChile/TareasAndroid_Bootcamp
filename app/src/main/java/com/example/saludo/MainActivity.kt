package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar los elementos de la interfaz
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val signUpButton: Button = findViewById(R.id.signUpButton)

        // Agregar la funcionalidad al botón
        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()

            Toast.makeText(this, "Welcome, $name!", Toast.LENGTH_LONG).show()
        }
    }
}
