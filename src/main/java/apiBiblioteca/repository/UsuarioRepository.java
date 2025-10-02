package apiBiblioteca.repository;

import apiBiblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Aquí solo se añadirían métodos si necesitamos búsquedas personalizadas
    // Optional<Usuario> findByCarnet(String carnet);
}