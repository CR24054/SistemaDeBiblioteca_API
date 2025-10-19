package apiBiblioteca.service;

import apiBiblioteca.model.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
}