package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.enums.ROL_MIEMBRO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoConParticipantesDTO {
    private Long id;
    private String nombre;
    private String icono;
    private String codigoInvitacion;
    private ROL_MIEMBRO rol;
    private long cantidadParticipantes;
}
