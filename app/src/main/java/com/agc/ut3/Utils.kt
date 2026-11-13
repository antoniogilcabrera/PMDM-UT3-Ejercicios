package com.agc.ut3

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Desde Android 15 la app se dibuja "de borde a borde", así que la barra de estado me tapaba
 * la parte de arriba de las pantallas. Con esta función le doy al contenido el relleno justo
 * para que no quede nada debajo de las barras del sistema.
 * La llamo en todas las activities después del setContentView().
 */
fun AppCompatActivity.ajustarBordes() {
    val contenido = findViewById<View>(android.R.id.content)
    ViewCompat.setOnApplyWindowInsetsListener(contenido) { vista, insets ->
        val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime())
        vista.setPadding(barras.left, barras.top, barras.right, barras.bottom)
        insets
    }
}
