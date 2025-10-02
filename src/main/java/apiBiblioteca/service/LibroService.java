package apiBiblioteca.service;

import apiBiblioteca.dto.LibroDTO;
import java.util.List;

public interface LibroService {
    LibroDTO crearLibro(LibroDTO libroDto);
    LibroDTO obtenerLibroPorId(Long id);
    List<LibroDTO> obtenerTodosLosLibros();
    LibroDTO actualizarLibro(Long id, LibroDTO libroDto);
    void eliminarLibro(Long id);
}