package com.example.toaqui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import java.text.DecimalFormat

class ResultActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val respIMC: TextView = findViewById(R.id.RespIMC)
        val classification : TextView = findViewById(R.id.txtClassification)
        var meuPeso: TextView = findViewById(R.id.txtDadoPeso)
        var meuAlt: TextView = findViewById(R.id.txtDadoAltura)

        val valorIMC = intent.getFloatExtra("IDMain", 0.1f)
        val valorPeso = intent.getFloatExtra("idPeso", 0.0f)
        val valorAlt = intent.getFloatExtra("idAlt", 0.0f)

        respIMC.text = valorIMC.toString()

        meuPeso.text = "Peso:  " + valorPeso.toString().toFloat() + "Kg"
        meuAlt.text = "Altura: " + valorAlt.toString().toFloat()

        var classificacao = ""

        if (valorIMC < 18.50) {
            classificacao = "ABAIXO do peso, muito magro(a), precisa de ajuda!"
        } else if (valorIMC in 18.50..24.99) {
            classificacao = "com peso NORMAL, em forma."
        }else if (valorIMC in 25.00..29.99) {
            classificacao = "com SOBREPESO, precisa de ajuda!"
        }else if (valorIMC in 30.00..34.99) {
            classificacao = "com OBESIDADE Grau 1, precisa de ajuda!"
        } else if (valorIMC in 35.00..39.99) {
            classificacao = "com OBESIDADE Grau 2, precisa de ajuda!"
        } else if (valorIMC >= 40.00) {
            classificacao = "com OBESIDADE Grau 3, precisa de ajuda!"
        }

        classification.text = getString(R.string.message_Value_Classification, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}