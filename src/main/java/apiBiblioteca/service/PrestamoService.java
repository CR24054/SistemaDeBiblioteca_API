package apiBiblioteca.service;

import apiBiblioteca.model.Prestamo;
import java.util.List;

public interface PrestamoService {
    Prestamo crearPrestamo(Long idLibro, Long idUsuario);
    Prestamo devolverPrestamo(Long idPrestamo);
    List<Prestamo> listarPrestamos();
}