package com.gonzales.liam.laboratoriocalificado02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gonzales.liam.laboratoriocalificado02.databinding.ActivityEjercicio01Binding

class Ejercicio01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnMostrar.setOnClickListener {
            binding.viewVerde.visibility = android.view.View.VISIBLE
        }
        binding.btnOcultar.setOnClickListener {
            binding.viewVerde.visibility = android.view.View.INVISIBLE
        }
    }
}