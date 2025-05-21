package com.gonzales.liam.laboratoriocalificado02

import org.junit.Test
import org.junit.Assert.*

class AgendaTest {

    @Test
    fun Prueba() {
        val agenda = Agenda()

        agenda.agregarContacto(Contacto("Ana López", 25, "123456789", "ana@example.com", "Amiga"))
        agenda.agregarContacto(Contacto("Juan Pérez", 30, "987654321", "juan@example.com", "Compañero"))

        val encontrados = agenda.Buscar("Juan")
        assertEquals(1, encontrados.size)
        assertEquals("Juan Pérez", encontrados[0].nombre)
    }
}
