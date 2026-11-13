package com.agc.ut3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 6 – Pantalla de perfil con ConstraintLayout.
 * Todo el diseño está en el XML: cada elemento lo "ato" a los bordes de la pantalla
 * o a otro elemento para que quede alineado.
 */
class Ej6PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej6_perfil)
        ajustarBordes()
    }
}
