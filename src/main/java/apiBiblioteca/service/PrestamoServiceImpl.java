package apiBiblioteca.service;

import apiBiblioteca.model.Libro;
import apiBiblioteca.model.Prestamo;
import apiBiblioteca.model.Usuario;
import apiBiblioteca.repository.LibroRepository;
import apiBiblioteca.repository.PrestamoRepository;
import apiBiblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;
    private final UsuarioRepository usuarioRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository, LibroRepository libroRepository, UsuarioRepository usuarioRepository) {
        this.prestamoRepository = prestamoRepository;
        this.libroRepository = libroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Prestamo crearPrestamo(Long idLibro, Long idUsuario) {
        Libro libro = libroRepository.findById(idLibro)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        if (!libro.isDisponible()) {
            throw new IllegalStateException("El libro ya está prestado");
        }

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setUsuario(usuario);
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setEstado("activo");

        libro.setDisponible(false);
        libroRepository.save(libro);

        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo devolverPrestamo(Long idPrestamo) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        if (prestamo.getEstado().equals("devuelto")) {
            throw new IllegalStateException("Este préstamo ya fue devuelto");
        }

        prestamo.setEstado("devuelto");
        prestamo.setFechaDevolucion(LocalDate.now());

        Libro libro = prestamo.getLibro();
        libro.setDisponible(true);
        libroRepository.save(libro);

        return prestamoRepository.save(prestamo);
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }
}