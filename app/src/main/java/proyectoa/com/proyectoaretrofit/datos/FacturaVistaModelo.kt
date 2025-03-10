package proyectoa.com.proyectoaretrofit.datos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import proyectoa.com.proyectoaretrofit.util.EscribirLog

class FacturaVistaModelo: ViewModel() {
    var state by mutableStateOf(FacturaEstado())
        private set
    var response:List<FacturaModelo> by mutableStateOf((listOf()))
        private set
    init {
        try {
            viewModelScope.launch {
                state = state.copy(
                    estaCargando = true
                )
                val servicioAPI = ServicioAPI.getInstance()
                val listaFactura = servicioAPI.getFacturas()
                response = listaFactura
                state = state.copy(
                    estaCargando = false,
                    facturas = response
                )
            }
        } catch (e: Exception) {
            EscribirLog(mensaje = "Error al cargar el Modelo-Vista: " + e.message)
        }
    }
}