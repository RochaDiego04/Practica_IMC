package com.example.practica_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun determineBMICategory(bmi: Double): String {
        if (bmi > 0.0 && bmi <= 15.0) {
            return "Delgadez muy severa"
        }
        else if (bmi > 15.0 && bmi <= 15.9) {
            return "Delgadez severa"
        }
        else if (bmi > 15.9 && bmi <= 18.4) {
            return "Delgadez"
        }
        else if (bmi > 18.4 && bmi <= 24.9) {
            return "Peso saludable"
        }
        else if (bmi > 24.9 && bmi <= 29.9) {
            return "Sobrepeso"
        }
        else if (bmi > 29.9 && bmi <= 34.9) {
            return "Obesidad moderada"
        }
        else if (bmi > 34.9 && bmi <= 39.9) {
            return "Obesidad severa"
        }
        else{
            return "Obesidad no severa"
        }
    }

    fun comprobarCampo1(): Boolean {
        val estatura: TextView = findViewById(R.id.activity_main_edit_estatura)

        if (estatura.text.toString().trim().isEmpty()) {
            estatura.error = getString(R.string.activity_main_error)
            return false
        }

        return true
    }

    fun comprobarCampo2(): Boolean {
        val peso: TextView = findViewById(R.id.activity_main_edit_peso)

        if (peso.text.toString().trim().isEmpty()) {
            peso.error = getString(R.string.activity_main_error)
            return false
        }
        return true
    }

    fun calcularIMC(view:View){
        val editEstatura: TextView = findViewById(R.id.activity_main_edit_estatura)
        val editPeso: TextView = findViewById(R.id.activity_main_edit_peso)
        val editResultado: TextView = findViewById(R.id.activity_main_resultado)
        val duracion = Toast.LENGTH_SHORT

        val campo1Valido = comprobarCampo1()
        val campo2Valido = comprobarCampo2()



        if (campo1Valido && campo2Valido) {
            val estatura = editEstatura.text.toString().toDoubleOrNull() ?: 0.0
            val peso = editPeso.text.toString().toDoubleOrNull() ?: 0.0
            val resultado = peso / estatura.pow(2.0)

            val mensaje = determineBMICategory(resultado)
            val toast = Toast.makeText(applicationContext, mensaje, duracion)
            toast.show()
            editResultado.text = "IMC: $resultado"
        }
    }

}