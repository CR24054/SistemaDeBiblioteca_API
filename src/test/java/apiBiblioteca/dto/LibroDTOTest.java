package apiBiblioteca.dto;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

// Para probar las validaciones (necesitarás la dependencia 'jakarta.validation')
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

// Clase para probar el Data Transfer Object 'LibroDTO'
class LibroDTOTest {

    // Inicializa el validador de Jakarta para poder probar las anotaciones
    private final Validator validator;

    public LibroDTOTest() {
        // Factory para crear la instancia del validador (solo se hace una vez)
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            this.validator = factory.getValidator();
        }
    }

    // Método de utilidad para crear un DTO válido y usarlo como base
    private LibroDTO crearLibroDTOValido() {
        return new LibroDTO(
                1L, 
                "Cien años de soledad", 
                "Gabriel García Márquez", 
                "978-84-376-0494-7", 
                1967, 
                10
        );
    }

    @Test
    // Prueba si la clase se crea con todos los datos y si Lombok funciona (getters/setters)
    void testCreacionDTOCompleta() {
        // 1. Usa el constructor con todos los argumentos (@AllArgsConstructor)
        LibroDTO dto = new LibroDTO(
                2L, 
                "El Quijote", 
                "Miguel de Cervantes", 
                "978-84-233-3560-6", 
                1605, 
                5
        );

        // 2. Verificación de Getters
        assertEquals(2L, dto.getId());
        assertEquals("El Quijote", dto.getTitulo());
        assertEquals("Miguel de Cervantes", dto.getAutor());
        assertEquals("978-84-233-3560-6", dto.getIsbn());
        assertEquals(1605, dto.getAnioPublicacion());
        assertEquals(5, dto.getStockTotal());
        
        // 3. Prueba un Setter de Lombok
        dto.setStockTotal(8);
        assertEquals(8, dto.getStockTotal());
    }

    // --- PRUEBAS DE VALIDACIÓN ---
    
    @Test
    // Prueba un DTO con todos los campos válidos
    void testValidacionExitosa() {
        LibroDTO dto = crearLibroDTOValido();
        // El set de violaciones de restricciones debe estar vacío
        assertTrue(validator.validate(dto).isEmpty(), "Un DTO válido no debe tener violaciones.");
    }
    
    @Test
    // Prueba si falla cuando el TÍTULO está en blanco (@NotBlank)
    void testTituloEnBlancoFalla() {
        LibroDTO dto = crearLibroDTOValido();
        dto.setTitulo(""); // Título vacío
        
        // El método validate() debe encontrar al menos una violación
        Set<jakarta.validation.ConstraintViolation<LibroDTO>> violations = validator.validate(dto);
        
        assertFalse(violations.isEmpty(), "El título en blanco debe fallar la validación.");
        // Opcional: verifica el mensaje exacto
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El título es obligatorio.")), 
                   "Debe devolver el mensaje de título obligatorio.");
    }
    
    @Test
    // Prueba si falla cuando el AÑO DE PUBLICACIÓN es muy antiguo (@Min)
    void testAnioMuyAntiguoFalla() {
        LibroDTO dto = crearLibroDTOValido();
        dto.setAnioPublicacion(1799); // Menor al mínimo de 1800
        
        Set<jakarta.validation.ConstraintViolation<LibroDTO>> violations = validator.validate(dto);
        
        assertFalse(violations.isEmpty(), "El año 1799 debe fallar la validación.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("1800 o superior")), 
                   "Debe devolver el mensaje de año mínimo.");
    }
    
    @Test
    // Prueba si falla cuando el STOCK es nulo (@NotNull)
    void testStockNuloFalla() {
        LibroDTO dto = crearLibroDTOValido();
        dto.setStockTotal(null); // No puede ser nulo
        
        Set<jakarta.validation.ConstraintViolation<LibroDTO>> violations = validator.validate(dto);
        
        assertFalse(violations.isEmpty(), "El stock nulo debe fallar la validación.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El stock total es obligatorio.")), 
                   "Debe devolver el mensaje de stock obligatorio.");
    }
}