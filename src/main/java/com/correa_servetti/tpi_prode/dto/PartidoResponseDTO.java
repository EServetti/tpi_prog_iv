package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.Equipo;
import com.correa_servetti.tpi_prode.models.Fecha;
import com.correa_servetti.tpi_prode.models.enums.ESTADO_PARTIDO;
import com.correa_servetti.tpi_prode.models.enums.TENDENCIA_PARTIDO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidoResponseDTO {
    @NotNull
    Long id;

    @NotNull
    LocalDateTime fechaInicio;

    @NotNull
    int golesLocal;

    @NotNull
    int golesVisitante;

    @NotBlank
    ESTADO_PARTIDO estado;

    @NotBlank
    TENDENCIA_PARTIDO tendencia;

    @NotNull
    Fecha fecha;

    @NotNull
    Equipo equipoLocal;

    @NotNull
    Equipo equipoVisitante;
}
