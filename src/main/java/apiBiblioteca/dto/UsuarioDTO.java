package apiBiblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;

    @NotBlank(message = "El nombre es obligatorio y no puede estar vacío.")
    @Size(max = 100, message = "El nombre no debe exceder los 100 caracteres.")
    private String nombre;

    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "Debe ingresar un formato de correo electrónico válido.")
    private String email;

    @NotBlank(message = "El carnet es obligatorio.")
    @Size(min = 5, max = 20, message = "El carnet debe tener entre 5 y 20 caracteres.")
    private String carnet;

}
