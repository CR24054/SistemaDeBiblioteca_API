package apiBiblioteca.controller;

import apiBiblioteca.dto.LibroDTO;
import apiBiblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Crear Libro (POST)
    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(@Valid @RequestBody LibroDTO libroDto) {
        LibroDTO nuevoLibro = libroService.crearLibro(libroDto);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED); // 201 Created
    }

    // Obtener Todos (GET ALL)
    @GetMapping
    public ResponseEntity<List<LibroDTO>> obtenerTodos() {
        List<LibroDTO> libros = libroService.obtenerTodosLosLibros();
        return ResponseEntity.ok(libros); // 200 OK
    }

    // Obtener por ID (GET por ID)
    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerPorId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(libroService.obtenerLibroPorId(id));
    }

    // Actualizar Libro (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(
            @Valid @RequestBody LibroDTO libroDto,
            @PathVariable(name = "id") Long id) {
        LibroDTO libroActualizado = libroService.actualizarLibro(id, libroDto);
        return new ResponseEntity<>(libroActualizado, HttpStatus.OK); // 200 OK
    }

    // Eliminar Libro (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable(name = "id") Long id) {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>("Libro eliminado con éxito.", HttpStatus.OK); // 200 OK
    }
}