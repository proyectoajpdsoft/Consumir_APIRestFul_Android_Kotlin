package proyectoa.com.proyectoaretrofit.datos

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import proyectoa.com.proyectoaretrofit.util.EscribirLog
import proyectoa.com.proyectoaretrofit.util.FormatearNumeroSeparadorMiles
import proyectoa.com.proyectoaretrofit.util.MostrarMensaje
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("SimpleDateFormat")
@Composable
fun FacturaVista(facturaVistaModelo: FacturaVistaModelo, context: Context) {
    val state = facturaVistaModelo.state
    val formatoImporte = NumberFormat.getNumberInstance(Locale("es", "ES"))
    formatoImporte.minimumFractionDigits = 2
    formatoImporte.maximumFractionDigits = 2

    if (state.estaCargando) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        stickyHeader {
            Text(
                "Facturas",
                fontSize = 14.sp
            )
        }
        itemsIndexed(items = facturaVistaModelo.response) { _, item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .background(Color.White)
                    .clickable {
                        val mensaje = "Se ha pulsado en la factura " + item.codigo.toString()
                        EscribirLog(mensaje = mensaje)
                        MostrarMensaje(context, mensaje, tiempoLargo = true)
                    }
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "[" + item.codigo.toString() + "] " + item.cliente.toString(),
                        fontSize = 13.sp
                    )
                    Text(
                        " → Fecha: " + item.fecha?.let {
                            SimpleDateFormat("dd-MM-yyyy").format(
                                it
                            )
                        },
                        fontSize = 12.sp
                    )
                    Text(
                        text = " → Importe: " + item.importe?.let {
                            FormatearNumeroSeparadorMiles(
                                it
                            )
                        },
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.LightGray)
                .padding(17.dp)
                .clickable {
                    val mensaje = "Se ha pulsado en el pie de la lista de facturas"
                    EscribirLog(mensaje = mensaje)
                    MostrarMensaje(context, mensaje)
                }
        ) {
            Text("Número de facturas: " + facturaVistaModelo.response.count().toString(),
                fontSize = 12.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier.clickable {
                    val mensaje = "Se ha pulsado en el texto del pie de la lista de facturas"
                    EscribirLog(mensaje = mensaje)
                    MostrarMensaje(context, mensaje)
                })
        }
    }
}
