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

        // Conectar los elementos de la UI
        val inputName: EditText = findViewById(R.id.inputName)
        val inputLastName: EditText = findViewById(R.id.inputLastName)
        val inputEmail: EditText = findViewById(R.id.inputEmail)
        val inputPassword: EditText = findViewById(R.id.inputPassword)
        val buttonCreateAccount: Button = findViewById(R.id.buttonCreateAccount)

        // Asignar la funcionalidad al botón
        buttonCreateAccount.setOnClickListener {
            val name = inputName.text.toString()
            val lastName = inputLastName.text.toString()
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (name.isNotBlank() && lastName.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
                val message = "Hola $name $lastName, tu correo es $email."
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
