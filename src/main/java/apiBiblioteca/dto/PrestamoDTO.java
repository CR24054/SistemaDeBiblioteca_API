package apiBiblioteca.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate; 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDTO {

    private Long id;


    @NotNull(message = "El ID del Usuario es obligatorio.")
    @Positive(message = "El ID del Usuario debe ser un número positivo.")
    private Long usuarioId;

    @NotNull(message = "El ID del Libro es obligatorio.")
    @Positive(message = "El ID del Libro debe ser un número positivo.")
    private Long libroId;



    // Al crear un préstamo, la fecha de préstamo puede ser hoy o futura.
    private LocalDate fechaPrestamo;

    @NotNull(message = "La fecha de devolución estimada es obligatoria.")
    @FutureOrPresent(message = "La fecha de devolución estimada debe ser hoy o en el futuro.")
    private LocalDate fechaDevolucionEstimada;

    private LocalDate fechaDevolucionReal;
    private Boolean devuelto;
}