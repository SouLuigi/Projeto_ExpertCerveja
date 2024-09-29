package com.ex.projectbeerandroid

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val expertCerveja = ExpertCerveja()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val spinner: Spinner = findViewById(R.id.spinnerBeer)
        ArrayAdapter.createFromResource(
            this,
            R.array.beer_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        val marcasTextView: TextView = findViewById(R.id.textMarcas)


        val button: Button = findViewById(R.id.buttonBuscar)
        button.setOnClickListener {
            Log.d("BuscarCerveja", "Botão clicado!")

            val tipoSelecionado = spinner.selectedItem.toString()


            val marcas = expertCerveja.getMarcas(tipoSelecionado)


            marcasTextView.text = marcas.joinToString(separator = "\n")
        }
    }
}