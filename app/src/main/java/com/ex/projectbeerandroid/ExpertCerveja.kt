package com.ex.projectbeerandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExpertCerveja : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
        fun getMarcas(tipo: String): List<String> {
        return when (tipo) {
            "lager" -> listOf("Brahma", "Skol", "Heineken")
            "pilsen" -> listOf("Corona", "Stella Artois", "Bohemia")
            "bock" -> listOf("Caracu", "Eisenbahn Dunkel")
            "amber" -> listOf("Colorado Indica", "Red Ale")
            "weiss" -> listOf("Hoegaarden", "Erdinger Weissbier")
            else -> emptyList()

        }
    }
}