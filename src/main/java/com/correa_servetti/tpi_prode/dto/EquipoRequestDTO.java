package com.correa_servetti.tpi_prode.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EquipoRequestDTO {
    @NotBlank(message = "Debes ingresar el nombre del equipo.")
    private String nombre;
}

