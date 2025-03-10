package proyectoa.com.proyectoaretrofit.datos

data class FacturaEstado(
    val facturas: List<FacturaModelo> = emptyList(),
    val estaCargando: Boolean = false
)