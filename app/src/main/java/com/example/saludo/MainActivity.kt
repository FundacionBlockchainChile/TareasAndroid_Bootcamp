package com.example.saludo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import androidx.viewpager2.widget.ViewPager2
// import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Cargar la preferencia guardada antes de aplicar el tema
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)

        // Aplicar el tema correcto antes de cargar la vista
        if (isDarkMode) {
            setTheme(R.style.Theme_Saludo2)
        } else {
            setTheme(R.style.Theme_Saludo1)
        }

        // Continúa con la creación de la actividad
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val layouts = listOf(
            R.layout.carousel_item_1,
            R.layout.carousel_item_2,
            R.layout.carousel_item_3
        )
        viewPager.adapter = CarouselAdapter(layouts)

        // // Configurar el botón para abrir el selector de fecha
        // val openDatePickerButton: Button = findViewById(R.id.openDatePickerButton)
        // openDatePickerButton.setOnClickListener {
        //     val datePicker = MaterialDatePicker.Builder.datePicker()
        //         .setTitleText("Seleccionar Fecha")
        //         .build()

        //     datePicker.show(supportFragmentManager, "datePicker")
        // }
    }
}
