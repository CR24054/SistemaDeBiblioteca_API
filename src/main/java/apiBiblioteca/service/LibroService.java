package apiBiblioteca.service;

import apiBiblioteca.model.Libro;
import java.util.List;

public interface LibroService {
    Libro crearLibro(Libro libro);
    List<Libro> listarLibros();
}