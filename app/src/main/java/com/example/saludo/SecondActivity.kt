package com.example.saludo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.saludo.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("SecondActivity", "onCreate called")

        val buttonGoToWebsite: Button = findViewById(R.id.buttonGoToWebsite)
        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)

        // Configurar botón para abrir un sitio web
        buttonGoToWebsite.setOnClickListener {
            Log.d("SecondActivity", "Opening website")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kotlindoc.blogspot.com/2019/10/android-log-con-timber.html"))
            startActivity(intent)
        }

        // Configurar botón para regresar a la actividad principal
        buttonGoBack.setOnClickListener {
            Log.d("SecondActivity", "Returning to MainActivity")
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "onDestroy called")
    }
}
