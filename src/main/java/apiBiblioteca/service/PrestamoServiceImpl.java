package apiBiblioteca.service;

import apiBiblioteca.dto.PrestamoDTO;
import apiBiblioteca.exception.RecursoNoEncontradoException;
import apiBiblioteca.model.Prestamo;
import apiBiblioteca.repository.PrestamoRepository;
import apiBiblioteca.repository.UsuarioRepository;
import apiBiblioteca.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LibroRepository libroRepository;

    // --- MÉTODOS DE CONVERSIÓN ---
    private PrestamoDTO mapToDTO(Prestamo prestamo) { return null; }
    private Prestamo mapToEntity(PrestamoDTO prestamoDto) { return null; }

    @Override
    public PrestamoDTO crearPrestamo(PrestamoDTO prestamoDto) {
        // Busca Usuario y Libro por ID (lanza RecursoNoEncontradoException si no existen).
        // VERIFICA que el Libro tenga stockTotal > 0. Si no, lanza una excepción (ej: StockInsuficienteException).
        // RESTA 1 al stockTotal del Libro y guarda el Libro.
        // Crea la entidad Préstamo, asigna las fechas y los objetos Usuario/Libro.
        // Guarda (save) el Préstamo.
        return null;
    }

    @Override
    public PrestamoDTO registrarDevolucion(Long id) {
        // Busca el Préstamo por ID.
        // VERIFICA que el Préstamo no esté ya devuelto.
        // SUMA 1 al stockTotal del Libro asociado y guarda el Libro.
        //  Actualiza la fechaDevolucionReal y el estado 'devuelto' a true en el Préstamo.
        //  Guarda (save) el Préstamo.
        return null;
    }

    @Override
    public PrestamoDTO obtenerPrestamoPorId(Long id) {
        throw new RecursoNoEncontradoException("Lógica de búsqueda de Préstamo pendiente.");
    }

    @Override
    public List<PrestamoDTO> obtenerTodosLosPrestamos() {
        return List.of();
    }
}