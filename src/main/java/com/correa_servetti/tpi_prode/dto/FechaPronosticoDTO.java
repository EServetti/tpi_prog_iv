package com.correa_servetti.tpi_prode.dto;

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
public class FechaPronosticoDTO {
    @NotNull
    Integer fechaId;

    @NotNull
    Long partidoId;

    @NotNull
    LocalDateTime fechaPronostico;
}
