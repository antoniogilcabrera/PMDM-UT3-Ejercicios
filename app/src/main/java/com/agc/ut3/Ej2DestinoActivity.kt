package com.agc.ut3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/** EJERCICIO 2 – Segunda activity, la que se abre cuando pasan los 10 segundos. */
class Ej2DestinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej2_destino)
        ajustarBordes()
    }
}
