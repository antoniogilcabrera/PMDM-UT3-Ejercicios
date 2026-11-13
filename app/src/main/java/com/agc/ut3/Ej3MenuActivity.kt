package com.agc.ut3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 3 – Pantalla principal del ejercicio.
 * He elegido el primer diseño (azul | blanco | azul) como pantalla principal y he puesto
 * los tres botones apilados en la franja blanca. Cada botón abre una activity con otro diseño.
 */
class Ej3MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej3_menu)
        ajustarBordes()

        findViewById<Button>(R.id.btnPantalla1).setOnClickListener {
            startActivity(Intent(this, Ej3Pantalla1Activity::class.java))
        }
        findViewById<Button>(R.id.btnPantalla2).setOnClickListener {
            startActivity(Intent(this, Ej3Pantalla2Activity::class.java))
        }
        findViewById<Button>(R.id.btnPantalla3).setOnClickListener {
            startActivity(Intent(this, Ej3Pantalla3Activity::class.java))
        }
    }
}
