package com.correa_servetti.tpi_prode.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearPronosticoRequestDTO {
    private Long usuarioId;
    private Long partidoId;
    private Integer golesLocal;
    private Integer golesVisitante;
}
