package apiBiblioteca.dto;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

// Clase para probar el Data Transfer Object 'UsuarioDTO'
class UsuarioDTOTest {

    // Inicializa el validador de Jakarta para poder probar las anotaciones
    private final Validator validator;

    public UsuarioDTOTest() {
        // Inicialización del validador. Se ejecuta una vez.
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            this.validator = factory.getValidator();
        }
    }

    // Método de utilidad para crear un DTO válido y usarlo como base
    private UsuarioDTO crearUsuarioDTOValido() {
        return new UsuarioDTO(
                1L,
                "Laura Flores",
                "laura.flores@universidad.edu",
                "U20231234"
        );
    }

    @Test
    // Prueba la creación y el funcionamiento básico de los getters/setters (Lombok)
    void testCreacionDTOCompleta() {
        // Usa el constructor con todos los argumentos (@AllArgsConstructor)
        UsuarioDTO dto = new UsuarioDTO(
                5L,
                "Mario Gómez",
                "mario.gomez@test.com",
                "G88888"
        );

        // Verificación de Getters
        assertEquals(5L, dto.getId());
        assertEquals("Mario Gómez", dto.getNombre());
        assertEquals("mario.gomez@test.com", dto.getEmail());
        assertEquals("G88888", dto.getCarnet());

        // Prueba un Setter de Lombok
        dto.setNombre("Mario G.");
        assertEquals("Mario G.", dto.getNombre());
    }

    // --- PRUEBAS DE VALIDACIÓN ---

    @Test
    // Prueba un DTO con todos los campos válidos
    void testValidacionExitosa() {
        UsuarioDTO dto = crearUsuarioDTOValido();
        // El set de violaciones de restricciones debe estar vacío
        assertTrue(validator.validate(dto).isEmpty(), "Un DTO válido no debe tener violaciones.");
    }

    @Test
    // Prueba si falla cuando el EMAIL tiene formato inválido (@Email)
    void testEmailInvalidoFalla() {
        UsuarioDTO dto = crearUsuarioDTOValido();
        dto.setEmail("correo-sin-arroba.com"); // Formato inválido

        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty(), "El email inválido debe fallar la validación.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("formato de correo electrónico válido")),
                   "Debe devolver el mensaje de formato de email.");
    }

    @Test
    // Prueba si falla cuando el NOMBRE está en blanco (@NotBlank)
    void testNombreEnBlancoFalla() {
        UsuarioDTO dto = crearUsuarioDTOValido();
        dto.setNombre(" "); // Solo un espacio, lo que cuenta como NotBlank

        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty(), "El nombre en blanco debe fallar la validación.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El nombre es obligatorio y no puede estar vacío.")),
                   "Debe devolver el mensaje de nombre obligatorio.");
    }

    @Test
    // Prueba si falla cuando el CARNET es muy corto (@Size min = 5)
    void testCarnetMuyCortoFalla() {
        UsuarioDTO dto = crearUsuarioDTOValido();
        dto.setCarnet("1234"); // Solo 4 caracteres

        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty(), "El carnet con 4 caracteres debe fallar.");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().contains("entre 5 y 20 caracteres.")),
                   "Debe devolver el mensaje de tamaño del carnet.");
    }
}