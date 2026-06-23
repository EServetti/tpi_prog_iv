package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteGrupoDTO {
    private MiembroGrupo miembro;
    private long puntos;
    private long resultadosExactos;
}
