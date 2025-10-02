package apiBiblioteca.controller;

import apiBiblioteca.dto.UsuarioDTO;
import apiBiblioteca.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crea Usuario (POST)
    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDto) {
        // esto asegura de que el nombre, email, y carnet no estén vacíos.
        UsuarioDTO nuevoUsuario = usuarioService.crearUsuario(usuarioDto);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED); // 201 Created
    }

    // Obtener Todos (GET)
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios); // 200 OK
    }

    // Obtener por ID (GET por ID)
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerPorId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    // Actualizar Usuario (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(
            @Valid @RequestBody UsuarioDTO usuarioDto,
            @PathVariable(name = "id") Long id) {

        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioDto);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK); // 200 OK
    }

    // Eliminar Usuario (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable(name = "id") Long id) {
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>("Usuario eliminado con éxito.", HttpStatus.OK); // 200 OK
    }
}