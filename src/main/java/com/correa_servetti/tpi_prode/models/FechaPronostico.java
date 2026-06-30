package com.correa_servetti.tpi_prode.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FechaPronostico {
    private Integer fechaId;

    private Long partidoId;

    private LocalDateTime fechaPronostico;
}
