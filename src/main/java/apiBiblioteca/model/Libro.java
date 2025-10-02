package apiBiblioteca.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(unique = true, nullable = false, length = 50)
    private String isbn; // Código Internacional Estándar del Libro

    @Column(nullable = false)
    private Integer anioPublicacion;

    // CLAVE para la lógica de Préstamo (Cristian usará esto)
    @Column(nullable = false)
    private Integer stockTotal;
}