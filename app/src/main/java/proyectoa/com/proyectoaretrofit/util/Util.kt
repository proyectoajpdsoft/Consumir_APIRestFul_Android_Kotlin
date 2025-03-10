package proyectoa.com.proyectoaretrofit.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.text.NumberFormat
import java.util.Locale

// Muestra un mensaje emergente unos segundos
fun MostrarMensaje(context: Context, mensaje: String,
                    tiempoLargo : Boolean = false) {
    var tiempo = Toast.LENGTH_LONG
    if (!tiempoLargo)
        tiempo = Toast.LENGTH_LONG
    val toast = Toast.makeText(context, mensaje, tiempo)
    toast.show()
}

// Escribir línea en Logcat de Android Studio para depuración
fun EscribirLog(tag: String = "ProyectoA", mensaje: String) {
    Log.d(tag, mensaje)
}

//Formatea un número para devolver separador de miles y decimal en ES
fun FormatearNumeroSeparadorMiles(numero: Double, moneda: String = "€"): String {
    try {
        val formato = NumberFormat.getNumberInstance(Locale("es", "ES"))
        formato.minimumFractionDigits = 2
        formato.maximumFractionDigits = 2

        var numFormateado = formato.format(numero) + moneda
        return  numFormateado
    } catch (e: Exception) {
        return "0,00"
    }
}

//Saber si un número tiene decimales
fun NumeroTieneDecimales(numero: Double): Boolean {
    try {
        return numero % 1 != 0.0
    } catch (e: Exception)
    {
        return false
    }
}