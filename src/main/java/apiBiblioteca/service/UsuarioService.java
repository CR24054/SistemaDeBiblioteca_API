package apiBiblioteca.service;

import apiBiblioteca.dto.UsuarioDTO;


public interface UsuarioService {

    // Crear (POST)
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDto);

    // Leer uno por ID (GET por ID)
    UsuarioDTO obtenerUsuarioPorId(Long id);

    // Leer todos (GET ALL)
    java.util.List<UsuarioDTO> obtenerTodosLosUsuarios();

    // Actualizar (PUT)
    UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDto);

    // Eliminar (DELETE)
    void eliminarUsuario(Long id);
}