package apiBiblioteca.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

// Clase para probar el Data Transfer Object 'PrestamoDTO'
class PrestamoDTOTest {

    // Inicializa el validador de Jakarta para poder probar las anotaciones
    private final Validator validator;

    public PrestamoDTOTest() {
        // Inicialización del validador. Se ejecuta una vez.
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            this.validator = factory.getValidator();
        }
    }

    // Método de utilidad para crear un DTO válido y usarlo como base
    private PrestamoDTO crearPrestamoDTOValido() {
        LocalDate hoy = LocalDate.now();
        LocalDate futuro = hoy.plusDays(7);

        return new PrestamoDTO(
                1L, 
                10L, 
                50L, 
                hoy, 
                futuro, 
                null, 
                false
        );
    }

    @Test
    // Prueba la creación y el funcionamiento básico de los getters/setters (Lombok)
    void testCreacionDTOCompleta() {
        LocalDate hoy = LocalDate.now();
        LocalDate futura = hoy.plusDays(10);
        
        // Usa el constructor con todos los argumentos (@AllArgsConstructor)
        PrestamoDTO dto = new PrestamoDTO(
                5L, 
                2L, 
                3L, 
                hoy, 
                futura, 
                null, 
                false
        );

        // Verificación de Getters
        assertEquals(5L, dto.getId());
        assertEquals(2L, dto.getUsuarioId());
        assertEquals(3L, dto.getLibroId());
        assertEquals(futura, dto.getFechaDevolucionEstimada());
        assertFalse(dto.getDevuelto());
        
        // Prueba un Setter de Lombok
        dto.setDevuelto(true);
        assertTrue(dto.getDevuelto());
    }

    // --- PRUEBAS DE VALIDACIÓN ---
    
    @Test
    // Prueba un DTO con todos los campos válidos
    void testValidacionExitosa() {
        PrestamoDTO dto = crearPrestamoDTOValido();
        // El set de violaciones de restricciones debe estar vacío
        assertTrue(validator.validate(dto).isEmpty(), "Un DTO válido no debe tener violaciones.");
    }
    
    @Test
    // Prueba si falla cuando el ID del Usuario es nulo (@NotNull)
    void testUsuarioIdNuloFalla() {
        PrestamoDTO dto = crearPrestamoDTOValido();
        dto.setUsuarioId(null); // No puede ser nulo
        
        Set<ConstraintViolation<PrestamoDTO>> violations = validator.validate(dto);
        
        assertFalse(violations.isEmpty(), "El ID de Usuario nulo debe fallar la validación.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El ID del Usuario es obligatorio.")), 
                   "Debe devolver el mensaje de ID de Usuario obligatorio.");
    }
    
    @Test
    // Prueba si falla cuando el ID del Libro es negativo (@Positive)
    void testLibroIdNegativoFalla() {
        PrestamoDTO dto = crearPrestamoDTOValido();
        dto.setLibroId(-1L); // Debe ser positivo
        
        Set<ConstraintViolation<PrestamoDTO>> violations = validator.validate(dto);
        
        assertFalse(violations.isEmpty(), "El ID de Libro negativo debe fallar la validación.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("debe ser un número positivo.")), 
                   "Debe devolver el mensaje de ID de Libro positivo.");
    }
    
    @Test
    // Prueba si falla cuando la fecha de devolución es en el pasado (@FutureOrPresent)
    void testFechaDevolucionPasadaFalla() {
        PrestamoDTO dto = crearPrestamoDTOValido();
        dto.setFechaDevolucionEstimada(LocalDate.now().minusDays(1)); // Ayer
        
        Set<ConstraintViolation<PrestamoDTO>> violations = validator.validate(dto);
        
        assertFalse(violations.isEmpty(), "La fecha de devolución en el pasado debe fallar.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("hoy o en el futuro.")), 
                   "Debe devolver el mensaje de fecha futura.");
    }
}