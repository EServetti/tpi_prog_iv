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
public class UsuarioResponseDTO {
    @NotNull
    Long id;

    @NotBlank
    String email;

    @NotBlank
    String password;

    @NotBlank
    String nombreUsuario;

    @NotBlank
    ROL rol;

    @NotBlank
    LocalDate fechaRegistro;
}
