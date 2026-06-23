package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.enums.ESTADO_PARTIDO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ActualizarPartidoRequestDTO {
    private Integer fechaId;
    private LocalDateTime fechaInicio;
    private Integer golesLocal;
    private Integer golesVisitante;
    private ESTADO_PARTIDO estado;
}
