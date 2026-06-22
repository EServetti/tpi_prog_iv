package com.correa_servetti.tpi_prode.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class GrupoRequestDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String icono;

    @NotBlank
    private String codigoInvitacion;
}
