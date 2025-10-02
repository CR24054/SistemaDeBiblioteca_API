package apiBiblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {

    private Long id;

    @NotBlank(message = "El título es obligatorio.")
    @Size(max = 200, message = "El título no debe exceder los 200 caracteres.")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio.")
    @Size(max = 100, message = "El autor no debe exceder los 100 caracteres.")
    private String autor;

    @NotBlank(message = "El ISBN es obligatorio.")
    @Size(max = 50, message = "El ISBN no debe exceder los 50 caracteres.")
    private String isbn;

    @NotNull(message = "El año de publicación es obligatorio.")
    @Min(value = 1800, message = "El año de publicación debe ser válido (ej: 1800 o superior).")
    private Integer anioPublicacion;

    @NotNull(message = "El stock total es obligatorio.")
    @Min(value = 0, message = "El stock no puede ser negativo.")
    private Integer stockTotal;
}