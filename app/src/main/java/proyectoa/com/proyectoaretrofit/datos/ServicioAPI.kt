package proyectoa.com.proyectoaretrofit.datos

import proyectoa.com.proyectoaretrofit.util.EscribirLog
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ServicioAPI {
    @GET("listar.php")
    suspend fun getFacturas(): List<FacturaModelo>

    companion object {
        private var servicioAPI: ServicioAPI? = null
        private var url: String = "http://ipcasa.ajpdsoft.com:8080/apirestfacturas/"

        fun getInstance(): ServicioAPI {
            if (servicioAPI == null) {
                try {
                    servicioAPI = Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(ServicioAPI::class.java)
                } catch (e: Exception)
                {
                    EscribirLog(mensaje = "Error al ejecutar servicioAPI: " + e.message)
                }
            }
            return servicioAPI!!
        }
    }
}