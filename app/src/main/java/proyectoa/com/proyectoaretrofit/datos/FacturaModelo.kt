package proyectoa.com.proyectoaretrofit.datos

import java.util.Calendar
import java.util.Date

data class FacturaModelo(
    var codigo:Int?=0,
    var cliente:String?="",
    var fecha: Date?= Calendar.getInstance().time,
    var importe:Double?=0.0
)