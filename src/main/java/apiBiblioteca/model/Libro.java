package apiBiblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    private boolean disponible = true;
}