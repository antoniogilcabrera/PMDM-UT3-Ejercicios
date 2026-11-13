package com.agc.ut3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/*
 * EJERCICIO 3 – Las tres pantallas a las que llevan los botones.
 * Las he puesto juntas en este archivo porque solo cargan su layout: todo el diseño
 * está hecho en el XML con LinearLayout anidados, y el mensaje de cada una va en la cabecera.
 */

// Pantalla 1: franjas verde | blanco | verde
class Ej3Pantalla1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej3_pantalla1)
        ajustarBordes()
    }
}

// Pantalla 2: tablero de 2 filas y 3 columnas, alternando blanco y rojo
class Ej3Pantalla2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej3_pantalla2)
        ajustarBordes()
    }
}

// Pantalla 3: arriba columnas y abajo franjas horizontales
class Ej3Pantalla3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej3_pantalla3)
        ajustarBordes()
    }
}
