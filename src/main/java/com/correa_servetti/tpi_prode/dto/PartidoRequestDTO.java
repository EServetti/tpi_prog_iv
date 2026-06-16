package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.Equipo;
import com.correa_servetti.tpi_prode.models.Fecha;
import com.correa_servetti.tpi_prode.models.enums.ESTADO_PARTIDO;
import com.correa_servetti.tpi_prode.models.enums.TENDENCIA_PARTIDO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidoRequestDTO {
    @NotNull(message = "Ingrese la fecha de inicio")
    LocalDate fechaInicio;

    @NotNull(message = "Ingresa la fecha")
    Fecha fecha;

    @NotNull(message = "Ingrese el equipo local")
    Equipo equipoLocal;

    @NotNull(message = "Ingrese el equipo visitante")
    Equipo equipoVisitante;

    int golesLocal = 0;

    int golesVisitante = 0;

    ESTADO_PARTIDO estadoPartido = ESTADO_PARTIDO.POR_JUGARSE;

    TENDENCIA_PARTIDO tendenciaPartido = TENDENCIA_PARTIDO.EMPATE;
}
