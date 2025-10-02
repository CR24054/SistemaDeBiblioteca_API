package apiBiblioteca.repository;

import apiBiblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    // Buscar todos los préstamos que aún no han sido devueltos
    List<Prestamo> findByDevueltoFalse();
}