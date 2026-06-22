package com.correa_servetti.tpi_prode.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CrearPartidoRequestDTO {
    private Long equipoLocalId;
    private Long equipoVisitanteId;
    private Integer fechaId;
    private LocalDateTime fechaInicio;
}
