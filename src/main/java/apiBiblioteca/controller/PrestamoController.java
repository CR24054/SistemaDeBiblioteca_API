package apiBiblioteca.controller;

import apiBiblioteca.dto.PrestamoDTO;
import apiBiblioteca.service.PrestamoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    // CREA Préstamo (POST)
    @PostMapping
    public ResponseEntity<PrestamoDTO> crearPrestamo(@Valid @RequestBody PrestamoDTO prestamoDto) {
        //  El @Valid aquí revisa que el usuarioId y libroId existan en el DTO.
        PrestamoDTO nuevoPrestamo = prestamoService.crearPrestamo(prestamoDto);
        return new ResponseEntity<>(nuevoPrestamo, HttpStatus.CREATED); // 201 Created
    }

    //  REGISTRAR DEVOLUCIÓN (PUT/PATCH)
    @PatchMapping("/devolver/{id}")
    public ResponseEntity<PrestamoDTO> registrarDevolucion(@PathVariable(name = "id") Long id) {
        PrestamoDTO prestamoActualizado = prestamoService.registrarDevolucion(id);
        return ResponseEntity.ok(prestamoActualizado); // 200 OK
    }

    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> obtenerPorId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(prestamoService.obtenerPrestamoPorId(id));
    }

    //  Obtener Todos (GET)
    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> obtenerTodos() {
        return ResponseEntity.ok(prestamoService.obtenerTodosLosPrestamos());
    }

    // NOTA: No implementamos un PUT genérico o DELETE, ya que las operaciones clave
    // son CREAR y DEVOLVER.
}