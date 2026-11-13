package com.agc.ut3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity principal. Es un menú con un botón para cada ejercicio, y cada botón
 * abre su activity con un Intent explícito (le digo exactamente qué pantalla abrir).
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ajustarBordes()

        findViewById<Button>(R.id.btnEj1).setOnClickListener { abrir(Ej1UrlActivity::class.java) }
        findViewById<Button>(R.id.btnEj2).setOnClickListener { abrir(Ej2RetrasoActivity::class.java) }
        findViewById<Button>(R.id.btnEj3).setOnClickListener { abrir(Ej3MenuActivity::class.java) }
        findViewById<Button>(R.id.btnEj4).setOnClickListener { abrir(Ej4FrameActivity::class.java) }
        findViewById<Button>(R.id.btnEj5).setOnClickListener { abrir(Ej5CalculadoraActivity::class.java) }
        findViewById<Button>(R.id.btnEj6).setOnClickListener { abrir(Ej6PerfilActivity::class.java) }
    }

    // Hice esta función para no repetir startActivity(Intent(...)) seis veces
    private fun abrir(destino: Class<*>) {
        startActivity(Intent(this, destino))
    }
}
