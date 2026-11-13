package com.agc.ut3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 4 – FrameLayout principal con nueve FrameLayout dentro.
 * Aquí no hay lógica, todo está en el XML. Cada cuadrado lo coloco con layout_gravity
 * combinando arriba / centro / abajo con izquierda / centro / derecha.
 */
class Ej4FrameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej4_frame)
        ajustarBordes()
    }
}
