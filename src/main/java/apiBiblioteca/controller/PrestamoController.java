package apiBiblioteca.controller;

import apiBiblioteca.model.Prestamo;
import apiBiblioteca.service.PrestamoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping("/crear/{idLibro}/{idUsuario}")
    public Prestamo crearPrestamo(@PathVariable Long idLibro, @PathVariable Long idUsuario) {
        return prestamoService.crearPrestamo(idLibro, idUsuario); 
    }

    @PutMapping("/devolver/{idPrestamo}")
    public Prestamo devolverPrestamo(@PathVariable Long idPrestamo) {
        return prestamoService.devolverPrestamo(idPrestamo);
    }

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.listarPrestamos();
    }
}