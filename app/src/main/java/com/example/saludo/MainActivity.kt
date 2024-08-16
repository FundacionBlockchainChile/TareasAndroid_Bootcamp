package com.example.saludo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.saludo.SecondActivity
import com.example.saludo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate called")

        val buttonGoToSecondActivity: Button = findViewById(R.id.buttonGoToSecondActivity)
        val buttonCloseApp: Button = findViewById(R.id.buttonCloseApp)

        // Configurar botón para abrir la segunda actividad
        buttonGoToSecondActivity.setOnClickListener {
            Log.d("MainActivity", "Navigating to SecondActivity")
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Configurar botón para cerrar la aplicación
        buttonCloseApp.setOnClickListener {
            Log.d("MainActivity", "Closing the app")
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called")
    }
}
