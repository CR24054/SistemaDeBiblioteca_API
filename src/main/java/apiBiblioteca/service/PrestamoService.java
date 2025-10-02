package apiBiblioteca.service;

import apiBiblioteca.dto.PrestamoDTO;
import java.util.List;

public interface PrestamoService {
    // Metodo para crear el prestamo (resta stock)
    PrestamoDTO crearPrestamo(PrestamoDTO prestamoDto);

    //  Metodo para devolver el libro (suma stock, actualizar estado)
    PrestamoDTO registrarDevolucion(Long id);

    // Obtener uno
    PrestamoDTO obtenerPrestamoPorId(Long id);

    // Obtener todos
    List<PrestamoDTO> obtenerTodosLosPrestamos();
}