package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var clickCount = 0
    private lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Conectar los elementos de la UI
        val toastButton: Button = findViewById(R.id.buttonToast)
        val countButton: Button = findViewById(R.id.buttonCount)
        countTextView = findViewById(R.id.textViewCount)

        // Asignar la funcionalidad al botón de Toast
        toastButton.setOnClickListener {
            Toast.makeText(this, "Hello toast!", Toast.LENGTH_SHORT).show()
        }

        // Asignar la funcionalidad al botón de contador
        countButton.setOnClickListener {
            clickCount++
            countTextView.text = clickCount.toString()
        }
    }
}
