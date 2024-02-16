package com.example.toaqui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val editPeso: EditText = findViewById(R.id.edtPeso)
        val editAlt: EditText = findViewById(R.id.edtAltura)
        val btnIMC: Button = findViewById(R.id.btnIMC)

        btnIMC.setOnClickListener{
            val strAlt = editAlt.text.toString()
            val strPeso = editPeso.text.toString()

            if(strAlt.isNotEmpty() && strPeso.isNotEmpty()){
                val alt: Float = editAlt.text.toString().toFloat()
                val peso: Float = editPeso.text.toString().toFloat()

                val respAlt: Float = alt * alt
                val respIMC: Float = peso / respAlt

                val intent = Intent(this, ResultActivity2::class.java)
                    .apply {
                        putExtra("IDMain", respIMC)
                    }
                    .apply {
                        putExtra("idPeso", peso)
                    }
                    .apply {
                        putExtra("idAlt", alt)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Precisa preencher todos os Campos", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finishAndRemoveTask()
        return super.onOptionsItemSelected(item)
    }
}