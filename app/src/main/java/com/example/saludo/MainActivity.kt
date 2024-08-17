package com.example.saludo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Conectar los elementos de la UI
        val inputUrl: EditText = findViewById(R.id.inputUrl)
        val buttonOpen: Button = findViewById(R.id.buttonOpen)

        // Asignar la funcionalidad al botón
        buttonOpen.setOnClickListener {
            val url = inputUrl.text.toString()
            if (url.isNotBlank()) {
                val intent = Intent(this, WebViewActivity::class.java)
                intent.putExtra("URL", url)
                startActivity(intent)
            }
        }
    }
}