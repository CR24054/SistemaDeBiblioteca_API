package apiBiblioteca.model;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

// Clase para probar el modelo 'Prestamo'
class PrestamoTest {

    @Test
    // Prueba la creación básica y los setters/getters del préstamo
    void testCreacionPrestamo() {
        // 1. Preparación de objetos dependientes
        Usuario usuarioFalso = new Usuario();
        usuarioFalso.setId(10L);
        usuarioFalso.setNombre("Ana García");

        Libro libroFalso = new Libro();
        libroFalso.setId(50L);
        libroFalso.setTitulo("Cien años de soledad");
        
        LocalDate hoy = LocalDate.now();
        LocalDate devolucionEsperada = hoy.plusDays(7); // Devolución en 7 días

        // 2. Creación del Prestamo
        Prestamo prestamo = new Prestamo();
        prestamo.setId(1L);
        prestamo.setUsuario(usuarioFalso);
        prestamo.setLibro(libroFalso);
        prestamo.setFechaPrestamo(hoy);
        prestamo.setFechaDevolucion(devolucionEsperada);
        prestamo.setEstado("activo");

        // 3. Verificaciones (Assertions)
        // Datos básicos
        assertEquals(1L, prestamo.getId());
        assertEquals("activo", prestamo.getEstado());
        assertEquals(hoy, prestamo.getFechaPrestamo());
        assertEquals(devolucionEsperada, prestamo.getFechaDevolucion());

        // Relaciones con otros objetos
        assertNotNull(prestamo.getUsuario());
        assertEquals("Ana García", prestamo.getUsuario().getNombre());
        assertNotNull(prestamo.getLibro());
        assertEquals("Cien años de soledad", prestamo.getLibro().getTitulo());
    }

    @Test
    // Prueba el cambio de estado de 'activo' a 'devuelto'
    void testCambioEstado() {
        Prestamo prestamo = new Prestamo();
        prestamo.setEstado("activo");
        
        // El préstamo debe iniciar activo
        assertEquals("activo", prestamo.getEstado());

        // Cambiamos el estado
        prestamo.setEstado("devuelto");

        // El estado debe haber cambiado
        assertEquals("devuelto", prestamo.getEstado());
    }

    @Test
    // Prueba que la fecha de devolución sea posterior a la de préstamo
    void testFechas() {
        LocalDate prestamoDate = LocalDate.of(2025, 1, 1);
        LocalDate devolucionDate = LocalDate.of(2025, 1, 15);
        
        Prestamo prestamo = new Prestamo();
        prestamo.setFechaPrestamo(prestamoDate);
        prestamo.setFechaDevolucion(devolucionDate);

        // Verificamos que la fecha de devolución es posterior (es decir, la fecha de préstamo es anterior)
        assertTrue(prestamo.getFechaPrestamo().isBefore(prestamo.getFechaDevolucion()));
    }
}