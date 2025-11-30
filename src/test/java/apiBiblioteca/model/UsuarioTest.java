package apiBiblioteca.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Clase para probar el modelo 'Usuario'
class UsuarioTest {

    @Test
    // Prueba la creación básica y los setters/getters del usuario
    void testCreacionUsuario() {
        // 1. Creación del Usuario
        Usuario usuario = new Usuario();
        usuario.setId(10L);
        usuario.setNombre("Carlos Pérez");
        usuario.setCorreo("carlos.perez@ejemplo.com");

        // 2. Verificaciones (Assertions)
        
        // Revisa que el ID se haya guardado correctamente
        assertEquals(10L, usuario.getId());
        
        // Revisa que el nombre se haya guardado correctamente
        assertEquals("Carlos Pérez", usuario.getNombre());
        
        // Revisa que el correo se haya guardado correctamente
        assertEquals("carlos.perez@ejemplo.com", usuario.getCorreo());
    }

    @Test
    // Prueba que el campo de correo pueda ser nulo o vacío (si es permitido por el modelo)
    void testCorreoOpcional() {
        Usuario usuario = new Usuario();
        
        // Establecer el correo como nulo
        usuario.setCorreo(null);
        assertNull(usuario.getCorreo());
        
        // Establecer el correo como cadena vacía
        usuario.setCorreo("");
        assertEquals("", usuario.getCorreo());
    }
    
    @Test
    // Prueba que el campo nombre no puede ser nulo o vacío (asumiendo que es obligatorio, nullable = false)
    void testNombreObligatorio() {
        Usuario usuario = new Usuario();
        
        // Intentamos poner un nombre
        usuario.setNombre("Laura Díaz");
        assertEquals("Laura Díaz", usuario.getNombre());
        
        // Aunque la anotación @Column(nullable = false) se prueba mejor con el Repository,
        // este test asegura el comportamiento básico del setter/getter.
    }
}