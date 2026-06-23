package com.correa_servetti.tpi_prode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarGrupoRequestDTO {
    private String nombre;
    private String icono;
    private String codigoInvitacion;
}
