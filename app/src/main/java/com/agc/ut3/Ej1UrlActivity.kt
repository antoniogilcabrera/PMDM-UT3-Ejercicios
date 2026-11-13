package com.agc.ut3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

/**
 * EJERCICIO 1 – Campo de texto y botón para abrir una URL.
 * Al pulsar el botón compruebo que el texto no esté vacío y que tenga formato de URL.
 * Si no lo cumple aviso con un Toast, y si está bien la abro con un Intent.
 */
class Ej1UrlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej1_url)
        ajustarBordes()

        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnAbrir = findViewById<Button>(R.id.btnAbrir)

        btnAbrir.setOnClickListener {
            val texto = etUrl.text.toString().trim()

            // Patterns.WEB_URL ya viene en Android y me ahorra hacer la expresión regular a mano
            if (texto.isEmpty() || !Patterns.WEB_URL.matcher(texto).matches()) {
                Toast.makeText(this, "Introduce una URL válida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Si escribo solo "google.es" el navegador no la entiende, por eso le pongo el https:// delante
            val url = if (texto.startsWith("http://") || texto.startsWith("https://")) texto else "https://$texto"

            // Intent implícito: no digo qué app abrir, solo que quiero "ver" esa dirección
            // y Android busca una que sepa hacerlo (el navegador)
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                // Por si el móvil no tiene ningún navegador instalado, así la app no se cierra
                Toast.makeText(this, "No hay ninguna app para abrir la URL", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
