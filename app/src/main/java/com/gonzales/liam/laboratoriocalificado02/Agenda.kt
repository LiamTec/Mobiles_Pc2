package com.gonzales.liam.laboratoriocalificado02
class Agenda {
    private val contactos = mutableListOf<Contacto>()
    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
        println("Contacto agregado: ${contacto.nombre}")
    }
    fun listarContactos() {
        if (contactos.isEmpty()) {
            println("No hay contactos en la agenda.")
        } else {
            println("Lista de contactos:")
            contactos.forEachIndexed { index, contacto ->
                println("${index + 1}. ${contacto.nombre} - Edad: ${contacto.edad} - Tel: ${contacto.telefono} - Email: ${contacto.email} - Descripción: ${contacto.descripcion}")
            }
        }
    }
    fun buscarContacto(nombre: String) {
        val encontrados = contactos.filter { it.nombre.contains(nombre, ignoreCase = true) }
        if (encontrados.isEmpty()) {
            println("No se encontró ningún contacto con el nombre \"$nombre\"")
        } else {
            println("Contactos encontrados con \"$nombre\":")
            encontrados.forEach {
                println("- ${it.nombre} - Edad: ${it.edad} - Tel: ${it.telefono} - Email: ${it.email} - Descripción: ${it.descripcion}")
            }
        }
    }
    fun Buscar(nombre: String): List<Contacto> {
        return contactos.filter { it.nombre.contains(nombre, ignoreCase = true) }
    }
}
