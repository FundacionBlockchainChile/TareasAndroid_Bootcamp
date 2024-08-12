package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.saludo.R

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentNumber: String = ""
    private var operator: String? = null
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Cargando el layout XML

        // Conectando los botones y la pantalla de resultado
        resultTextView = findViewById(R.id.resultTextView)

        val buttonAC: Button = findViewById(R.id.buttonAC)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        val buttonDecimal: Button = findViewById(R.id.buttonDecimal)

        // Botón para cerrar la aplicación
        val buttonClose: Button = findViewById(R.id.buttonClose)
        buttonClose.setOnClickListener {
            finish()  // Cierra la actividad actual
            System.exit(0)  // Cierra la aplicación completamente
        }

        val buttons = listOf(
            findViewById<Button>(R.id.button0), findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2), findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4), findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6), findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8), findViewById<Button>(R.id.button9)
        )

        // Asignando listeners a los botones numéricos
        buttons.forEach { button ->
            button.setOnClickListener {
                currentNumber += button.text
                resultTextView.text = currentNumber
            }
        }

        // Asignando listeners a los botones de operaciones
        buttonAdd.setOnClickListener { setOperator("+") }
        buttonSubtract.setOnClickListener { setOperator("-") }
        buttonMultiply.setOnClickListener { setOperator("*") }
        buttonDivide.setOnClickListener { setOperator("/") }

        buttonEquals.setOnClickListener {
            secondNumber = currentNumber.toDouble()
            val result = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }
            resultTextView.text = result.toString()
            currentNumber = result.toString()
        }

        buttonAC.setOnClickListener {
            currentNumber = ""
            firstNumber = 0.0
            secondNumber = 0.0
            operator = null
            resultTextView.text = "0"
        }

        buttonDecimal.setOnClickListener {
            if (!currentNumber.contains(".")) {
                currentNumber += "."
                resultTextView.text = currentNumber
            }
        }
    }

    private fun setOperator(op: String) {
        firstNumber = currentNumber.toDouble()
        currentNumber = ""
        operator = op
    }
}

