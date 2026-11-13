package com.agc.ut3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 5 – Calculadora sencilla con TableLayout.
 * La pantalla va mostrando el número que escribo y luego el resultado. Cuando pulso una
 * operación guardo el primer número y la operación, y al pulsar "=" hago la cuenta con el segundo.
 * "C" lo deja todo a cero.
 */
class Ej5CalculadoraActivity : AppCompatActivity() {

    private lateinit var pantalla: TextView

    private var primerNumero: Double? = null     // el número que había antes de pulsar la operación
    private var operacion: String? = null        // "+", "-", "*" o "/"
    private var empezarNuevoNumero = true        // si está a true, la siguiente cifra borra lo que hay en pantalla

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej5_calculadora)
        ajustarBordes()

        pantalla = findViewById(R.id.tvPantalla)

        // Los diez botones numéricos hacen lo mismo, así que los recorro con un bucle
        // y cada uno escribe el número que tiene de texto
        val numeros = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )
        for (id in numeros) {
            val boton = findViewById<Button>(id)
            boton.setOnClickListener { escribirCifra(boton.text.toString()) }
        }

        findViewById<Button>(R.id.btnPunto).setOnClickListener { escribirPunto() }
        findViewById<Button>(R.id.btnSumar).setOnClickListener { elegirOperacion("+") }
        findViewById<Button>(R.id.btnRestar).setOnClickListener { elegirOperacion("-") }
        findViewById<Button>(R.id.btnMultiplicar).setOnClickListener { elegirOperacion("*") }
        findViewById<Button>(R.id.btnDividir).setOnClickListener { elegirOperacion("/") }
        findViewById<Button>(R.id.btnIgual).setOnClickListener { calcularResultado() }
        findViewById<Button>(R.id.btnBorrar).setOnClickListener { borrarTodo() }
    }

    private fun escribirCifra(cifra: String) {
        if (empezarNuevoNumero || pantalla.text == "0" || pantalla.text == "Error") {
            pantalla.text = cifra
            empezarNuevoNumero = false
        } else {
            pantalla.append(cifra)
        }
    }

    // Solo dejo poner un punto por número, si no saldrían cosas como 2.5.3
    private fun escribirPunto() {
        if (empezarNuevoNumero || pantalla.text == "Error") {
            pantalla.text = "0."
            empezarNuevoNumero = false
        } else if (!pantalla.text.contains(".")) {
            pantalla.append(".")
        }
    }

    private fun elegirOperacion(nuevaOperacion: String) {
        // Si encadeno operaciones (por ejemplo 2 + 3 +) primero resuelvo la que estaba pendiente
        if (operacion != null && !empezarNuevoNumero) {
            calcularResultado()
        }
        primerNumero = pantalla.text.toString().toDoubleOrNull()
        operacion = nuevaOperacion
        empezarNuevoNumero = true
    }

    private fun calcularResultado() {
        val a = primerNumero ?: return
        val op = operacion ?: return
        val b = pantalla.text.toString().toDoubleOrNull() ?: return

        val resultado = when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b == 0.0) null else a / b   // entre 0 no se puede dividir, devuelvo null y saco "Error"
            else -> null
        }

        pantalla.text = if (resultado == null) "Error" else formatear(resultado)
        primerNumero = null
        operacion = null
        empezarNuevoNumero = true
    }

    private fun borrarTodo() {
        pantalla.text = "0"
        primerNumero = null
        operacion = null
        empezarNuevoNumero = true
    }

    // Trabajo con Double, así que 7.5 * 2 daba "15.0". Con esto quito el ".0" cuando el resultado es entero
    private fun formatear(numero: Double): String =
        if (numero == numero.toLong().toDouble()) numero.toLong().toString() else numero.toString()
}
