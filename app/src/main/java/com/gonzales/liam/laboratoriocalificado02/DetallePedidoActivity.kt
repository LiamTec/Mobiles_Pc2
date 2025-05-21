package com.gonzales.liam.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gonzales.liam.laboratoriocalificado02.databinding.ActivityDetallePedidoBinding

class DetallePedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePedidoBinding

    private var nombre = ""
    private var numero = ""
    private var productos = ""
    private var ciudad = ""
    private var direccion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nombre = intent.getStringExtra("nombre") ?: ""
        numero = intent.getStringExtra("numero") ?: ""
        productos = intent.getStringExtra("productos") ?: ""
        ciudad = intent.getStringExtra("ciudad") ?: ""
        direccion = intent.getStringExtra("direccion") ?: ""

        binding.tvNombreCliente.text = "Nombre: $nombre"
        binding.tvNumeroCliente.text = "Número: $numero"
        binding.tvProductos.text = "Productos: $productos"
        binding.tvUbicacion.text = "Ubicación: $ciudad, $direccion"

        binding.btnLlamar.setOnClickListener {
            Toast.makeText(this, "Llamando a $nombre, teléfono: $numero", Toast.LENGTH_LONG).show()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numero"))
            startActivity(intent)
        }

        binding.btnWsp.setOnClickListener {
            val mensaje = "Hola $nombre Tus productos: $productos están en camino a la dirección: $direccion"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            val url = "https://wa.me/$numero?text=${Uri.encode(mensaje)}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.btnMaps.setOnClickListener {
            Toast.makeText(this, "Mostrando ubicación: $ciudad, $direccion", Toast.LENGTH_LONG).show()
            val uri = Uri.parse("geo:0,0?q=${Uri.encode("$ciudad, $direccion")}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No se encontró aplicación de Maps", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
