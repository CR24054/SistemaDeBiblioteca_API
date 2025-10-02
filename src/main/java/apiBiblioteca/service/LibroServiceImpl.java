package apiBiblioteca.service;

import apiBiblioteca.dto.LibroDTO;
import apiBiblioteca.exception.RecursoNoEncontradoException;
import apiBiblioteca.model.Libro;
import apiBiblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // aqui debe de implementar la lógica aquí ---

    private LibroDTO mapToDTO(Libro libro) {
        // JR: Convierte Entidad (Model) a DTO (para la salida)
        return null;
    }

    private Libro mapToEntity(LibroDTO libroDto) {
        // Convierta DTO (datos de entrada) a Entidad (Model)
        return null;
    }

    //  debe implementar la lógica de negocio en cada uno

    @Override
    public LibroDTO crearLibro(LibroDTO libroDto) {
        //  aqui ponga la lógica para guardar (save)
        return null;
    }

    @Override
    public LibroDTO obtenerLibroPorId(Long id) {
        //  Implemente la búsqueda, usando .orElseThrow() con RecursoNoEncontradoException
        throw new RecursoNoEncontradoException("Lógica de búsqueda pendiente por Gerson.");
    }

    @Override
    public List<LibroDTO> obtenerTodosLosLibros() {
        //Implemente  libroRepository.findAll() y la conversión a List<LibroDTO>
        return List.of();
    }

    @Override
    public LibroDTO actualizarLibro(Long id, LibroDTO libroDto) {
        //Implemente la lógica: buscar existente, actualizar datos, y guardar (save)
        return null;
    }

    @Override
    public void eliminarLibro(Long id) {
        // Implemente la lógica: buscar por ID y luego llamar a libroRepository.delete()
        throw new UnsupportedOperationException("Lógica de eliminación pendiente por JR.");
    }
}