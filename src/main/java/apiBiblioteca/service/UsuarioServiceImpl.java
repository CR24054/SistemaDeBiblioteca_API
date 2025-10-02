package apiBiblioteca.service;

import apiBiblioteca.dto.UsuarioDTO;
import apiBiblioteca.exception.RecursoNoEncontradoException;
import apiBiblioteca.model.Usuario;
import apiBiblioteca.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // --- MÉTODOS DE CONVERSIÓN debe implementar la lógica aquí ---

    private UsuarioDTO mapToDTO(Usuario usuario) {
        // Convierte Entidad (Model) a DTO (para la salida)
        return null;
    }

    private Usuario mapToEntity(UsuarioDTO usuarioDto) {
        // Convierte DTO (datos de entrada) a Entidad (Model)
        return null;
    }

    //  debe implementar la lógica de negocio en cada uno

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDto) {
        // Llama a mapToEntity, luego a usuarioRepository.save(), y mapToDTO
        return null;
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        // Implementar la búsqueda, usando .orElseThrow() con RecursoNoEncontradoException
        throw new RecursoNoEncontradoException("Lógica de búsqueda pendiente.");
    }

    @Override
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        // Implemente usuarioRepository.findAll() y convertir la List<Usuario> a List<UsuarioDTO>
        return List.of();
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDto) {
        //Implemente la lógica: buscar existente, actualizar datos, y guardar (save)
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {
        // Implemente la lógica: buscar por ID y luego llamar a usuarioRepository.delete()
        throw new UnsupportedOperationException("Lógica de eliminación pendiente.");
    }
}