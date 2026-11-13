package com.agc.ut3

import android.app.ActivityOptions
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 2 – Navegación retrasada 10 segundos.
 * El PendingIntent es un Intent "preparado" que puedo lanzar más tarde, y el Handler
 * es el que se encarga de esperar los 10 segundos antes de lanzarlo.
 */
class Ej2RetrasoActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val retrasoMs = 10_000L          // 10 segundos, si quiero otro tiempo solo cambio esto
    private var segundosRestantes = 0
    private lateinit var tvCuenta: TextView
    private lateinit var btnIr: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej2_retraso)
        ajustarBordes()

        tvCuenta = findViewById(R.id.tvCuenta)
        btnIr = findViewById(R.id.btnIr)

        btnIr.setOnClickListener {
            // Desactivo el botón para que no se pueda pulsar dos veces mientras espera
            btnIr.isEnabled = false

            val intent = Intent(this, Ej2DestinoActivity::class.java)

            // Meto el Intent dentro de un PendingIntent. FLAG_IMMUTABLE es obligatorio desde Android 12
            val pendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            // Pasados los 10 segundos el Handler lanza el PendingIntent y deja todo como estaba
            handler.postDelayed({
                lanzar(pendingIntent)
                btnIr.isEnabled = true
                tvCuenta.text = ""
            }, retrasoMs)

            // He añadido una cuenta atrás para que se vea que la app está esperando y no colgada
            segundosRestantes = (retrasoMs / 1000).toInt()
            handler.post(cuentaAtras)
        }
    }

    // Se repite cada segundo hasta llegar a 0 (10, 9, 8...)
    private val cuentaAtras = object : Runnable {
        override fun run() {
            if (segundosRestantes > 0) {
                tvCuenta.text = "Navegando en $segundosRestantes s..."
                segundosRestantes--
                handler.postDelayed(this, 1000)
            }
        }
    }

    // En Android 14 o superior un PendingIntent no abre pantallas si no le doy permiso expresamente,
    // por eso le paso estas opciones al enviarlo
    private fun lanzar(pendingIntent: PendingIntent) {
        val opciones = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            @Suppress("DEPRECATION")
            ActivityOptions.makeBasic()
                .setPendingIntentBackgroundActivityStartMode(ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOWED)
                .toBundle()
        } else null
        pendingIntent.send(this, 0, null, null, null, null, opciones)
    }

    // Si salgo de la pantalla antes de que pasen los 10 segundos, cancelo lo que estaba programado
    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
