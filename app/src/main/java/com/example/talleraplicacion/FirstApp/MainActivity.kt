package com.example.talleraplicacion.FirstApp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.talleraplicacion.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<AppCompatButton>(R.id.btnIMC)

        btnCalcular.setOnClickListener {

            val txtPeso = findViewById<AppCompatEditText>(R.id.txtPeso)
            txtPeso.requestFocus()
            val pesoString = txtPeso.text.toString()

            val txtEstatura = findViewById<AppCompatEditText>(R.id.txtEstatura)
            txtEstatura.requestFocus()
            val estaturaString = txtEstatura.text.toString()

            if (pesoString.isNotEmpty() and estaturaString.isNotEmpty()) {
                try {
                    val pesoIMC = pesoString.toFloat()
                    val estaturaIMC = estaturaString.toFloat()

                    // Calculo del IMC
                    val imc = (pesoIMC / (estaturaIMC * estaturaIMC))

                    // Evaluar el IMC y asignar el tipo correspondiente
                    val tipoIMC = when {
                        imc < 16.00 -> "Infrapeso: Delgadez Severa"
                        imc >= 16.00 && imc <= 16.99 -> "Infrapeso: Delgadez moderada"
                        imc >= 17.00 && imc <= 18.49 -> "Infrapeso: Delgadez aceptable"
                        imc >= 18.50 && imc <= 24.99 -> "Peso Normal"
                        imc >= 25.00 && imc <= 29.99 -> "Sobrepeso"
                        imc >= 30.00 && imc <= 34.99 -> "Obeso: Tipo I"
                        imc >= 35.00 && imc <= 40.00 -> "Obeso: Tipo II"
                        imc > 40.00 -> "Obeso: Tipo III"
                        else -> "Valor de IMC no válido"
                    }

                    //llamar al otro activity
                    val intent = Intent(this, IMCActivity::class.java)
                    intent.putExtra("resultado", imc)
                    intent.putExtra("tipoIMC", tipoIMC)
                    startActivity(intent)


                } catch (e: NumberFormatException) {
                    // Maneja la excepción si el texto no se puede convertir a un número válido.
                    val instructionsTextView = findViewById<TextView>(R.id.instructionsTextView)
                    val errorMessage = "¡Ha ocurrido un error!"
                }
            } else {
                // El campo de entrada está vacío, puedes mostrar un mensaje de error o realizar otra acción.
                val instructionsTextView = findViewById<TextView>(R.id.instructionsTextView)
                val errorMessage = "¡Ha ocurrido un error!"

                instructionsTextView.text = errorMessage


            }
        }
    }
}