package apiBiblioteca.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Clase para probar la clase 'Libro'
class LibroTest {

    @Test
    // Prueba que el libro se cree y guarde el ID/Título correctamente
    void testCreacionLibro() {
        Libro libro = new Libro();
        libro.setTitulo("El Quijote");
        libro.setId(1L);

        // Revisa que los datos se guardaron bien
        assertEquals(1L, libro.getId());
        assertEquals("El Quijote", libro.getTitulo());
        // Revisa que esté disponible por defecto
        assertTrue(libro.isDisponible(), "Libro deberia estar disponible por defecto");
    }

    @Test
    // Prueba que se pueda cambiar el estado de disponibilidad
    void testDisponibilidadLibro() {
        Libro libro = new Libro();

        // Lo marca como 'no disponible'
        libro.setDisponible(false);

        // Revisa que SÍ esté 'no disponible'
        assertFalse(libro.isDisponible());
    }
}