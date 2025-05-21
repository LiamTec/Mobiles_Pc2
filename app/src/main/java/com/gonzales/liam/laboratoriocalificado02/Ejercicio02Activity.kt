package com.gonzales.liam.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gonzales.liam.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            if (validarCampos()) {
                val intent = Intent(this, DetallePedidoActivity::class.java).apply {
                    putExtra("nombre", binding.etNombreCliente.text.toString().trim())
                    putExtra("numero", binding.etNumeroCliente.text.toString().trim())
                    putExtra("productos", binding.etProductos.text.toString().trim())
                    putExtra("ciudad", binding.etCiudad.text.toString().trim())
                    putExtra("direccion", binding.etDireccion.text.toString().trim())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarCampos(): Boolean {
        var valid = true

        if (binding.etNombreCliente.text.isNullOrBlank()) {
            binding.etNombreCliente.error = "Campo requerido"
            valid = false
        } else {
            binding.etNombreCliente.error = null
        }

        if (binding.etNumeroCliente.text.isNullOrBlank()) {
            binding.etNumeroCliente.error = "Campo requerido"
            valid = false
        } else {
            binding.etNumeroCliente.error = null
        }

        if (binding.etProductos.text.isNullOrBlank()) {
            binding.etProductos.error = "Campo requerido"
            valid = false
        } else {
            binding.etProductos.error = null
        }

        if (binding.etCiudad.text.isNullOrBlank()) {
            binding.etCiudad.error = "Campo requerido"
            valid = false
        } else {
            binding.etCiudad.error = null
        }

        if (binding.etDireccion.text.isNullOrBlank()) {
            binding.etDireccion.error = "Campo requerido"
            valid = false
        } else {
            binding.etDireccion.error = null
        }

        return valid
    }
}
