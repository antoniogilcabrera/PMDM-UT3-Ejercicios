# UT3 · Activities, Intents y Layouts

PMDM · 2º DAM · Antonio Gil Cabrera

App Android en Kotlin con los 6 ejercicios del boletín. Al abrirla sale un menú con un botón para cada ejercicio.

| Ejercicio | Qué hace | Archivos |
|---|---|---|
| 1 | Valida una URL y la abre con un Intent (si no es válida, Toast) | `Ej1UrlActivity.kt` |
| 2 | Abre la segunda pantalla 10 segundos después con PendingIntent y Handler | `Ej2RetrasoActivity.kt`, `Ej2DestinoActivity.kt` |
| 3 | Tres botones apilados que llevan a pantallas hechas con LinearLayout anidados | `Ej3MenuActivity.kt`, `Ej3Pantallas.kt` |
| 4 | FrameLayout con nueve FrameLayout de colores | `activity_ej4_frame.xml` |
| 5 | Calculadora con TableLayout | `Ej5CalculadoraActivity.kt` |
| 6 | Pantalla de perfil con ConstraintLayout | `activity_ej6_perfil.xml` |

El código está en `app/src/main/java/com/agc/ut3/` y los layouts en `app/src/main/res/layout/`.

Para probarla: abrir el proyecto en Android Studio y darle a Run.
