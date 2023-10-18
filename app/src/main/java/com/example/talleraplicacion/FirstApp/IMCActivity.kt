package com.example.talleraplicacion.FirstApp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import com.example.talleraplicacion.R

class IMCActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        val resultado = findViewById<AppCompatTextView>(R.id.tvResultado)
        val imc = intent.getFloatExtra("resultado", 0.0f)
        resultado.text = "$imc"

        val tiene = findViewById<AppCompatTextView>(R.id.tvTiene)
        val estado = intent?.getStringExtra("tipoIMC").orEmpty()
        tiene.text = "$estado"


    }
}