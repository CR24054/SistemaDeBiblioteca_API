package apiBiblioteca.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    private Libro libro;

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    @Column(nullable = false, length = 20)
    private String estado; // "activo" o "devuelto"
}