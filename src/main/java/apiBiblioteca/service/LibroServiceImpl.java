package apiBiblioteca.service;

import apiBiblioteca.model.Libro;
import apiBiblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}