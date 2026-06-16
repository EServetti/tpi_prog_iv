package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.enums.ROL;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {
    @NotNull(message = "Ingrese el email")
    @NotBlank(message = "Ingrese el email")
    String email;

    @NotNull(message = "Ingrese la contraseña")
    @NotBlank(message = "Ingrese la contraseña")
    String password;

    @NotNull(message = "Ingrese el nombre de usuario")
    @NotBlank(message = "Ingrese el nombre de usuario")
    String nombreUsuario;

    ROL rol = ROL.USUARIO;

    LocalDate fechaRegistro =  LocalDate.now();
}
