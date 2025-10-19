package apiBiblioteca.controller;

import apiBiblioteca.model.Libro;
import apiBiblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.listarLibros();
    }
}