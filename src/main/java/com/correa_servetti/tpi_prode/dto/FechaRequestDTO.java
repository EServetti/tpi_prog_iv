package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.enums.ESTADO_FECHA;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class FechaRequestDTO {
    ESTADO_FECHA estado = ESTADO_FECHA.PROGRAMADA;
}
