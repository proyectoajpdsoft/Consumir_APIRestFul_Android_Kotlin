package proyectoa.com.proyectoaretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import proyectoa.com.proyectoaretrofit.datos.FacturaVista
import proyectoa.com.proyectoaretrofit.datos.FacturaVistaModelo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vistaModelo: FacturaVistaModelo by viewModels()
        setContent {
            FacturaVista(facturaVistaModelo = vistaModelo, this)
        }


        /*
        enableEdgeToEdge()
        setContent {
            ProyectoARetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        */
    }
}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoARetrofitTheme {
        Greeting("Android")
    }
}
*/