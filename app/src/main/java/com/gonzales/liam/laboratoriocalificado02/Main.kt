package com.gonzales.liam.laboratoriocalificado02

fun main() {
    val agenda = Agenda()

    agenda.agregarContacto(Contacto("Ana López", 25, "123456789", "ana@example.com", "Amiga de la universidad"))
    agenda.agregarContacto(Contacto("Juan Pérez", 30, "987654321", "juan@example.com", "Compañero de trabajo"))
    agenda.agregarContacto(Contacto("María García", 28, "555666777", "maria@example.com", "Vecina"))

    println()

    agenda.listarContactos()

    println()

    agenda.buscarContacto("Juan")
}
