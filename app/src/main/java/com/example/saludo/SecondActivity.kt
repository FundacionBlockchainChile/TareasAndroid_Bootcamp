package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val selectedImage: ImageView = findViewById(R.id.selectedImage)
        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)

        val imageResId = intent.getIntExtra("imageResId", 0)
        selectedImage.setImageResource(imageResId)

        buttonGoBack.setOnClickListener {
            finish()
        }
    }
}