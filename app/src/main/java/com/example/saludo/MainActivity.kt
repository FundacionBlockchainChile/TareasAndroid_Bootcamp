package com.example.saludo

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val fragment: Fragment = when (checkedId) {
                R.id.radio_button_pikachu -> PikachuFragment()
                R.id.radio_button_bulbasaur -> BulbasaurFragment()
                else -> PikachuFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}