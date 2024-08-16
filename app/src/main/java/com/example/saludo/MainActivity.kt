package com.example.saludo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image1: ImageView = findViewById(R.id.image1)
        val image2: ImageView = findViewById(R.id.image2)
        val image3: ImageView = findViewById(R.id.image3)
        val image4: ImageView = findViewById(R.id.image4)
        val buttonCloseApp: Button = findViewById(R.id.buttonCloseApp)

        val imageClickListener = { imageResId: Int ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("imageResId", imageResId)
            startActivity(intent)
        }

        image1.setOnClickListener { imageClickListener(R.drawable.image1) }
        image2.setOnClickListener { imageClickListener(R.drawable.image2) }
        image3.setOnClickListener { imageClickListener(R.drawable.image3) }
        image4.setOnClickListener { imageClickListener(R.drawable.image4) }

        buttonCloseApp.setOnClickListener {
            finish()
        }
    }
}